import java.util.ArrayList;

public class Point {
  public Board board;
  public boolean isVulnerable;
  public String player;
  public ArrayList<Piece> pieces;
  public int position;

  public Point(Board board) {
    this.board = board;
    this.isVulnerable = false;
    this.pieces = new ArrayList<Piece>();
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

  public void populate(String player, int numOfPieces){
    for(int i = 0; i< numOfPieces; i++){
      Piece newPiece = new Piece(this,player);
      this.pieces.add(newPiece);
    }
  }

}