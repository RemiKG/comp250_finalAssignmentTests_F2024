// Why did the BFS algorithm bring a ladder? Because it wanted to reach new heights in graph traversal!

package finalproject.tests;

import finalproject.GraphTraversal;
import finalproject.system.Tile;
import finalproject.tiles.*;
import java.util.ArrayList;
import java.util.Arrays;

public class test1 {

    public static class TestTile extends Tile {
        public TestTile() {
            super();
        }
    }

    public static void main(String[] args) {
        // Create an array of TestTile objects
        Tile[] tiles = new Tile[5];
        for (int i = 0; i < tiles.length; ++i) {
            tiles[i] = new TestTile();
            tiles[i].nodeID = i;
        }

        // Connect tiles in a linear fashion: 0-1-2-3-4
        for (int i = 0; i < tiles.length - 1; ++i) {
            tiles[i].addNeighbor(tiles[i + 1]);
        }

        // Define expected BFS traversal orders starting from tile 2
        ArrayList<Tile> expectedBFS1 = new ArrayList<>(Arrays.asList(tiles[2], tiles[1], tiles[3], tiles[0], tiles[4]));
        ArrayList<Tile> expectedBFS2 = new ArrayList<>(Arrays.asList(tiles[2], tiles[3], tiles[1], tiles[4], tiles[0]));

        // Define expected DFS traversal orders starting from tile 2
        ArrayList<Tile> expectedDFS1 = new ArrayList<>(Arrays.asList(tiles[2], tiles[3], tiles[4], tiles[1], tiles[0]));
        ArrayList<Tile> expectedDFS2 = new ArrayList<>(Arrays.asList(tiles[2], tiles[1], tiles[0], tiles[3], tiles[4]));

        // Perform BFS traversal
        ArrayList<Tile> bfsResult = GraphTraversal.BFS(tiles[2]);

        // Check if BFS result matches any of the expected orders
        boolean bfsTestPassed = bfsResult.equals(expectedBFS1) || bfsResult.equals(expectedBFS2);

        if (bfsTestPassed) {
            System.out.println("BFS Test Passed!");
        } else {
            System.out.println("BFS Test Failed.");
            System.out.println("Expected one of the following orders:");
            System.out.println("Order 1: " + getTileIDs(expectedBFS1));
            System.out.println("Order 2: " + getTileIDs(expectedBFS2));
            System.out.println("But got: " + getTileIDs(bfsResult));
        }

        // Perform DFS traversal
        ArrayList<Tile> dfsResult = GraphTraversal.DFS(tiles[2]);

        // Check if DFS result matches any of the expected orders
        boolean dfsTestPassed = dfsResult.equals(expectedDFS1) || dfsResult.equals(expectedDFS2);

        if (dfsTestPassed) {
            System.out.println("DFS Test Passed!");
        } else {
            System.out.println("DFS Test Failed.");
            System.out.println("Expected one of the following orders:");
            System.out.println("Order 1: " + getTileIDs(expectedDFS1));
            System.out.println("Order 2: " + getTileIDs(expectedDFS2));
            System.out.println("But got: " + getTileIDs(dfsResult));
        }

        // Additional feedback based on test results
        if (bfsTestPassed && dfsTestPassed) {
            System.out.println("Level 1 tests all passed successfully!");
        } else {
            System.out.println("Some Level 1 tests failed. Please review your BFS and DFS implementations.");
        }

        /*
         * Computer Science Dad Joke:
         * Why did the programmer go broke?
         * Because he used up all his cache!
         */
    }

    /**
     * Helper method to extract and display node IDs from a list of tiles.
     *
     * @param path The traversal path as a list of Tile objects.
     * @return A string representation of the node IDs.
     */
    private static String getTileIDs(ArrayList<Tile> path) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < path.size(); i++) {
            sb.append(path.get(i).nodeID);
            if (i < path.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
