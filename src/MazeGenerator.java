import java.util.ArrayList;
import java.util.Stack;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class MazeGenerator {


    private static Frame f;
    public static int gridSize = 100;
    public static Cell[][] cells;
    public static Stack<Cell> stack;
    private static boolean generationComplete;
    public static int col;
    public static Cell current;


    public static void main(String args[]) throws InterruptedException {
        f = new Frame();
        col = (int) Math.floor(f.getWidth()/gridSize);
        cells = new Cell[col][col];
        stack = new Stack<Cell>();
        generationComplete = false;

        for (int i = 0; i < col; i++) {
            for (int j = 0; j < col; j++) {
                cells[i][j] = new Cell(i, j);
            }
        }

        current = cells[0][0];
        current.visited = true;
        stack.push(current);

        while (!generationComplete){
            Thread.sleep(50);
            Cell neighbor = checkNeighbors(current);
            if (neighbor.x != -1) {
                neighbor.visited = true;
                removeWalls(current, neighbor);
                current = neighbor;
                stack.push(current);
            }
            else {
                current = stack.pop();
            }
            if (current == cells[0][0]) generationComplete = true;
            f.graphics.repaint();
        }

        current = new Cell(-1, -1);
        f.graphics.repaint();
    }

    private static void removeWalls(Cell c, Cell n) {
        int xDiff = n.x - c.x;
        int yDiff = n.y - c.y;

        if (xDiff == 1){
            c.right = false;
            n.left = false;
        }
        else if (xDiff == -1){
            c.left = false;
            n.right = false;
        }
        if (yDiff == 1){
            c.down = false;
            n.up = false;
        }
        else if (yDiff == -1){
            c.up = false;
            n.down = false;
        }
    }

    public static Cell checkNeighbors(Cell c){
        ArrayList<Cell> neighbors = new ArrayList<Cell>();

        if (c.y != 0) {
            if (!cells[c.x][c.y-1].visited) neighbors.add(cells[c.x][c.y-1]);
        }
        if (c.y != col - 1) {
            System.out.println(c.y);
            System.out.println(col-1);
            if (!cells[c.x][c.y+1].visited) neighbors.add(cells[c.x][c.y+1]);
        }
        if (c.x != 0) {
            if (!cells[c.x-1][c.y].visited) neighbors.add(cells[c.x-1][c.y]);
        }
        if (c.x != col - 1) {
            System.out.println(c.x);
            System.out.println(col-1);
            if (!cells[c.x+1][c.y].visited) neighbors.add(cells[c.x+1][c.y]);
        }

        if (neighbors.size() > 0){
            int randomNum = ThreadLocalRandom.current().nextInt(0, neighbors.size());
            return neighbors.get(randomNum);
        }
        else return new Cell(-1, -1);

    }


}
