import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {

    Graphics graphics = new Graphics();

    public Frame() {
        this.setSize(1000, 1000);

        this.setPreferredSize(new Dimension(1000, 1030));
        this.pack();
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(graphics);
        this.setVisible(true);
    }
}
