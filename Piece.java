import java.util.ArrayList;

public class Piece {
    public Point point;
    public String player;
    public ArrayList<Integer> possibleMoves;

    public Piece(Point point, String player) {
        this.point = point;
        this.player = player;
        calculatePossibleMoves();
    }

    public void calculatePossibleMoves() {
        Board board = this.point.board;
        ArrayList<Integer> moves = new ArrayList<>();
        for (Point pointToCheck : board.points) {
            if (pointToCheck.isVulnerable && !this.player.equals(pointToCheck.player) && this.respectsDirection(pointToCheck)) {
                moves.add(pointToCheck.position);
            }
        }
        this.possibleMoves =  moves;
    }

    public boolean respectsDirection(Point newPosition) {
        return ((this.player.equals("player1") && this.point.position < newPosition.position) || (this.player.equals("player2") && this.point.position > newPosition.position));
    }

}
