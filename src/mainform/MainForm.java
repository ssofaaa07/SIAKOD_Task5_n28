package mainform;

import task5.AlgorithmFF;
import task5.CreateAdjMatrix;
import task5.OrientedGraph;
import utils.JTableUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainForm extends JFrame{
    private JTable tableTask;
    private JPanel panel;
    private JTextPane panelText;
    private JScrollPane scrollPanel;
    private JTextPane panelIf;
    private JPanel panelField;
    private JButton buttonStart;
    private JTextField textFieldResult;
    private String[][] fieldMatrix;

    private OrientedGraph graph;
    private CreateAdjMatrix createAdjMatrix;
    private AlgorithmFF algorithm;
    public String[][] getFieldMatrix() {
        return fieldMatrix;
    }

    public MainForm() {
        this.setContentPane(panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setLocation(100, 100);
        this.pack();
        this.setSize(520,700);

        JTableUtils.initJTableForArray(tableTask, 25, true, true, true, true);
        tableTask.setRowHeight(25);
        scrollPanel.setPreferredSize(new Dimension(-1, 90));
        fieldMatrix = new String[][]{
//                {"0", "0", "1"},
//                {"1", "2", "1"},
//                {"0", "0", "0"},
//        };
                {"0", "0", "1", "1", "1", "0", "0", "1"},
                {"1", "0", "1", "0", "0", "0", "0", "1"},
                {"0", "0", "0", "1", "0", "1", "0", "0"},
                {"0", "1", "0", "0", "2", "0", "1", "0"},
                {"0", "1", "0", "0", "0", "0", "0", "0"},
                {"0", "1", "1", "1", "1", "1", "1", "0"},};

        JTableUtils.writeArrayToJTable(tableTask, fieldMatrix);

        buttonStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fieldMatrix = JTableUtils.readStringMatrixFromJTable(tableTask);
                ((PanelField) panelField).setTableField(fieldMatrix);
                panelField.repaint();
                createAdjMatrix = new CreateAdjMatrix(fieldMatrix);
                graph = new OrientedGraph(createAdjMatrix.arrayToMatrixForGraph());
                algorithm = new AlgorithmFF(graph.getMatrix());
                textFieldResult.setText(Integer.toString(algorithm.maxFlow(0, graph.getMatrix().length - 1)));
            }
        });
    }

    private void createUIComponents() {
        panelField = new PanelField();
    }
}
