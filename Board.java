public class Board {
    public Point[] points = new Point[26];
    // points 0 and 25 designated as the bar
    // makes sense, as pieces transferred off the bar "move" based on the die roll
    // with a target point equal to the die roll

    // for pieces trying to bear off, needs a special check to move to 0/25
    // and a way to avoid Array Index Out Of Bounds exception

}

// (point.player.equals(this.player) || (!point.player.equals(this.player) && point.pieces.size() <= 1))