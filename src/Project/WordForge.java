package Project;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Random;
public class WordForge {
    public static void mainMenu(int theme, int difficulty) {
        boolean themeCheck = false;
        boolean difficultyCheck = false;

        int selectedTheme = theme;
        int selectedDifficulty = difficulty;

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
            int userInput = input.nextInt();


            while (userInput > 5 || userInput < 1) {
                System.out.println("It seems like you have entered an invalid option. Please choose a valid option by entering the corresponding number.");
                userInput = input.nextInt();
            }

            if (userInput == 1) {
                selectedTheme = themeOption();

                if (selectedTheme != 0) {
                    themeCheck = true;
                }
                System.out.println("theme: " + selectedTheme);
            } else if (userInput == 2) {
                selectedDifficulty = difficultyOption();
                if (selectedDifficulty != 0) {
                    difficultyCheck = true;
                }

                System.out.println("difficulty: " + selectedDifficulty);
            } else if (userInput == 3) {
                leaderboard();
            } else if (userInput == 4) {

                System.out.println("< theme: " + selectedTheme + " | difficulty: " + selectedDifficulty + " >");


                if (!themeCheck || !difficultyCheck) {
                    System.out.println("Oops! It seems you forgot to select a theme or difficulty. Before diving into the Project.WordForge adventure, please make sure to choose both a theme and difficulty level.");
                } else {

                    startGame(selectedTheme, selectedDifficulty);
                }
            } else if (userInput == 5) {
                System.out.println("Game ended");
                System.exit(0);
            }
        }
    }

    public static void startGame(int selectedTheme, int selectedDifficulty) {
        String fileName = "";
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

        String[] wordArray = new String[20];

        //ERROR HERE- CHOICE IS NULL
        try {
            BufferedReader in = new BufferedReader(new FileReader("src/Project/"+fileName));
            String line = in.readLine();
            int i = 25;

            while(line != null && i < 25) {
                wordArray[i] = line;
                i++;
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
        System.out.print("Enter your name: ");
        String name = input.nextLine();

        System.out.println("Enter a " + wordSize + "-letter word: ");

        int score = 0;

        for (int i = 0; i < guesses; i++) {
            String guess = get_guess(wordSize);
            int[] status = new int[wordSize];

            for (int o = 0; o < wordSize; o++) {
                status[o] = WRONG;
            }

            score = check_word(guess, wordSize, status, choice, EXACT, CLOSE);
            System.out.println("Guess " + (i+1) + ": ");
            print_word(guess, wordSize, status, EXACT, CLOSE, WRONG);

            if (score == EXACT * wordSize) {
                won = true;
                score = score + i;
                break;
            }
        }

        if (won) {
            System.out.println("You won! The word was " + choice);
            System.out.println("Your final score is " + score + ".");
        }
    }

    public static String get_guess(int wordSize) {
        String guess = "";

        Scanner input = new Scanner(System.in);
        int lengthGuess = 0;
        do {
            System.out.println("Enter a " + wordSize + "-letter word: ");
            guess = input.nextLine();
            lengthGuess = guess.length();
        }
        while (lengthGuess != wordSize);

        guess = guess.toLowerCase();

        return guess;
    }

    public static int check_word(String guess, int wordSize, int[] status, String choice, int EXACT, int CLOSE) {
        int score = 0;

        for (int p = 0, lengthGuess = guess.length(); p < lengthGuess; p++) {
            if (guess.charAt(p) == choice.charAt(p)) {
                score = EXACT + score;
                status[p] = EXACT;
            }
            else {
                for (int j = 0; j < lengthGuess; j++) {
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
                System.out.println(GREEN + guess.charAt(l) + RESET);
            }
            else if (status[l] == CLOSE) {
                System.out.println(YELLOW + guess.charAt(l) + RESET);
            }
            else if (status[l] == WRONG) {
                System.out.println(RED + guess.charAt(l) + RESET);
            }
        }
        return;
    }

    public static int themeOption() {
        int theme = 0;
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
        } else if (themeInput == 4) {
            System.out.println("Theme has not been selected.");
            return 0;
        }
        return theme;
    }

    public static int difficultyOption() {
        int difficulty = 0;
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
        } else if (difficultyInput == 4) {
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
