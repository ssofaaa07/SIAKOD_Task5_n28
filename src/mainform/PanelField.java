package mainform;

import javax.swing.*;
import java.awt.*;

public class PanelField extends JPanel {

    public String[][] tableField;

    public final int SIZE_CELLS = 30;

    public PanelField(String[][] tableField) {
        this.tableField = tableField;
    }

    public PanelField() {
        if (tableField == null) {
            this.tableField = new String[][]{{"0"}};
        }
    }

    public void setTableField(String[][] tableField) {
        this.tableField = tableField;
    }

    @Override
    public void paintComponent(Graphics g) {
        this.setSize(SIZE_CELLS * tableField[0].length + 10, SIZE_CELLS * tableField.length + 10);
        g.setColor(new Color(100,100,100));
        if (tableField != null) {
            for (int row = 0; row <= tableField.length; row++) {
                g.drawLine(0, row * SIZE_CELLS, tableField[0].length * SIZE_CELLS, row * SIZE_CELLS);
            }
            for (int col = 0; col <= tableField[0].length; col++) {
                g.drawLine(col * SIZE_CELLS, 0, col * SIZE_CELLS, tableField.length * SIZE_CELLS);
            }

            for (int row = 0; row < tableField.length; row++) {
                for (int col = 0; col < tableField[0].length; col++) {
                    if (tableField[row][col].equals("1")) {
                        g.setColor(new Color(50, 50, 50));
                        g.fillRect(col * SIZE_CELLS, row * SIZE_CELLS, SIZE_CELLS, SIZE_CELLS);
                    }
                    if (tableField[row][col].equals("2")) {
                        g.setColor(new Color(10, 190, 10));
                        g.fillRect(col * SIZE_CELLS, row * SIZE_CELLS, SIZE_CELLS, SIZE_CELLS);
                    }
                }
            }
        }
    }
}
