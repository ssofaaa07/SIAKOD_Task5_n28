package task5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class OrientedGraph {

    int[][] matrix;

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public OrientedGraph(int[][] matrix) {
        this.matrix = matrix;
    }
}
