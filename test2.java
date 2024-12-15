// Why did the graph apply for a job?
// Because it wanted to make connections! ;-;

package finalproject.tests;

import finalproject.system.Tile;
import finalproject.system.TileType;
import finalproject.Graph;

import java.util.ArrayList;
import java.util.Arrays;

public class test2 {

    // Inner TestTile class for testing purposes
    public static class TestTile extends Tile {
        public TestTile() {
            super(1, 1, 1); // Assign arbitrary costs for testing
            this.type = TileType.Plain; // Default type
        }
    }

    public static void main(String[] args) {
        // Create Tiles
        TestTile tile0 = new TestTile();
        tile0.nodeID = 0;
        TestTile tile1 = new TestTile();
        tile1.nodeID = 1;
        TestTile tile2 = new TestTile();
        tile2.nodeID = 2;
        TestTile tile3 = new TestTile();
        tile3.nodeID = 3;

        // Add Tiles to a list
        ArrayList<Tile> vertices = new ArrayList<>(Arrays.asList(tile0, tile1, tile2, tile3));

        // Create Graph
        Graph graph = new Graph(vertices);

        // Test 1: Initial graph should have zero edges
        if (graph.getAllEdges().size() != 0) {
            System.out.println("Test Failed: Initial graph should have 0 edges, but has " + graph.getAllEdges().size());
            return;
        } else {
            System.out.println("Test Passed: Initial graph has 0 edges.");
        }

        // Test 2: Add edges to the graph
        graph.addEdge(tile0, tile1, 2.0);
        graph.addEdge(tile1, tile2, 3.0);
        graph.addEdge(tile2, tile3, 4.0);

        // Verify the number of edges after adding
        if (graph.getAllEdges().size() != 3) {
            System.out.println("Test Failed: Graph should have 3 edges after adding, but has " + graph.getAllEdges().size());
            return;
        } else {
            System.out.println("Test Passed: Graph has 3 edges after adding.");
        }

        // Test 3: Verify specific edges exist with correct weights
        boolean edge01Exists = false;
        boolean edge12Exists = false;
        boolean edge23Exists = false;

        for (Graph.Edge edge : graph.getAllEdges()) {
            if (edge.getStart().equals(tile0) && edge.destination.equals(tile1) && edge.weight == 2.0) {
                edge01Exists = true;
            }
            if (edge.getStart().equals(tile1) && edge.destination.equals(tile2) && edge.weight == 3.0) {
                edge12Exists = true;
            }
            if (edge.getStart().equals(tile2) && edge.destination.equals(tile3) && edge.weight == 4.0) {
                edge23Exists = true;
            }
        }

        if (edge01Exists && edge12Exists && edge23Exists) {
            System.out.println("Test Passed: All specified edges exist with correct weights.");
        } else {
            if (!edge01Exists) {
                System.out.println("Test Failed: Edge from Tile 0 to Tile 1 with weight 2.0 does not exist.");
            }
            if (!edge12Exists) {
                System.out.println("Test Failed: Edge from Tile 1 to Tile 2 with weight 3.0 does not exist.");
            }
            if (!edge23Exists) {
                System.out.println("Test Failed: Edge from Tile 2 to Tile 3 with weight 4.0 does not exist.");
            }
            return;
        }


        // All tests passed
        System.out.println("All level 2 tests passed successfully!");
    }
}
