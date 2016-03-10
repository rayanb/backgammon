import java.util.ArrayList;

public class Piece{
    public int position;
    public String player;
    public ArrayList possibleMoves;

    public Piece(int position, Board board) {
        this.position = position;
        this.possibleMoves = calculatePossibleMoves(board);
    }

    public ArrayList<Integer> calculatePossibleMoves(Board board){
      ArrayList<Integer> moves = new ArrayList<>();
      for(Point pointToCheck : board.points){
        if(pointToCheck.canBeAttacked && !this.player.equals(pointToCheck.player) && this.respectsDirection(pointToCheck.position)){
          moves.add(pointToCheck.position);
        }
      }
      return moves;
    }

    public boolean respectsDirection(int newPosition){
      if(this.player.equals("player1") && this.position < newPosition){
        return true;
      }
      else if(this.player.equals("player2") && this.position > newPosition){
        return true;
      }
      else{
        return false;
      }
    }


}


// position : 1

// player 1 : 2, 3, 4 ....
// player 2 : 0