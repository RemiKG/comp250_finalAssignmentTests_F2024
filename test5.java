package finalproject.tests;


import finalproject.system.Tile;
import finalproject.system.TileType;
import finalproject.tiles.*;
import java.util.ArrayList;
import java.util.HashSet;
import finalproject.*;

public class test5 {
    public static void main(String[] args) {
        // Create tiles
        TestTile tile0 = new TestTile(0, TileType.Plain);
        TestTile tile1 = new TestTile(1, TileType.Desert);
        TestTile tile2 = new TestTile(2, TileType.Facility);
        TestTile tile3 = new TestTile(3, TileType.Moutain);
        TestTile tile4 = new TestTile(4, TileType.ZombieInfectedRuin);
        TestTile tile5 = new TestTile(5, TileType.Metro);

        // Set start and end
        tile0.isStart = true;
        tile4.isDestination = true;

        // Connect tiles
        tile0.addNeighbor(tile1); // 0 <-> 1
        tile1.addNeighbor(tile2); // 1 <-> 2
        tile2.addNeighbor(tile3); // 2 <-> 3
        tile3.addNeighbor(tile4); // 3 <-> 4
        tile1.addNeighbor(tile5); // 1 <-> 5
        tile5.addNeighbor(tile4); // 5 <-> 4

        // Initialize graphs
        ArrayList<Tile> vertices = new ArrayList<>();
        vertices.add(tile0);
        vertices.add(tile1);
        vertices.add(tile2);
        vertices.add(tile3);
        vertices.add(tile4);
        vertices.add(tile5);

        // Create a ShortestPath instance
        ShortestPath shortestPath = new ShortestPath(tile0);

        // Generate graph with distance costs
        shortestPath.generateGraph();

        // Find path from start (tile0) to end (tile4)
        ArrayList<Tile> path = shortestPath.findPath(tile0, tile4);

        // Define expected path
        ArrayList<Tile> expectedPath = new ArrayList<>();
        expectedPath.add(tile0);
        expectedPath.add(tile1);
        expectedPath.add(tile5);
        expectedPath.add(tile4);

        // Verify the path
        boolean testPassed = true;

        if (path.size() != expectedPath.size()) {
            testPassed = false;
            System.out.println("Test Failed: Path length mismatch.");
        } else {
            for (int i = 0; i < path.size(); i++) {
                if (path.get(i) != expectedPath.get(i)) {
                    testPassed = false;
                    System.out.println("Test Failed: Path mismatch at position " + i + ".");
                    break;
                }
            }
        }

        // Output the result
        if (testPassed) {
            System.out.println("Test Passed: Shortest path found correctly.");
        } else {
            System.out.println("Test Failed: Shortest path is incorrect.");
            System.out.print("Expected Path: ");
            for (Tile t : expectedPath) {
                System.out.print(t.nodeID + " ");
            }
            System.out.println();
            System.out.print("Actual Path: ");
            for (Tile t : path) {
                System.out.print(t.nodeID + " ");
            }
            System.out.println();
        }
    }

    /**
     * A simple TestTile class for testing purposes.
     */
    public static class TestTile extends Tile {
        public TestTile(int nodeID, TileType type) {
            super();
            this.nodeID = nodeID;
            this.type = type;
            this.distanceCost = getDefaultDistanceCost(type);
            this.timeCost = getDefaultTimeCost(type);
            this.damageCost = getDefaultDamageCost(type);
        }

        private double getDefaultDistanceCost(TileType type) {
            switch (type) {
                case Plain:
                    return 3;
                case Desert:
                    return 2;
                case Facility:
                    return 1;
                case Moutain:
                    return 100;
                case ZombieInfectedRuin:
                    return 1;
                case Metro:
                    return 1;
                default:
                    return 1;
            }
        }

        private double getDefaultTimeCost(TileType type) {
            switch (type) {
                case Plain:
                    return 1;
                case Desert:
                    return 6;
                case Facility:
                    return 2;
                case Moutain:
                    return 100;
                case ZombieInfectedRuin:
                    return 3;
                case Metro:
                    return 1;
                default:
                    return 1;
            }
        }

        private double getDefaultDamageCost(TileType type) {
            switch (type) {
                case Plain:
                    return 0;
                case Desert:
                    return 3;
                case Facility:
                    return 0;
                case Moutain:
                    return 100;
                case ZombieInfectedRuin:
                    return 5;
                case Metro:
                    return 2;
                default:
                    return 0;
            }
        }
    }
}
