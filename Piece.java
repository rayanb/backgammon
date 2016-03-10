import java.util.ArrayList;

public class Piece {
    public Point point;
    public String player;
    public ArrayList<Integer> possibleMoves;

    public Piece(Point point, Board board) {
        this.point = point;
        this.possibleMoves = calculatePossibleMoves(board);
    }

    public ArrayList<Integer> calculatePossibleMoves(Board board) {
        ArrayList<Integer> moves = new ArrayList<>();
        for (Point pointToCheck : board.points) {
            if (pointToCheck.isVulnerable() && !this.player.equals(pointToCheck.player) && this.respectsDirection(pointToCheck)) {
                moves.add(pointToCheck.position);
            }
        }
        return moves;
    }

    public boolean respectsDirection(Point newPosition) {
        return ((this.player.equals("player1") && this.point.position < newPosition.position) || (this.player.equals("player2") && this.point.position > newPosition.position));
    }

}


// point : 1

// player 1 : 2, 3, 4 ....
// player 2 : 0