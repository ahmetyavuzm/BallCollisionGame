public class Position {
    public int x;
    public int y;
    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }

    public Position offset(int x_offset, int y_offset){
        return new Position(
                this.x + x_offset,
                this.y + y_offset);
    }
}
