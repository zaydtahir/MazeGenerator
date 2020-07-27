public class Cell {
    public final int x, y;
    public boolean left;
    public boolean right;
    public boolean up;
    public boolean down;
    public boolean visited;

    public Cell(int x, int y){
        this.x = x;
        this.y = y;
        left = true;
        right = true;
        up = true;
        down = true;
        visited = false;
    }


}
