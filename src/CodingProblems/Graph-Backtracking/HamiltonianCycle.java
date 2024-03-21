import java.util.Arrays;

public class HamiltonianCycle {

    private int numOfVertexes;
    private int[] hamiltonianPath;
    private int[][] graph;

    public HamiltonianCycle(int[][] adjacencyMatrix) {
        this.graph = adjacencyMatrix;
        this.numOfVertexes = adjacencyMatrix.length;
        this.hamiltonianPath = new int[numOfVertexes];
    }

    public void findHamiltonianCycle() {
        hamiltonianPath[0] = 0;
        if (checkCycle(1)) {
            printSolution();
        } else {
            System.out.println("No cycle exists");
        }
    }

    private boolean checkCycle(int index) {
        // Check if the we are in last position then check if there is a path between last and first
        if (index == numOfVertexes) {
            return graph[hamiltonianPath[index - 1]][hamiltonianPath[0]] == 1;
        }
        // check if this vertex exists already
        for (int vertex = 1; vertex < numOfVertexes; vertex++) {
            if (isValid(index, vertex)) {
                hamiltonianPath[index] = vertex;
                if (checkCycle(index + 1)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isValid(int index, int vertex) {
        // If no path exists
        if (graph[hamiltonianPath[index - 1]][vertex] == 0){
            return false;
        }
        // If we have already added this vertex in the hamilton path
        for (int i = 0; i < index; i++) {
            if(hamiltonianPath[i] == vertex){
                return false;
            }
        }
        return true;
    }

    private void printSolution() {
        Arrays.stream(hamiltonianPath).forEach(System.out::println);
    }

    public static void main(String[] args) {
        int[][] graph = {
                {0, 1, 1, 1, 0},
                {1, 0, 1, 0, 1},
                {1, 1, 0, 1, 0},
                {1, 0, 1, 0, 1},
                {0, 1, 0, 1, 0}
        };

        HamiltonianCycle hamiltonianCycle = new HamiltonianCycle(graph);
        hamiltonianCycle.findHamiltonianCycle();
    }

}
