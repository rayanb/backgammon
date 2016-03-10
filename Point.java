import java.util.ArrayList;

public class Point {

    public boolean isVulnerable;
    public String player;
    public ArrayList<Piece> pieces;
    public int position;

    public Point(ArrayList<Piece> startingPieces, int position) {
        if (startingPieces != null) {
            this.pieces = startingPieces;
            this.player = pieces.get(0).player;
            this.setIsVulnerable(false);
        } else {
            this.player = null;
            this.setIsVulnerable(true);
        }
        this.position = position;
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