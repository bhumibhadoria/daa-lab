import java.util.*;

public class exp10 {
    static int V = 4;

    static int tsp(int[][] graph, int s) {
        List<Integer> vertex = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (i != s)
                vertex.add(i);
        }

        int minPath = Integer.MAX_VALUE;
        do {
            int currentPathWeight = 0;
            int k = s;
            for (int i = 0; i < vertex.size(); i++) {
                currentPathWeight += graph[k][vertex.get(i)];
                k = vertex.get(i);
            }
            currentPathWeight += graph[k][s];

            minPath = Math.min(minPath, currentPathWeight);
        } while (findNextPermutation(vertex));

        return minPath;
    }

    static boolean findNextPermutation(List<Integer> data) {
        if (data.size() <= 1)
            return false;

        int last = data.size() - 2;
        while (last >= 0) {
            if (data.get(last) < data.get(last + 1))
                break;
            last--;
        }
        if (last < 0)
            return false;

        int nextGreater = data.size() - 1;
        for (int i = data.size() - 1; i > last; i--) {
            if (data.get(i) > data.get(last)) {
                nextGreater = i;
                break;
            }
        }

        Collections.swap(data, nextGreater, last);
        Collections.reverse(data.subList(last + 1, data.size()));
        return true;
    }

    public static void main(String[] args) {
        int[][] graph = { { 0, 10, 15, 20 },
                { 10, 0, 35, 25 },
                { 15, 35, 0, 30 },
                { 20, 25, 30, 0 } };
        int s = 0;
        System.out.println("Result is: "+(tsp(graph, s)));
    }
}
