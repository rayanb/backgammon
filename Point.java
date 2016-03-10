import java.util.ArrayList;

public class Point {
    public Board board;
    public boolean isVulnerable;
    public String player;
    public ArrayList<Piece> pieces;
    public int position;

    public Point(ArrayList<Piece> startingPieces, int position, Board board) {

    }

    public boolean isVulnerable() {
        if (pieces.size() > 1)
            return setIsVulnerable(false);
        else
            return setIsVulnerable(true);
    }

    public boolean setIsVulnerable(boolean isVulnerable) {
        this.isVulnerable = isVulnerable;
        return this.isVulnerable;
    }
}