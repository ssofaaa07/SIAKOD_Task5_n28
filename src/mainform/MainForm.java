package mainform;

import utils.JTableUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

public class MainForm extends JFrame{
    private JTable tableTask;
    private JPanel panel;
    private JButton buttonTask;
    private JTextPane panelText;
    private JScrollPane scrollPanel;
    private JTextPane panelIf;
    private JPanel panelField;
    private JButton buttonDrawField;

    private int[][] fieldMatrix = new int[8][8];

    public MainForm() {
        this.setContentPane(panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setLocation(100, 100);
//        this.setLocationRelativeTo(null);
        this.pack();
        this.setSize(520,800);

        JTableUtils.initJTableForArray(tableTask, 25, true, true, true, true);
        tableTask.setRowHeight(25);
        scrollPanel.setPreferredSize(new Dimension(-1, 90));
        fieldMatrix = new int[][]{
                {0, 0, 1, 1, 1, 0, 0, 1},
                {1, 0, 1, 0, 0, 0, 0, 1},
                {0, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 2, 0, 1, 0},
                {0, 1, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1, 1, 0},};

        JTableUtils.writeArrayToJTable(tableTask, fieldMatrix);

        buttonDrawField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    fieldMatrix = JTableUtils.readIntMatrixFromJTable(tableTask);
                } catch (ParseException ex) {
                    throw new RuntimeException(ex);
                }
                ((PanelField) panelField).setTableField(fieldMatrix);
                panelField.repaint();
            }
        });
    }

    private void createUIComponents() {
        panelField = new PanelField();
    }
}
