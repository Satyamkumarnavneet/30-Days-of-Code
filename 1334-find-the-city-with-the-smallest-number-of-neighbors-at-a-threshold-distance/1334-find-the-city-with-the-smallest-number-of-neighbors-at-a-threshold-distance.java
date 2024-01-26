class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        // Initialize distance matrix with max value
        int[][] distances = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(distances[i], Integer.MAX_VALUE);
            distances[i][i] = 0;
        }

        // Update distance matrix with edge weights
        for (int[] edge : edges) {
            int fromCity = edge[0];
            int toCity = edge[1];
            int weight = edge[2];
            distances[fromCity][toCity] = distances[toCity][fromCity] = weight;
        }

        // Floyd-Warshall algorithm to find shortest distances
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (distances[i][k] != Integer.MAX_VALUE && distances[k][j] != Integer.MAX_VALUE) {
                        distances[i][j] = Math.min(distances[i][j], distances[i][k] + distances[k][j]);
                    }
                }
            }
        }

        // Initialize result variables
        int minNeighbors = Integer.MAX_VALUE;
        int resultCity = -1;

        // Iterate through each city and count reachable neighbors
        for (int i = 0; i < n; i++) {
            int currentNeighbors = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && distances[i][j] <= distanceThreshold) {
                    currentNeighbors++;
                }
            }

            // Update result if current city has fewer neighbors or the same number with a greater index
            if (currentNeighbors <= minNeighbors) {
                minNeighbors = currentNeighbors;
                resultCity = i;
            }
        }

        return resultCity;
    }
}
