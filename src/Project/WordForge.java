package Project;

import java.io.*;
import java.util.Scanner;
import java.util.Random;
public class WordForge {
    public static void mainMenu(int theme, int difficulty) {

        //Stores if Difficulty or Theme has been selected
        boolean themeCheck = false;
        boolean difficultyCheck = false;

        //Stores the selected Theme/Difficulty to pass to main game
        int selectedTheme = theme;
        int selectedDifficulty = difficulty;

        //Loops until Start or Quit is selected.
        while (true) {
            Scanner input = new Scanner(System.in);
            System.out.println("--------------------");
            System.out.println("Welcome to WordForge");
            System.out.println("--------------------");
            System.out.println("1. Theme- Select a theme for your word puzzle adventure.");
            System.out.println("2. Difficulty- Choose the difficulty level for a challenging experience.");
            System.out.println("3. Leaderboard- View the top players and their scores.");
            System.out.println("4. Start- Begin your Project.WordForge adventure!");
            System.out.println("5. Quit.");
            System.out.print("Please Enter the number corresponding to your choice: ");
            //Gets input for Menu Option
            int userInput = input.nextInt();

            //Gets input until user's input matches menu options
            while (userInput > 5 || userInput < 1) {
                System.out.println("It seems like you have entered an invalid option. Please choose a valid option by entering the corresponding number.");
                userInput = input.nextInt();
            }


            //Calls themeOption if user selects corresponding option
            if (userInput == 1) {
                selectedTheme = themeOption();

                if (selectedTheme != 0) {
                    //Changes check if user selects a theme
                    themeCheck = true;
                }
                //Display user's selected theme
                System.out.println("Theme: " + selectedTheme);


                //Calls difficultyOption if user selects corresponding option
            } else if (userInput == 2) {
                selectedDifficulty = difficultyOption();
                if (selectedDifficulty != 0) {
                    //Changes check if user selects a difficulty
                    difficultyCheck = true;
                }
                //Display user's selected difficulty
                System.out.println("Difficulty: " + selectedDifficulty);


                //Calls leaderboard if user selects corresponding option
            } else if (userInput == 3) {
                leaderboard();


                //Calls startGame if user selects corresponding option
            } else if (userInput == 4) {
                //Display user's selected theme and difficulty before game starts
                System.out.println("[Theme: " + selectedTheme + " | Difficulty: " + selectedDifficulty + "]");
                //Checks if user has selected theme and difficulty
                if (!themeCheck || !difficultyCheck) {
                    System.out.println("Oops! It seems you forgot to select a theme or difficulty. Before diving into the WordForge adventure, please make sure to choose both a theme and difficulty level.");
                } else {
                    //Calls startGame
                    startGame(selectedTheme, selectedDifficulty);
                }

                ////Quits program if user selects corresponding option
            } else {
                System.out.println("Exiting Game...");
                System.exit(0);
            }
        }
    }

