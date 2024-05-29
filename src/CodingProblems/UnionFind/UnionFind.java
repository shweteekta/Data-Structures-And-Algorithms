package UnionFind;

import java.util.*;

public class UnionFind {
    private Map<Integer, Integer> parent;
    private Map<Integer, Integer> rank;

    public UnionFind() {
        parent = new HashMap<>();
        rank = new HashMap<>();
    }

    public void makeSet(int x) {
        parent.put(x, x);
        rank.put(x,0);
    }

    public int find(int x){
        if( x!= parent.get(x)){
           parent.put(x, find(parent.get(x)));
        }
        return parent.get(x);
    }

    public void merge(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            if (rank.get(rootX) < rank.get(rootY)) {

                parent.put(rootX, rootY);
            } else if (rank.get(rootX) > rank.get(rootY)) {
                parent.put(rootY, rootX);
            } else {
                parent.put(rootY, rootX);
                rank.put(rootX, rank.get(rootX) + 1);
            }
        }
    }

    public boolean isSame(int x, int y) {
        return find(x) == find(y);
    }
    public static void main(String[] args) {
        UnionFind uf = new UnionFind();
        for (int i = 1; i <= 5; i++) {
            uf.makeSet(i);
        }
        uf.merge(1, 2);
        uf.merge(2, 3);
        System.out.println(uf.isSame(1, 3)); // Output: true
        System.out.println(uf.isSame(2, 4)); // Output: false
    }
}
