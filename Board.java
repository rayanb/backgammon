import java.util.Arrays;

// points 0 and 25 designated as the bar
// makes sense, as pieces transferred off the bar "move" based on the die roll
// with a target point equal to the die roll
// for pieces trying to bear off, needs a special check to move to 0/25
// and a way to avoid Array Index Out Of Bounds exception

public class Board {
    public Point[] points;

    public Board(){
      this.points  = new Point[26];
      Arrays.fill(this.points, new Point(this));
    }

    public static void main(String[] args){
      Board hey = new Board();
      hey.populatePoints();
    }

    public void populatePoints(){
      int index = 0;
      for(Point point : this.points){
        point.position = index;
        switch(index){
          case 1:  point.populate("player1", 2);
                   break;
          case 5:  point.populate("player2", 5);
                   break;
          case 7:  point.populate("player2", 3);
                   break;
          case 12: point.populate("player1", 5);
                   break;
          case 13: point.populate("player2", 5);
                   break;
          case 17: point.populate("player1", 3);
                   break;
          case 19: point.populate("player1", 5);
                   break;
          case 24: point.populate("player2", 2);
                   break;
          default: point.populate(null, 0);
                   break;
        }
        point.isVulnerable();
        index++;
      }
    }

}

// (point.player.equals(this.player) || (!point.player.equals(this.player) && point.pieces.size() <= 1))