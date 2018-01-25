package datastructures;

public class DisjointSet {
    int[] parent;
    int[] rank;

    public DisjointSet(int length) {
        parent = new int[length + 1];
        rank = new int[length + 1];
        for (int i = 1; i <= length; i ++) {
            make(i);
        }
    }

    public void make(int i) {
        // Place element i in a set by itself.
        parent[i] = i;
        rank[i] = 0;
    }

    public int find(int i) {
        int direct = parent[i];
        if (direct == i)
            return direct;

        int indirect = find(direct);

        // Update parent using path compression.
        parent[i] = indirect;
        return indirect;
    }

    public void union(int i, int j) throws Exception {
        if (i < 0 || i >= parent.length || j < 0 || j >= parent.length)
            throw new Exception("Invalid elements");
        int ip = find(i);
        int jp = find(j);

        // They are already in the same set.
        if (ip == jp) 
            return;

        int irank = rank[ip];
        int jrank = rank[jp];

        if (irank == jrank) {
            parent[ip] = jp;
            // Update the rank of the representative.
            rank[jp] = rank[ip] + 1;
        } else if (irank < jrank) {
            parent[ip] = jp;
        } else if (jrank < irank) {
            parent[jp] = ip;
        }
    }
}