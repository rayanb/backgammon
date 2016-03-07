public class Point {

  public boolean canAttack;
  public String player;
  public ArrayList<Piece> pieces;
  public int position;

  public Point(ArrayList<Piece> pieces, int position){
    if(pieces){
      this.pieces = pieces;
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