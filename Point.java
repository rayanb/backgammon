import java.util.ArrayList;

public class Point {

  public boolean canAttack;
  public String player;
  public ArrayList<Piece> pieces;
  public int position;

  public Point(ArrayList<Piece> startingPieces, int position){
    if(startingPieces != null){
      this.pieces = startingPieces;
      this.player = pieces.get(0).player;
      this.canAttack = false;
    }
    else{
      this.player = null;
      this.canAttack = true;
    }
    this.position = position;
  }

}