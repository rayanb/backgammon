import java.util.ArrayList;

public class Piece {
   public Board board;
   public Point point;
   public String player;
   public ArrayList<Integer> possibleMoves;

   public Piece(Point point, String player) {
      this.point = point;
      this.board = this.point.board;
      this.player = player;
      calculatePossibleMoves(this);
   }

   public static void calculatePossibleMoves(Piece pieceToMove) {
      ArrayList<Integer> moves = new ArrayList<>();
      for (Point pointToCheck : pieceToMove.board.points) {
         if ((pointToCheck.isVulnerable())
                 && !(pieceToMove.player.equals(pointToCheck.getPlayer()))
                 && (pieceToMove.respectsDirection(pointToCheck))) {
            moves.add(pointToCheck.position);
         }
      }
      pieceToMove.possibleMoves = moves;
   }

   public boolean respectsDirection(Point newPosition) {
      return ((this.player.equals("player1") && this.point.position < newPosition.position)
              || (this.player.equals("player2") && this.point.position > newPosition.position));
   }
}
