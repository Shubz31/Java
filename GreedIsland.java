import java.util.Scanner;
class Game {
    protected String playerName;

    public void start() {
        //ASCII Art
        System.out.println("""
                        \t IIIIIIII  IIIIIII  IIIIIIIIII IIIIIIIIII IIIIIIII          IIIIIIIIII IIIIIIIII II             II       III      II IIIIIIII
                                 II        II    II II         II         II      II            II     II        II            II II     II II    II II      II
                                 II        IIIIIII  IIIIIIII   IIIIIIII   II       II           II     IIIIIIIII II           II   II    II  II   II II       II
                                 II   IIII II II    II         II         II       II           II            II II          IIIIIIIII   II   II  II II       II 
                                 II    II  II  II   II         II         II      II            II            II II         II       II  II    II II II      II 
                                 IIIIIIII  II   II  IIIIIIIIII IIIIIIIIII IIIIIIII          IIIIIIIIII IIIIIIIII IIIIIIIII II         II II     IIII IIIIIIII""" //
        //
        //
        //
        //
        );
        System.out.println("Welcome to Greed Island!");
        System.out.println("Your mission is to find the treasure.");
    }

    public void end(String message) {
        System.out.println(message);
        System.out.println("Thank you for playing, " + playerName + "!");
    }
}

class TreasureIslandGame extends Game {    
    @SuppressWarnings("ConvertToStringSwitch")
    public void play() {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter your name: ");
            playerName = sc.nextLine();
            System.out.println("Hello, " + playerName + "! Let's begin your adventure.");
            
            boolean gameOver = false;
            
            while (!gameOver) {
                
                System.out.print("You're at a cross road. Where do you want to go? Type \"left\" or \"right\": \n");
                String choice1 = sc.nextLine().toLowerCase();
                
                if (choice1.equals("left")) {
                    
                    System.out.print("You came to a lake. There is an island in the middle of the lake. \nType \"wait\" to wait for a boat. Type \"swim\" to swim across: \n");
                    String choice2 = sc.nextLine().toLowerCase();
                    
                    if (choice2.equals("wait")) {
                        
                        System.out.print("You arrived at the island unharmed. \nThere is a house with 3 doors. One red, one yellow, and one blue. Which color do you choose? \n");
                        String choice3 = sc.nextLine().toLowerCase();
                        
                        if (choice3.equals("blue")) {
                            end("\nYou entered the room of beasts and got killed. Game Over!");
                            gameOver = true;
                        } else if (choice3.equals("yellow")) {
                            System.out.println("\nCongratulations! You entered the correct door, you have won the game and the treasure is yours.");
                            gameOver = true;
                        } else if (choice3.equals("red")) {
                            System.out.println("\nYou entered a room full of fire. Game Over!");
                            gameOver = true;
                        } else {
                            System.out.println("\nInvalid choice! You lost your way. Game Over!");
                            gameOver = true;
                        }
                    } else {
                        System.out.println("\nYou were eaten by crocodiles. Game Over!");
                        gameOver = true;
                    }
                } else if (choice1.equals("right")) {
                    System.out.println("\nYou fell into a hole. Game Over!");
                    gameOver = true;
                } else {
                    System.out.println("\nInvalid choice! You wandered off and got lost. Game Over!");
                    gameOver = true;
                }
                
                
                if (gameOver) {
                    System.out.print("\nDo you want to play again? (yes/no): ");
                    String retry = sc.nextLine().toLowerCase();
                    if (retry.equals("yes")) {
                        gameOver = false;
                    } else {
                        System.out.println("Goodbye, " + playerName + "!" + "Thank you for playing!");
                        gameOver = true;
                    } 
                }
            }
        }
    }
}
public class GreedIsland {
    public static void main(String[] args) {
        TreasureIslandGame game = new TreasureIslandGame();
        game.start();
        game.play();
    }
}

