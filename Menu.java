import java.util.Scanner;
public class Menu {
    public void displayMainMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n" + "Please choose an option:");
            System.out.println("1. Play Game");
            System.out.println("2. Quit Game");

            int choice = scanner.nextInt();
            scanner.nextLine(); 
            switch (choice) {
                case 1:
                Game game = new Game();
                game.word = new Word(game.wordList.getRandomWord());
                game.startGame();
                    break;
                case 2:
                    running = false;
                    System.out.println("Thanks for playing "  + "!");
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
                    break;
            }
        }
        scanner.close();
    }


}

