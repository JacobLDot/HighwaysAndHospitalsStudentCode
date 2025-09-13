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

    /**
     * TODO: Complete this function, cost(), to return the minimum cost to provide
     *  hospital access for all citizens in Menlo County.
     */
    public static long cost(int n, int hospitalCost, int highwayCost, int cities[][]) {

        // If hospitals are cheaper than highways, build a hospital in every city
        if (hospitalCost <= highwayCost) {
            return (long) n * hospitalCost;
        }

        // Track visited cities
        boolean[] visited = new boolean[n + 1];
        long totalCost = 0;

        // Loop through every city
        for (int i = 0; i < n; i++) {

            // If it's an unvisited city, visit it
            if (!visited[i]) {
                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);
                visited[i] = true;

                // Number of cities in the cluster
                int size = 0;

                while (!queue.isEmpty()) {

                    // Move to the next city
                    int currentCity = queue.poll();
                    size++;

                    // Visit connected cities
                    // for each neighbor then
                    for () {
                        if (!visited[neighbor]) {
                            visited[neighbor] = true;
                            queue.add(neighbor);
                        }
                    }
                }
            }
        }

        return totalCost;
    }
}
