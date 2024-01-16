package Project;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

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

        //Assigning scoring system for Easy difficulty
        if (selectedDifficulty == 1) {
            wordSize = 5;
            EXACT = 2;
            CLOSE = 1;
        }
        //Assigning scoring system for Medium difficulty
        else if (selectedDifficulty == 2) {
            wordSize = 6;
            EXACT = 3;
            CLOSE = 2;
        }
        //Assigning scoring system for Hard difficulty
        else {
            wordSize = 7;
            EXACT = 4;
            CLOSE = 3;
        }
        //Assigning filename based on users selected theme and difficulty
        //General Theme
        if (selectedTheme == 1) {
            if (selectedDifficulty == 1) {
                fileName = "General5.txt";
            } else if (selectedDifficulty == 2) {
                fileName = "General6.txt";
            } else {
                fileName = "General7.txt";
            }
        }
        //Nature Theme
        if (selectedTheme == 2) {
            if (selectedDifficulty == 1) {
                fileName = "Nature5.txt";
            } else if (selectedDifficulty == 2) {
                fileName = "Nature6.txt";
            } else {
                fileName = "Nature7.txt";
            }
        }
        //Science Theme
        if (selectedTheme == 3) {
            if (selectedDifficulty == 1) {
                fileName = "Science5.txt";
            } else if (selectedDifficulty == 2) {
                fileName = "Science6.txt";
            } else {
                fileName = "Science7.txt";
            }
        }
        //Declaring Array to store words from file
        String[] wordArray = new String[25];

        try {
            //Reading word file
            BufferedReader in = new BufferedReader(new FileReader("src/Project/" + fileName));
            String line = in.readLine();
            int i = 0;

            //Loops until end of file
            while (line != null && i < 25) {
                //Removes "\n" after each row
                wordArray[i] = line.trim();
                i++;
                line = in.readLine();
            }
        }
        //Handling error if file cannot be read
        catch (IOException e) {
            System.out.println("Error occurred reading from word file.");
        }
        //Selecting random word from wordArray
        Random rand = new Random();
        int n = rand.nextInt(25);
        String choice = wordArray[n];


        System.out.println(choice);
        //Storing number of guesses user has
        int guesses = 6;
        //Storing if user has won
        boolean won = false;

        Scanner input = new Scanner(System.in);
        System.out.println("--------------------");
        System.out.println("WordForge");
        System.out.println("--------------------");

        //Loops until user enters a value for name.
        String name = "";
        while (name.isEmpty()) {
            System.out.print("Enter your name: ");
            name = input.nextLine();
        }

        //Stores user's score
        int score = 0;

        //Loop until all user's guesses used— until end of game
        for (int i = 0; i < guesses; i++) {
            //Calls function to get user's guess
            String guess = get_guess(wordSize);
            //Stores status of each character in word
            int[] status = new int[wordSize];

            //Loop until status of for each character in word, stored initially as WRONG
            for (int k = 0; k < wordSize; k++) {
                status[k] = WRONG;
            }

            //Calls function to calculate user's score
            score = check_word(guess, score, status, choice, EXACT, CLOSE);
            //Display number of user's current guess
            System.out.println("Guess " + (i + 1) + ": ");
            //Calls function to print guess with visual feedback
            print_word(guess, wordSize, status, EXACT, CLOSE, WRONG);

            //Breaks game loop if user's guess matches word— ends game
            if (guess.equals(choice)) {
                won = true;
                score = score + (6 - i);
                break;
            }
        }

        //Display win message if user has won
        if (won) {
            System.out.println("You won! The word was " + choice);
            System.out.println("Your final score is " + score + ".");
        }
        //Display loss message if user has not won
        else {
            System.out.println("You did not win. The word was " + choice);
            System.out.println("Your final score is " + score + ".");
        }

        //Writes user's name, score to leaderboard file
        try {
            FileWriter out = new FileWriter("src/Project/leaderboard.txt", true);
            String leaderboardText = name + " , " + score + "\n";
            out.write(leaderboardText);
            out.close();
        } catch (IOException e) {
            System.out.println("Error writing to leaderboard file.");
        }

    }

    public static String get_guess(int wordSize) {
        String guess;

        Scanner input = new Scanner(System.in);
        int lengthGuess;

        //Loop until user's guess is appropriate length
        do {
            System.out.print("Enter a " + wordSize + "-letter word: ");
            guess = input.nextLine();
            lengthGuess = guess.length();
        } while (lengthGuess != wordSize);

        guess = guess.toLowerCase(); //Stores user's guess in lowercase

        return guess;
    }

    public static int check_word(String guess, int score, int[] status, String choice, int EXACT, int CLOSE) {
        boolean[] matched_letter = new boolean[choice.length()]; //Stores characters that are guessed correctly to prevent error with duplicate matches

        for (int p = 0; p < guess.length(); p++) { //Loop for each character in guess
            if (guess.charAt(p) == choice.charAt(p)) { //If current character in user's guess is equal to current character in word
                score = EXACT + score; //Assign points for EXACT
                status[p] = EXACT; //Change status of correct letter to EXACT
            } else {
                for (int j = 0; j < guess.length(); j++) { //Loop for each character in guess
                    if (!matched_letter[j] && guess.charAt(j) == choice.charAt(p)) { //If letter has not been guessed correctly and current character in user's guess is equal to current character in word
                        score = CLOSE + score; //Assign points for CLOSE
                        status[j] = CLOSE; //Change status of close letter to CLOSE
                        matched_letter[j] = true; //Change matched_letter to true to avoid duplicate matches
                        break; //Break from Inner loop
                    }
                }
            }
        }
        return score;
    }

    public static void print_word(String guess, int wordSize, int[] status, int EXACT, int CLOSE, int WRONG) {

        //Storing ANSI codes for visual feedback
        String GREEN = "\u001B[32m";
        String YELLOW = "\u001B[33m";
        String RED = "\u001B[31m";
        String RESET = "\u001B[0m";

        //Loop for each character in guess
        for (int l = 0; l < wordSize; l++) {
            if (status[l] == EXACT) {
                System.out.print(GREEN + guess.charAt(l) + RESET); //Displays character in green if guessed correctly
            } else if (status[l] == CLOSE) {
                System.out.print(YELLOW + guess.charAt(l) + RESET); //Displays character in yellow if almost guessed correctly
            } else if (status[l] == WRONG) {
                System.out.print(RED + guess.charAt(l) + RESET); //Displays character in red if guessed incorrectly
            }
        }
        System.out.print("\n"); //New line
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
        //Gets user's input for theme option
        int themeInput = input.nextInt();

        //Gets input until user's input matches theme options
        while (themeInput > 4 || themeInput < 1) {
            System.out.println("It seems like you have entered an invalid option. Please choose a valid option by entering the corresponding number.");
            themeInput = input.nextInt();
        }
        //Assigning theme as corresponding option
        if (themeInput == 1) {
            theme = 1;
        } else if (themeInput == 2) {
            theme = 2;
        } else if (themeInput == 3) {
            theme = 3;
            //Display message to user if theme is not selected
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
        //Gets user's input for difficulty option
        int difficultyInput = input.nextInt();

        //Gets input until user's input matches difficulty options
        while (difficultyInput > 4 || difficultyInput < 1) {
            System.out.println("It seems like you have entered an invalid option. Please choose a valid option by entering the corresponding number.");
            difficultyInput = input.nextInt();
        }
        //Assigning difficulty as corresponding option
        if (difficultyInput == 1) {
            difficulty = 1;
        } else if (difficultyInput == 2) {
            difficulty = 2;
        } else if (difficultyInput == 3) {
            difficulty = 3;
            //Display message to user if difficulty is not selected
        } else {
            System.out.println("Difficulty has not been selected.");
            return 0;
        }
        return difficulty;
    }

    public static void readLeaderboard() {
        //Stores the leaderboard lines
        List<String> list = new ArrayList<>();
        try {
            BufferedReader in = new BufferedReader(new FileReader("src/Project/leaderboard.txt"));
            String line = in.readLine();

            //Read each line of file until end and append to ArrayList
            while (line != null) {
                list.add(line);
                line = in.readLine();
            }

            //Method to sort ArrayList from highest to lowest score
            list.sort((s1, s2) -> {
                String[] score1 = s1.split(", ");
                String[] score2 = s2.split(", ");
                return Integer.parseInt(score2[1]) - Integer.parseInt(score1[1]); //Compares score1 and score2 and sorts from highest to lowest
            });

            //Displays each line of sorted leaderboard to user
            for (String item : list) {
                System.out.println(item);
            }
        } catch (Exception e) {
            System.out.println("Error reading from leaderboard file.");
        }
    }

    public static void leaderboard() {
        System.out.println("--------------------");
        System.out.println("Leaderboard");
        System.out.println("--------------------");

        //Calls function to Display sorted leaderboard
        readLeaderboard();

        Scanner input = new Scanner(System.in);
        System.out.println("2. Back- Return to the main menu.");
        System.out.print("Please Enter the number corresponding to your choice: ");
        //Gets user's input for leaderboard option
        int leaderboardInput = input.nextInt();

        //Gets input until user's input matches leaderboard option
        while (leaderboardInput != 2) {
            System.out.println("It seems like you have entered an invalid option. Please choose a valid option by entering the corresponding number.");
            leaderboardInput = input.nextInt();
        }
    }

    public static void main(String[] args) { //Main function with no theme and difficulty initially selected.
        mainMenu(0, 0);
    }
}
