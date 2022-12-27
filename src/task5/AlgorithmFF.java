package task5;

import java.util.Arrays;

public class AlgorithmFF {

    OrientedGraph graph;

    int countVertex;

    final int infinity = 10000;

    int[] flow = new int[countVertex];
    int[] link = new int[countVertex];

    int[][] f = new int[countVertex][countVertex];
    int[][] c = new int[countVertex][countVertex];

    int[] queue = new int[countVertex];
    int qc = 0, qp = 0;

    public AlgorithmFF(int[][] matrix) {
//        this.f = matrix;
        this.c = matrix;
        this.countVertex = matrix.length;
        this.queue = new int[c.length];
        this.f = new int[countVertex][countVertex];
        this.flow = new int[countVertex];
        this.link = new int[countVertex];
    }

    public AlgorithmFF() {
        this.c = new int[][] {
                {0,20,30,10,0},
                {0,0,40,0,30},
                {0,0,0,10,20},
                {0,0,0,0,20},
                {0,0,0,0,0},
//                {0,1,1,0,0,0,0},
//                {0,0,0,1,0,0,1},
//                {0,0,0,0,1,1,1},
//                {0,0,0,0,0,0,1},
//                {0,0,0,0,0,0,1},
//                {0,0,0,0,0,0,1},
//                {0,0,0,0,0,0,0},
        };
        this.countVertex = c.length;
        this.queue = new int[c.length];
        this.f = new int[countVertex][countVertex];
        this.flow = new int[countVertex];
        this.link = new int[countVertex];
//        System.out.println(link.length);
//        this.c = f;
    }

    public int findPath(int source, int target) {
        queue[0] = source;
        qc = 1; qp = 0;
        link[target] = -1;
        Arrays.fill(flow, 0);
        flow[source] = infinity;
        int vertex;
        while (link[target] == -1 && qp < qc) {
            vertex = Integer.parseInt(Integer.toString(queue[qp]));
//            System.out.println(vertex);
            for (int i = 0; i < countVertex; i++) {
                if ((c[vertex][i] - f[vertex][i]) > 0 && flow[i] == 0) {
                    queue[qc] = i;
                    qc++;
                    link[i] = vertex;
                    if (c[vertex][i] - f[vertex][i] < flow[vertex]) {
                        flow[i] = c[vertex][i];
                    } else {
                        flow[i] = flow[vertex];
                    }
                }
            }
            qp+=1;
        }
        if (link[target] == -1) return 0;
        vertex = target;
        while (vertex != source) {
            f[link[vertex]][vertex] += flow[target];
            System.out.println(vertex);
            vertex = link[vertex];
        }
        System.out.println("stop");
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
        System.out.println("stop");
        return maxFlow;
    }

}
