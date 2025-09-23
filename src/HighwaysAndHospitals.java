import java.util.LinkedList;
import java.util.Queue;

/**
 * Highways & Hospitals
 * A puzzle created by Zach Blick
 * for Adventures in Algorithms
 * at Menlo School in Atherton, CA
 *
 * Completed by: [Jacob Lowe]
 *
 */

public class HighwaysAndHospitals {

    // keep track of city clusters
    static int[] parent, size;

    // union city a and city b
    static void union (int a, int b) {

        // find root of each city
        int rootA = find(a);
        int rootB = find(b);

        // if already in same cluster do nothing
        if (rootA == rootB) return;

        // weight balancing attaches smaller tree under the larger tree
        if (size[rootA] < size[rootB]) {
            int temp = rootA;
            rootA = rootB;
            rootB = temp;
        }

        // merge the cluster together
        parent[rootB] = rootA;
        size[rootA] += size[rootB];
    }

    // finds the root of the cluster containing city x using path compression
    static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]); // path compression using recursion
        }
        return parent[x];
    }

    // returns minimum cost to give hospitals to every town
    public static long cost(int n, int hospitalCost, int highwayCost, int cities[][]) {

        // if hospitals are cheaper than highways, build a hospital in every city
        if (hospitalCost <= highwayCost) {
            return (long) n * hospitalCost;
        }

        // parent[i] = root of city i
        parent = new int[n + 1];

        // size[i] = size of tree rooted at i
        size = new int[n + 1];
        for (int i = 1; i <= n; i++) {

            // set each city to its own root with a size of 1
            parent[i] = i;
            size[i] = 1;
        }

        // go through each highway and union
        for (int[] highway : cities) {
            union(highway[0], highway[1]);
        }

        long totalCost = 0;
        boolean[] counted = new boolean[n+1];

        // calculate cost for each cluster
        for (int i = 1; i <= n; i++) {

            // path compression to find the cluster's root
            int root = find(i);

            // calculate cost if it hasn't been counted yet
            if (!counted[root]) {
                counted[root] = true;
                int clusterSize = size[root];
                totalCost += (long) hospitalCost + (long) (clusterSize - 1) * highwayCost;
            }
        }

        // returns the minimum cost total
        return totalCost;
    }
}
