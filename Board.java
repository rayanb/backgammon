import java.util.Arrays;
import java.util.Random;

// points 0 and 25 designated as the bar
// makes sense, as pieces transferred off the bar "move" based on the die roll
// with a target point equal to the die roll
// for pieces trying to bear off, needs a special check to move to 0/25
// and a way to avoid Array Index Out Of Bounds exception

// Player 1 (white) is trying to go to 25
// Player 2 (black) is trying to go to 0

public class Board {
   public Point[] points;
   public int[] score;

   public Board() {
      this.points = new Point[26];
      Arrays.fill(this.points, new Point(this));
      Controller.rng = new Random();
      score = new int[]{0, 0};
   }

   public void populatePoints() {
      for (int i = 0; i < 26; i++) {
         points[i].position = i;
         System.out.println(points[i].position);
         switch (i) {
            case 1:
               points[i].populate("player1", 2);
               break;
            case 6:
               points[i].populate("player2", 5);
               break;
            case 8:
               points[i].populate("player2", 3);
               break;
            case 12:
               points[i].populate("player1", 5);
               break;
            case 13:
               points[i].populate("player2", 5);
               break;
            case 17:
               points[i].populate("player1", 3);
               break;
            case 19:
               points[i].populate("player1", 5);
               break;
            case 24:
               points[i].populate("player2", 2);
               break;
            default:
               points[i].populate(null, 0);
               break;
         }
         points[i].isVulnerable();
      }
   }

   public int isEndstate() {
      if (score[0] == 15)
         return 0;
      else if (score[1] == 15)
         return 1;
      else
         return -1;
   }
}