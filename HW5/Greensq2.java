package MYCODE.HW5;
import javax.swing.JFrame;
import java.awt.*;

/**
 * Created by Patrick Evans
 * 2/24/2019
 * Use of "CenteredFrame" method from Dr. Lyon's ScreenMetrics.java
 */

public class Greensq2 extends JFrame {
    int xcoord;
    int ycoord;

    public Greensq2()
    {
        //JFrame window options being set
        setSize(200,200);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    //draw and color the rectangle
    public void paint(Graphics g)
    {
        g.drawRect(50,50,100,100);
        g.setColor(Color.GREEN);

        g.fillRect(50,50,100,100);
    }

    public void CenteredFrame(javax.swing.JFrame objFrame) {
        Dimension objDimension = Toolkit.getDefaultToolkit().getScreenSize();
        int iCoordX = (objDimension.width - objFrame.getWidth()) / 2;
        int iCoordY = (objDimension.height - objFrame.getHeight()) / 2;
        objFrame.setLocation(iCoordX, iCoordY);
    }

    public static void main(String[] args) {
        Greensq2 sq = new Greensq2();
        sq.CenteredFrame(sq);
    }
}