    public static void startGame(int selectedTheme, int selectedDifficulty) {
        //Stores name of file to be opened
        String fileName = "";

        //Declaring Variables
        int wordSize, EXACT, CLOSE, WRONG = 0;

        if (selectedDifficulty == 1) {
            wordSize = 5;
            EXACT = 2;
            CLOSE = 1;
        }
        else if (selectedDifficulty == 2) {
            wordSize = 6;
            EXACT = 3;
            CLOSE = 2;
        }
        else {
            wordSize = 7;
            EXACT = 4;
            CLOSE = 3;
        }

        if (selectedTheme == 1) {
            if (selectedDifficulty == 1) {
                fileName = "General5.txt";
            }
            else if (selectedDifficulty == 2) {
                fileName = "General6.txt";
            }
            else {
                fileName = "General7.txt";
            }
        }

        if (selectedTheme == 2) {
            if (selectedDifficulty == 1) {
                fileName = "Nature5.txt";
            }
            else if (selectedDifficulty == 2) {
                fileName = "Nature6.txt";
            }
            else {
                fileName = "Nature7.txt";
            }
        }

        if (selectedTheme == 3) {
            if (selectedDifficulty == 1) {
                fileName = "Science5.txt";
            }
            else if (selectedDifficulty == 2) {
                fileName = "Science6.txt";
            }
            else {
                fileName = "Science7.txt";
            }
        }

        String[] wordArray = new String[25];

        try {
            BufferedReader in = new BufferedReader(new FileReader("src/Project/" + fileName));
            String line = in.readLine();
            int i = 0;

            while(line != null && i < 25) {
                wordArray[i] = line.trim();
                i++;
                line = in.readLine();
            }
        }
        catch (IOException e) {
            System.out.println("Error occurred reading from file.");
        }

        Random rand = new Random();
        int n = rand.nextInt(25);
        String choice = wordArray[n];


        System.out.println(choice);
        int guesses = 6;
        boolean won = false;

        Scanner input = new Scanner(System.in);
        System.out.println("--------------------");
        System.out.println("WordForge");
        System.out.println("--------------------");

        String name = "";
        while (name.isEmpty()) {
            System.out.print("Enter your name: ");
            name = input.nextLine();
        }

        int score = 0;

        for (int i = 0; i < guesses; i++) {
            String guess = get_guess(wordSize);
            int[] status = new int[wordSize];

            for (int k = 0; k < wordSize; k++) {
                status[k] = WRONG;
            }

            score = check_word(guess, score, status, choice, EXACT, CLOSE);
            System.out.println("Guess " + (i+1) + ": ");
            print_word(guess, wordSize, status, EXACT, CLOSE, WRONG);

            if (guess.equals(choice)) {
                won = true;
                score = score + (6-i);
                break;
            }
        }

        if (won) {
            System.out.println("You won! The word was " + choice);
            System.out.println("Your final score is " + score + ".");
        }
        else {
            System.out.println("You did not win. The word was " + choice);
            System.out.println("Your final score is " + score + ".");
        }

        class leaderboard {
            public String name = "";
            public int score = 0;
        }

        leaderboard leaderboard1 = new leaderboard();
        leaderboard1.name = name;
        leaderboard1.score = score;

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("src/Project/leaderboard.txt"));
            String leaderboardText = "Name: " + leaderboard1.name + ", Score: " + leaderboard1.score;
            writer.write(leaderboardText);
        }
        catch (IOException e) {
            System.out.println("Error writing to leaderboard file.");
        }
    }

    public static String get_guess(int wordSize) {
        String guess;

        Scanner input = new Scanner(System.in);
        int lengthGuess;
        do {
            System.out.print("Enter a " + wordSize + "-letter word: ");
            guess = input.nextLine();
            lengthGuess = guess.length();
        }
        while (lengthGuess != wordSize);

        guess = guess.toLowerCase();

        return guess;
    }

    public static int check_word(String guess, int score, int[] status, String choice, int EXACT, int CLOSE) {
        for (int p = 0; p < guess.length(); p++) {
            if (guess.charAt(p) == choice.charAt(p)) {
                score = EXACT + score;
                status[p] = EXACT;
            }
            else {
                for (int j = 0; j < guess.length(); j++) {
                    if (guess.charAt(j) == choice.charAt(p)) {
                        score = CLOSE + score;
                        status[p] = CLOSE;
                        break;
                    }
                }
            }
        }
        return score;
    }

    public static void print_word(String guess, int wordSize, int[] status, int EXACT, int CLOSE, int WRONG) {

        String GREEN = "\u001B[32m";
        String YELLOW = "\u001B[33m";
        String RED = "\u001B[31m";
        String RESET = "\u001B[0m";

        for (int l = 0; l < wordSize; l++) {
            if (status[l] == EXACT) {
                System.out.print(GREEN + guess.charAt(l) + RESET);
            }
            else if (status[l] == CLOSE) {
                System.out.print(YELLOW + guess.charAt(l) + RESET);
            }
            else if (status[l] == WRONG) {
                System.out.print(RED + guess.charAt(l) + RESET);
            }
        }
        System.out.print("\n");
    }

    public static int themeOption() {
        int theme;
        Scanner input = new Scanner(System.in);
        System.out.println("--------------------");
        System.out.println("Theme Settings");
        System.out.println("--------------------");
        System.out.println("1. General- Explore a word puzzle adventure with a general theme.");
        System.out.println("2. Nature- Immerse yourself in nature-themed word challenges.");
        System.out.println("3. Science- Embark on a scientific journey through word puzzles.");
        System.out.println("4. Back- Return to the main menu.");
        System.out.print("Please Enter the number corresponding to your choice: ");
        int themeInput = input.nextInt();

        while (themeInput > 4 || themeInput < 1) {
            System.out.println("It seems like you have entered an invalid option. Please choose a valid option by entering the corresponding number.");
            themeInput = input.nextInt();
        }
        if (themeInput == 1) {
            theme = 1;
        } else if (themeInput == 2) {
            theme = 2;
        } else if (themeInput == 3) {
            theme = 3;
        } else {
            System.out.println("Theme has not been selected.");
            return 0;
        }
        return theme;
    }

    public static int difficultyOption() {
        int difficulty;
        Scanner input = new Scanner(System.in);
        System.out.println("--------------------");
        System.out.println("Difficulty Settings");
        System.out.println("--------------------");
        System.out.println("1. Easy- Words of length 5 for a relaxed word puzzle experience.");
        System.out.println("2. Medium- Words of length 6 for a balanced and engaging challenge.");
        System.out.println("3. Hard- Words of length 7 for a more intense and difficult gameplay.");
        System.out.println("4. Back- Return to the main menu.");
        System.out.print("Please Enter the number corresponding to your choice: ");
        int difficultyInput = input.nextInt();

        while (difficultyInput > 4 || difficultyInput < 1) {
            System.out.println("It seems like you have entered an invalid option. Please choose a valid option by entering the corresponding number.");
            difficultyInput = input.nextInt();
        }

        if (difficultyInput == 1) {
            difficulty = 1;
        } else if (difficultyInput == 2) {
            difficulty = 2;
        } else if (difficultyInput == 3) {
            difficulty = 3;
        } else {
            System.out.println("Difficulty has not been selected.");
            return 0;

        }
        return difficulty;
    }

    public static void leaderboard() {
        System.out.println("--------------------");
        System.out.println("Leaderboard");
        System.out.println("--------------------");

        Scanner input = new Scanner(System.in);
        System.out.println("2. Back- Return to the main menu.");
        System.out.print("Please Enter the number corresponding to your choice: ");
        int leaderboardInput = input.nextInt();

        while (leaderboardInput != 2) {
            System.out.println("It seems like you have entered an invalid option. Please choose a valid option by entering the corresponding number.");
            leaderboardInput = input.nextInt();
        }
    }

    public static void main(String[] args) {
        mainMenu(0, 0);
    }
}
