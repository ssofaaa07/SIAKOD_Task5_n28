package task5;

import java.util.ArrayDeque;

public class CreateAdjMatrix {

    public int[][] matrixForGraph;

    public String[][] fieldMatrix;

    public boolean[][] opened;

    public int[][] indexVertex;

    ArrayDeque<String[][]> que = new ArrayDeque<>();

    int countVertex = 0;

    public CreateAdjMatrix(String[][] fieldMatrix) {
        this.fieldMatrix = fieldMatrix;
    }

    public int[][] arrayToMatrixForGraph() {
        int countVertex = 0, row = 0, col = 0;
        for (int i = 0; i < fieldMatrix.length; i++) {
            for (int j = 0; j < fieldMatrix[0].length; j++) {
                if (fieldMatrix[i][j].equals("0") || fieldMatrix[i][j].equals("2")) {
                    countVertex++;
                    if (fieldMatrix[i][j].equals("2")) {
                        row = i;
                        col = j;
                    }
                }
            }
        }
        countVertex++;
        matrixForGraph = new int[countVertex * 2 - 2][countVertex * 2 - 2];
        opened = new boolean[countVertex][countVertex];
        for (int i = 0; i < opened.length; i++) {
            for (int j = 0; j < opened[0].length; j++) {
                opened[i][j] = false;
            }
        }
        indexVertex = new int[countVertex * 2 - 2][countVertex * 2 - 2];
        for (int i = 0; i < indexVertex.length; i++) {
            for (int j = 0; j < indexVertex[0].length; j++) {
                indexVertex[i][j] = -1;
            }
        }
        indexVertex[row][col] = 0;
        System.out.println(countVertex);
        System.out.println(row + " " + col);
        go(row, col);
        System.out.println(this.countVertex);
        return matrixForGraph;
    }

    public void go(int row, int col) {
//        if (!opened[row][col]) {
            if (countVertex == matrixForGraph.length - 1) {
                return;
            }
//            opened[row][col] = true;
            for (int i = row - 1; i <= row + 1; i += 2) {
                if (i >= 0 && i < fieldMatrix.length) {
                    if (fieldMatrix[i][col].equals("0") && !opened[i][col]) {
                        if (indexVertex[i][col] == -1) {
                            countVertex++;
                            indexVertex[i][col] = countVertex;
                        }
                        System.out.println(indexVertex[i][col]);
                        System.out.println(i + " " + col);
                        matrixForGraph[indexVertex[row][col]][indexVertex[i][col]] = 1;
                        matrixForGraph[indexVertex[i][col]][indexVertex[i][col] + 1] = 1;
                        if (countVertex < indexVertex[i][col] + 1) {
                            countVertex++;
                        }
                        if (i == 0 || i == fieldMatrix.length - 1 || col == 0 || col == fieldMatrix[0].length - 1) {
                            matrixForGraph[indexVertex[i][col] + 1][matrixForGraph.length - 1] = 1;
                        }
                        opened[i][col] = true;
                        que.add(new String[][]{{Integer.toString(i)}, {Integer.toString(col)}});
//                        go(i, col);
                    }
                }
            }
            for (int i = col - 1; i <= col + 1; i += 2) {
                if (i >= 0 && i < fieldMatrix[0].length) {
                    if (fieldMatrix[row][i].equals("0") && !opened[row][i]) {
                        if (indexVertex[row][i] == -1) {
                            countVertex++;
                            indexVertex[row][i] = countVertex;
                        }
                        System.out.println(indexVertex[row][i]);
                        System.out.println(row + " " + i + " .");
                        matrixForGraph[indexVertex[row][col]][indexVertex[row][i]] = 1;
                        matrixForGraph[indexVertex[row][i]][indexVertex[row][i] + 1] = 1;
                        if (countVertex < indexVertex[row][i] + 1) {
                            countVertex++;
                        }
                        if (i == 0 || i == fieldMatrix[0].length - 1 || row == 0 || row == fieldMatrix.length - 1) {
                            matrixForGraph[indexVertex[row][i] + 1][matrixForGraph.length - 1] = 1;
                        }
                        opened[row][i] = true;
                        que.add(new String[][]{{Integer.toString(row)}, {Integer.toString(i)}});
//                        go(row, i);
                    }
                }
            }
            while (!que.isEmpty()) {
                System.out.println("-- " + que.getFirst()[0][0] + " " + que.getFirst()[1][0]);
                go(Integer.parseInt(que.getFirst()[0][0]), Integer.parseInt(que.pop()[1][0]));
            }
        }
    }

//    public void go(int i, int j, int lasti, int lastj) {
//
//    }
//
//
//    public int go(int i, int j, int lasti, int lastj, int index) {
//        if (i < fieldMatrix.length - 1 && j < fieldMatrix[0].length) {
//            if (fieldMatrix[i + 1][j].equals("0")) {
//                matrixForGraph[index][countVertex] = 1;
//                countVertex++;
////                opened[i + 1][j] = true;
//                go(i + 1, j, i, j, countVertex);
////                fieldMatrix[i][j] = "1";
//            }
//        }
//        if (i < fieldMatrix.length && i != 0 && j != 0 && j < fieldMatrix[0].length) {
//            if (fieldMatrix[i - 1][j].equals("0")) {
//                matrixForGraph[index][countVertex + 1] = 1;
//                countVertex++;
//                opened[i - 1][j] = true;
//                go(i - 1, j, i, j, countVertex);
////                fieldMatrix[i][j] = "1";
//            }
//            if (fieldMatrix[i][j - 1].equals("0")) {
//                matrixForGraph[index][countVertex + 1] = 1;
//                countVertex++;
////                opened[i][j - 1] = true;
//                go(i, j - 1, i, j, countVertex);
////                fieldMatrix[i][j] = "1";
//            }
//        }
//        if (i < fieldMatrix.length && j < fieldMatrix[0].length - 1) {
//            if (fieldMatrix[i][j + 1].equals("0")) {
//                matrixForGraph[index][countVertex + 1] = 1;
//                countVertex++;
////                opened[i][j + 1] = true;
//                go(i, j + 1, i, j, countVertex);
////                fieldMatrix[i][j] = "1";
//            }
//        }
//        System.out.println(countVertex);
//        return countVertex;
//    }


