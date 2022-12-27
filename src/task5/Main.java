package task5;

import mainform.MainForm;

public class Main {
    public static void main(String[] args) {
        MainForm form = new MainForm();
        form.setVisible(true);

        String[][] fm = form.getFieldMatrix();
        for (int i = 0; i < fm.length; i++) {
            for (int j = 0; j < fm[0].length; j++) {
                System.out.print(fm[i][j] + " ");
            }
            System.out.println();
        }
        CreateAdjMatrix hp = new CreateAdjMatrix(fm);
        int[][] arr = hp.arrayToMatrixForGraph();
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            for (int j = -1; j < arr[0].length; j++) {
                if (j == -1) {
                    System.out.print(i + " ");
                } else {
                    System.out.print(arr[i][j] + " ");
                }
            }
            System.out.println();
        }

        AlgorithmFF a = new AlgorithmFF(arr);
        System.out.println(a.maxFlow(0, arr.length - 1));
    }
}