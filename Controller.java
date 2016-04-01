import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class Controller {
   public static Board board;
   public static boolean whoseTurn;
   public static boolean gameOver;
   public static ArrayList<Integer> diceRoll;
   public static Random rng;

   public static void newGame() {
      board = new Board();
      board.populatePoints();
      getStartingPlayer();
      rng = new Random();
   }

   public static void getUserInput() {
      if (board.isEndstate() == 0) {
         System.out.println("Game over. Player 1 wins by bearing off all their checkers.");
         gameOver = true;
      } else if (board.isEndstate() == 1) {
         System.out.println("Game over. Player 2 wins by bearing off all their checkers.");
         gameOver = true;
      } else {
         if (whoseTurn)
            System.out.println("It is white's turn");
         else
            System.out.println("It is black's turn");
         System.out.println("What action will you take? (QUIT or MOVE)");
         String initialInput = EasyIn.getString();
         while (!(initialInput.equalsIgnoreCase("QUIT")) && !(initialInput.equalsIgnoreCase("MOVE"))) {
            System.out.println("Invalid input. Must be QUIT or MOVE (case-insensitive).");
            initialInput = EasyIn.getString();
         }
         if (initialInput.equalsIgnoreCase("QUIT")) {
            if (whoseTurn) {
               System.out.println("Game over. Black wins by white's resignation.");
               gameOver = true;
            } else {
               System.out.println("Game over. White wins by black's resignation.");
               gameOver = true;
            }
         } else if ((initialInput.equals("MOVE")) || initialInput.equals("move")) {
            try {
               System.out.println("What piece are you moving (e.g. 5 or 13)? Input anything else to cancel move.");
               String moveOrigin = EasyIn.getString();
               Point originPoint = board.points[Integer.parseInt(moveOrigin)];
               System.out.println("Where are you moving the piece to? Input anything else to cancel move.");
               String moveEndpoint = EasyIn.getString();
               Point endPoint = board.points[Integer.parseInt(moveEndpoint)];
               if (diceRoll.contains(Math.abs(Integer.parseInt(moveOrigin) - Integer.parseInt(moveEndpoint)))) {
                  originPoint.movePiece(Integer.parseInt(moveOrigin) - Integer.parseInt(moveEndpoint));
                  whoseTurn = !whoseTurn;
                  rollDice();
               } else {
                  System.out.println("Did not enter point allowable by dice roll. Re-prompting user.");
               }
            } catch (NumberFormatException e) {
               System.out.println("Did not enter valid point. Re-prompting user. nfe");
            } catch (NullPointerException e) {
               System.out.println("Did not enter valid point. Re-prompting user. npe");
            } catch (ArrayIndexOutOfBoundsException e) {
               System.out.println("Did not enter valid point. Re-prompting user. aioobe");
            } catch (Point.InvalidDestinationException e) {
               System.out.println("Cannot move to target point as it is against the rules.");
            } catch (Point.NonexistentPieceException e) {
               System.out.println("Cannot move piece as it is does not exist.");
            }
         }
      }
   }

   public static void main(String[] args) {
      newGame();
      while (!gameOver) {
         getUserInput();
      }
   }

   public static void getStartingPlayer() {
      boolean winner = false;
      rollDice();
      while (!winner) {
         if (diceRoll.get(0) > diceRoll.get(1)) {
            winner = true;
            whoseTurn = true;
         } else if (diceRoll.get(1) > diceRoll.get(0)) {
            winner = true;
            whoseTurn = false;
         } else rollDice();
      }
   }

   public static void rollDice() {
      diceRoll = new ArrayList<Integer>();
      diceRoll.add(rng.nextInt(6) + 1);
      diceRoll.add(rng.nextInt(6) + 1);
      System.out.println("Rolled: " + diceRoll.get(0) + " and " + diceRoll.get(1));
   }
}