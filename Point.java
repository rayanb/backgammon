public class Point {

  public boolean canAttack;
  public String player;
  public ArrayList<Piece> pieces;
  public int position;

  public Point(ArrayList<Piece> startingPieces, int position){
    if(startingPieces){
      this.pieces = startingPieces;
      this.player = pieces.get(0).player;
      this.canAttack = False;
    }
    else{
      this.player = null;
      this.canAttack = True;
    }
    this.position = position;
  }

}