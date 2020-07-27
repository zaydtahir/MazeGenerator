import javax.swing.*;
import java.awt.*;

public class Graphics extends JPanel {

    int gridSize;

    public Graphics(){
        gridSize = MazeGenerator.gridSize;
    }

    public void paintComponent(java.awt.Graphics g){
        super.paintComponent(g);

        for (int i = 0; i < MazeGenerator.col; i++) {
            for (int j = 0; j < MazeGenerator.col; j++) {
                Cell c = MazeGenerator.cells[i][j];
                g.setColor(Color.black);
                if (c.left) g.drawLine(c.x*gridSize, c.y*gridSize, c.x*gridSize, c.y*gridSize + gridSize);
                if (c.right) g.drawLine(c.x*gridSize + gridSize, c.y*gridSize, c.x*gridSize +  gridSize, c.y*gridSize + gridSize);
                if (c.up) g.drawLine(c.x*gridSize, c.y*gridSize, c.x*gridSize + gridSize, c.y*gridSize);
                if (c.down) g.drawLine(c.x*gridSize, c.y*gridSize + gridSize, c.x*gridSize + gridSize, c.y*gridSize + gridSize);
                if (c == MazeGenerator.current) {
                    g.setColor(Color.red);
                    g.fillRect(c.x*gridSize, c.y*gridSize,  gridSize, gridSize);
                }
            }
        }
    }



}
