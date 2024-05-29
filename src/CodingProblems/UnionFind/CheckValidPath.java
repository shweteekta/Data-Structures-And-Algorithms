package UnionFind;

public class CheckValidPath {
    int[] uf;
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        uf = new int[n];
        for (int i=0; i<n;i++)
            uf[i] = i;

        for (int[] edge: edges){
            int p1 = find(edge[0]);
            int p2 = find(edge[1]);
            if(p1 != p2){
                uf[p1] = p2;
            }
        }
        return find(source) == find(destination);
    }

    private int find(int a){
        if (uf[a] != a){
            uf[a] = find(uf[a]);
            a = uf[a];
        }
        return a;
    }
}
