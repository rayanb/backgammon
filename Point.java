import java.util.ArrayList;

public class Point {
   public Board board;
   public boolean isVulnerable;
   public ArrayList<Piece> pieces;
   public int position;

   public Point(Board board) {
      this.board = board;
      this.isVulnerable = false;
      this.pieces = new ArrayList<>();
   }

   public boolean isVulnerable() {
      if (this.pieces.size() > 1)
         return setIsVulnerable(false);
      else
         return setIsVulnerable(true);
   }

   public boolean setIsVulnerable(boolean isVulnerable) {
      this.isVulnerable = isVulnerable;
      return this.isVulnerable;
   }

   public void populate(String player, int numOfPieces) {
      for (int i = 0; i < numOfPieces; i++) {
         Piece newPiece = new Piece(this, player);
         this.pieces.add(newPiece);
      }
   }


   public void movePiece(int distance) throws InvalidDestinationException, NonexistentPieceException {
      Piece pieceToMove;
      if (this.pieces.size() > 0) {
         pieceToMove = this.pieces.get(this.pieces.size() - 1);
         Piece.calculatePossibleMoves(pieceToMove);
         int destination = pieceToMove.point.position + distance;
         Point destinationPoint = board.points[destination];
         if (pieceToMove.possibleMoves.contains(distance)) {
            this.pieces.remove(pieceToMove);
            pieceToMove.point = destinationPoint;
            if ((destinationPoint.pieces.size() != 0)
                    && (destination != 0)
                    && (destination != 25)) {
               Piece existingPiece = destinationPoint.pieces
                       .get(destinationPoint.pieces.size() - 1);
               if (!(pieceToMove.player.equals(existingPiece.player))) {
                  if (existingPiece.player.equals("player1"))
                     destinationPoint.movePiece(0);
                  else if (existingPiece.player.equals("player2"))
                     destinationPoint.movePiece(25);
                  destinationPoint.pieces.clear();
               }
            } else if((destination == 0) || (destination == 25)) {
               if(pieceToMove.player.equals("player1") && destination == 25)
                  board.score[0]++;
               else if (pieceToMove.player.equals("player2") && destination == 0)
                  board.score[1]++;
            } else
               destinationPoint.pieces.add(pieceToMove);
         } else
            throw new InvalidDestinationException(destination);
      } else
         throw new NonexistentPieceException(this.position);
   }

   public String getPlayer() {
      if(this.pieces.size() > 0) {
         return this.pieces.get(this.pieces.size() - 1).player;
      }
      else
         return null;
   }

   public class InvalidDestinationException extends Throwable {
      public int destination;
      public InvalidDestinationException(int destination) {
         this.destination = destination;
      }
   }

   public class NonexistentPieceException extends Throwable {
      public int position;
      public NonexistentPieceException(int position) {
         this.position = position;
      }
   }
}