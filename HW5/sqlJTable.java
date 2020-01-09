package MYCODE.HW5;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;

/**
 * Created by Patrick Evans
 * 2/24/2019
 * Code to display SQL table data in a JTable using swing
 * Includes use of Dr. Lyon's ReadSQLite.java
 */

public class sqlJTable extends JFrame{
    Object[][] data;
    DefaultTableModel tableModel;
    JTable table;
    String[] columns = {"ID", "NAME", "AGE", "ADDRESS", "SALARY"};

    public sqlJTable(String title) {
        super(title);
        setBounds(10,10,400,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /**
         *would pull data form ReadSQLite Class here, but the class does not return any data (per emails)
         */

        tableModel = new DefaultTableModel(data, columns);
        table = new JTable(tableModel);
        table.setAutoCreateRowSorter(true);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(380,200));
        JPanel panel = new JPanel();
        panel.add(scrollPane);
        add(panel,BorderLayout.CENTER);
    }
    public static void main(String[] args) {
        sqlJTable jtable = new sqlJTable("Jtable from SQL table");
        jtable.setVisible(true);
    }
}

