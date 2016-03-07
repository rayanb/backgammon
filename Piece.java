public class Piece{
    public int position;
    public String player;
    public ArrayList possibleMoves;

    public Piece(int position) {
        this.position = position;
        this.board = board;
        this.possibleMoves = calculatePossibleMoves();
    }

    public static ArrayList calculatePossibleMoves(Board board){
      ArrayList moves = new ArrayList;
      for(point : board.points){
        if(point.canBeAttacked == true && !point.player.equals(this.player) && respectsDirection(point.position)){
          moves.add(point.position);
        }
      }
      return moves;
    }

    public static boolean respectsDirection(int newPosition){
      if(this.player == "player1" && this.position < newPosition){
        return true;
      }
      else if(this.player == "player2" && this.position > newPosition){
        return true;
      }
      else{
        return false;
      }
    }


}


position : 1

player 1 : 2, 3, 4 ....
player 2 : 0