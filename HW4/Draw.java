package MYCODE;

import futils.Futil;
import futils.FutilBean;
import futils.ReaderUtil;
import java.io.File;
import java.awt.*;

/** Code to import and subsequently draw a CSV file
 * Created 2-19-2019 by Patrick Evans.
 * Assistance from Dr. Lyon's Csvparser.java and ReadFileExample.java
 */

public class Draw {

    public static void main(String args[]) {
        /**
         * Begin csv file import, store to string csv
         */
        FutilBean fb = FutilBean.restore();
        fb.setSwing(true);
        fb.save();
        File imp = Futil.getReadFile("Select a .CSV file for to be drawn");
        System.out.println(imp.getAbsolutePath());
        String csv = ReaderUtil.getFileAsOneBigString(imp);

        /**
         * Parse csv string to String array pointstr
         */
        String pointstr[] = csv.split("[\n ,]");

        /**
         * Parse string pointstr to integer array of allpoints
         */
        Integer allpoints[] = new Integer[pointstr.length];
        int j = 0;
        for (String str : pointstr) {
            allpoints[j] = Integer.parseInt(str.trim());
            j++;
        }

        /**
         * Call Class Testdraw and draw the imported csv
         */
        TestDraw td = new TestDraw();
        td.getter(allpoints);
        td.setSize(400, 400);
        td.setVisible(true);
    }
}

class TestDraw extends Frame {
    Graphics gr;
    int x, y;
    public Integer ap[];

    /**
     * Getter Method to pull array from Draw class
     */
    public void getter(Integer allpoints[]) {
        ap = allpoints.clone();
    }

    public void PU(int _x, int _y) {
        x = _x;
        y = _y;
    }
    public void PD(int _x, int _y) {
        drawLine(x,y,_x,_y);
        x = _x;
        y = _y;
    }
    public void drawLine(int x1, int y1, int x2, int y2) {
        int sf = 25;
        x1 = x1/sf;
        y1 = y1/sf;
        x2 = x2/sf;
        y2 = y2/sf;
        gr.drawLine(x1,y1,x2,y2);

    }
    public void paint(Graphics g) {
        gr = g;
        paint1();
    }

    public void paint1() {
        /**
         * Prevent errors if dataset is not divisible by 4
         */
        int runfor = ap.length - (ap.length%4);
        /**
         * Paint each corresponding csv value
         */
        for (int i=0; i < runfor; i=i+4){
            PD( ap[i], ap[i+1]);
            PU( ap[i+2], ap[i+3]);
        }
    }
}