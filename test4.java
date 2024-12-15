// Why did the graph go to therapy? It couldn't find its shortest path.

package finalproject.tests;

import finalproject.ShortestPath;
import finalproject.system.Tile;
import finalproject.system.TileType;
import finalproject.tiles.PlainTile;
import finalproject.tiles.MetroTile;
import finalproject.tiles.MountainTile;
import finalproject.tiles.DesertTile;
import finalproject.tiles.FacilityTile;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Test4.java
 * 
 * This class contains a simple test to verify that Level 4 (Dijkstra's Algorithm implementation)
 * works correctly without using JUnit. It manually constructs a graph, runs the shortest path
 * algorithm, and checks if the output path matches the expected result.
 */
public class test4 {

    /**
     * A simple TestTile class extending Tile to allow custom distance costs.
     */
    public static class TestTile extends Tile {
        public TestTile(double distanceCost, double timeCost, double damageCost) {
            super(distanceCost, timeCost, damageCost);
            this.type = TileType.Plain; // For simplicity, using Plain type
        }
    }

    public static void main(String[] args) {
        // Step 1: Create Tiles
        TestTile t0 = new TestTile(1, 1, 0); // Start Tile
        TestTile t1 = new TestTile(1, 1, 0);
        TestTile t2 = new TestTile(1, 1, 0);
        TestTile t3 = new TestTile(1, 1, 0); // Destination Tile

        // Assign node IDs
        t0.setNodeID(0);
        t1.setNodeID(1);
        t2.setNodeID(2);
        t3.setNodeID(3);

        // Mark start and destination
        t0.isStart = true;
        t3.isDestination = true;

        // Step 2: Connect Tiles
        t0.addNeighbor(t1); // t0 <-> t1
        t1.addNeighbor(t2); // t1 <-> t2
        t0.addNeighbor(t2); // t0 <-> t2
        t2.addNeighbor(t3); // t2 <-> t3

        // Step 3: Create a list of vertices
        ArrayList<Tile> vertices = new ArrayList<>();
        vertices.add(t0);
        vertices.add(t1);
        vertices.add(t2);
        vertices.add(t3);

        // Step 4: Instantiate ShortestPath with start tile
        ShortestPath shortestPath = new ShortestPath(t0);

        // Step 5: Find the shortest path
        ArrayList<Tile> path = shortestPath.findPath(t0);

        // Step 6: Define expected paths
        ArrayList<Tile> expectedPath1 = new ArrayList<>();
        expectedPath1.add(t0);
        expectedPath1.add(t1);
        expectedPath1.add(t2);
        expectedPath1.add(t3);

        ArrayList<Tile> expectedPath2 = new ArrayList<>();
        expectedPath2.add(t0);
        expectedPath2.add(t2);
        expectedPath2.add(t3);

        // Step 7: Check if the path matches one of the expected paths
        boolean isCorrect = (path.equals(expectedPath1) || path.equals(expectedPath2));

        // Step 8: Output the result
        if (isCorrect) {
            System.out.println("Test Passed: Shortest path is correct.");
        } else {
            System.out.println("Test Failed: Shortest path is incorrect.");
            System.out.println("Expected Path 1: " + tileListToString(expectedPath1));
            System.out.println("Expected Path 2: " + tileListToString(expectedPath2));
            System.out.println("Actual Path: " + tileListToString(path));
        }
    }

    /**
     * Helper method to convert a list of tiles to a string representation.
     */
    private static String tileListToString(ArrayList<Tile> tiles) {
        StringBuilder sb = new StringBuilder();
        for (Tile tile : tiles) {
            sb.append("Tile").append(tile.getNodeID()).append(" -> ");
        }
        if (sb.length() >= 4) {
            sb.setLength(sb.length() - 4); // Remove the last arrow
        }
        return sb.toString();
    }
}
