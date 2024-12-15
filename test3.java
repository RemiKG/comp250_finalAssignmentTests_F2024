// Why did the priority queue apply for a job? It wanted to be a heap-er!
// Test3.java

package finalproject.tests;

import finalproject.TilePriorityQ;
import finalproject.system.Tile;
import java.util.ArrayList;

/**
 * A simple test class for TilePriorityQ without using JUnit.
 * This test ensures that the TilePriorityQ (Level 3) is functioning correctly.
 */
public class test3 {

    public static void main(String[] args) {
        // Create test tiles with varying cost estimates
        TestTile tile1 = new TestTile();
        tile1.costEstimate = 5;

        TestTile tile2 = new TestTile();
        tile2.costEstimate = 3;

        TestTile tile3 = new TestTile();
        tile3.costEstimate = 8;

        TestTile tile4 = new TestTile();
        tile4.costEstimate = 1;

        TestTile tile5 = new TestTile();
        tile5.costEstimate = 4;

        // Add tiles to an ArrayList
        ArrayList<Tile> tiles = new ArrayList<>();
        tiles.add(tile1);
        tiles.add(tile2);
        tiles.add(tile3);
        tiles.add(tile4);
        tiles.add(tile5);

        // Initialize the priority queue
        TilePriorityQ priorityQueue = new TilePriorityQ(tiles);

        // Test removeMin
        boolean removeMinTestPassed = true;
        double[] expectedRemoveOrder = {1, 3, 4, 5, 8};
        System.out.println("Testing removeMin functionality...");
        for (double expected : expectedRemoveOrder) {
            Tile removedTile = priorityQueue.removeMin();
            if (removedTile == null || removedTile.costEstimate != expected) {
                removeMinTestPassed = false;
                System.out.println("removeMin Test Failed: Expected " + expected + ", but got " +
                        (removedTile == null ? "null" : removedTile.costEstimate));
                break;
            }
        }
        if (removeMinTestPassed && priorityQueue.removeMin() == null) {
            System.out.println("removeMin Test Passed!");
        } else if (removeMinTestPassed) {
            System.out.println("removeMin Test Failed: Priority queue should be empty.");
        }

        // Re-initialize the priority queue for updateKeys test
        tiles.clear();
        tiles.add(tile1);
        tiles.add(tile2);
        tiles.add(tile3);
        tiles.add(tile4);
        tiles.add(tile5);
        priorityQueue = new TilePriorityQ(tiles);

        // Test updateKeys
        System.out.println("\nTesting updateKeys functionality...");
        // Update tile3's costEstimate from 8 to 2
        priorityQueue.updateKeys(tile3, null, 2);
        // Update tile4's costEstimate from 1 to 3 to ensure tile3 becomes the new minimum
        priorityQueue.updateKeys(tile4, null, 3);

        // The new removeMin should now return tile3
        Tile updatedMin = priorityQueue.removeMin();
        if (updatedMin != null && updatedMin.costEstimate == 2) {
            System.out.println("updateKeys Test Passed!");
        } else {
            System.out.println("updateKeys Test Failed: Expected costEstimate 2, but got " +
                    (updatedMin == null ? "null" : updatedMin.costEstimate));
        }


    }

    /**
     * A simple TestTile class for testing purposes.
     * Extends the Tile class and provides a default constructor.
     */
    public static class TestTile extends Tile {
        public TestTile() {
            super();
        }
    }
}
