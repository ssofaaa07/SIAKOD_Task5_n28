package task5;

import java.util.*;

public class AlgorithmFF {

    OrientedGraph graph;
    int countVertex;
    final int infinity = 10000;
    int[] flow = new int[countVertex];
    int[] link = new int[countVertex];
    int[][] f = new int[countVertex][countVertex];
    int[][] c = new int[countVertex][countVertex];
    Stack<Integer> stack = new Stack<>();

    public AlgorithmFF(int[][] matrix) {
        this.c = matrix;
        this.countVertex = matrix.length;
        this.f = new int[countVertex][countVertex];
        this.flow = new int[countVertex];
        this.link = new int[countVertex];
    }

    public AlgorithmFF() {
        this.c = new int[][] {
                {0,16,0,0,13,0},
                {0,0,12,0,6,0},
                {0,0,0,0,9,20},
                {0,0,7,0,0,4},
                {0,0,0,14,0,0},
                {0,0,0,0,0,0},
//                {0,1,1,0,0,0,0},
//                {0,0,0,1,0,0,1},
//                {0,0,0,0,1,1,1},
//                {0,0,0,0,0,0,1},
//                {0,0,0,0,0,0,1},
//                {0,0,0,0,0,0,1},
//                {0,0,0,0,0,0,0},
        };
        this.countVertex = c.length;
        this.f = new int[countVertex][countVertex];
        this.flow = new int[countVertex];
        this.link = new int[countVertex];
    }

    public int findPath(int source, int target) {
//        queue[0] = source;
//        qc = 1; qp = 0;
        stack.add(source);
        link[target] = -1; // пока не дошли
        Arrays.fill(flow, 0);
        flow[source] = infinity;
        int vertex;
        while (link[target] == -1 && !stack.isEmpty()) {//qp<qc) {
            vertex = Integer.parseInt(Integer.toString(stack.pop()));//queue[qp]));
            for (int i = 0; i < countVertex; i++) {
                if ((c[vertex][i] - f[vertex][i]) > 0 && flow[i] == 0) {
//                    queue[qc] = i;
//                    qc++;
                    stack.add(i);
                    link[i] = vertex;
                    if (c[vertex][i] - f[vertex][i] < flow[vertex]) {
                        flow[i] = c[vertex][i];
                    } else {
                        flow[i] = flow[vertex];
                    }
                }
            }
//            qp+=1;
        }
        if (link[target] == -1) return 0;
        vertex = target;
        while (vertex != source) {
            f[link[vertex]][vertex] += flow[target];
            System.out.println(vertex);
            vertex = link[vertex];
        }
        return flow[target];
    }

    public int maxFlow(int source, int target){
        for (int i = 0; i < f.length; i++) {
            for (int j = 0; j < f[0].length; j++) {
                f[i][j] = 0;
            }
        }
        int maxFlow = 0;
        int addFlow = 1;

        while (addFlow > 0) {
            addFlow = findPath(source, target);
            maxFlow += addFlow;
        }
        return maxFlow;
    }

}
