// Why did the computer scientist get stuck in traffic? Because he couldn't find the shortest path! 🚗💻

package finalproject.tests;

import finalproject.system.Tile;
import finalproject.system.TileType;
import finalproject.tiles.*;

public class test0 {
    public static void main(String[] args) {
        System.out.println("Starting Level 0 Tests...\n");

        boolean allTestsPassed = true;

        // Test 1: PlainTile
        try {
            PlainTile plain = new PlainTile();
            assert plain.distanceCost == 3 : "PlainTile distanceCost should be 3";
            assert plain.timeCost == 1 : "PlainTile timeCost should be 1";
            assert plain.damageCost == 0 : "PlainTile damageCost should be 0";
            assert plain.type == TileType.Plain : "PlainTile type should be Plain";
            System.out.println("Test 1 Passed: PlainTile properties are correct.");
        } catch (AssertionError e) {
            System.out.println("Test 1 Failed: " + e.getMessage());
            allTestsPassed = false;
        }

        // Test 2: DesertTile
        try {
            DesertTile desert = new DesertTile();
            assert desert.distanceCost == 2 : "DesertTile distanceCost should be 2";
            assert desert.timeCost == 6 : "DesertTile timeCost should be 6";
            assert desert.damageCost == 3 : "DesertTile damageCost should be 3";
            assert desert.type == TileType.Desert : "DesertTile type should be Desert";
            System.out.println("Test 2 Passed: DesertTile properties are correct.");
        } catch (AssertionError e) {
            System.out.println("Test 2 Failed: " + e.getMessage());
            allTestsPassed = false;
        }

        // Test 3: MountainTile
        try {
            MountainTile mountain = new MountainTile();
            assert mountain.distanceCost == 100 : "MountainTile distanceCost should be 100";
            assert mountain.timeCost == 100 : "MountainTile timeCost should be 100";
            assert mountain.damageCost == 100 : "MountainTile damageCost should be 100";
            assert mountain.type == TileType.Moutain : "MountainTile type should be Moutain";
            System.out.println("Test 3 Passed: MountainTile properties are correct.");
        } catch (AssertionError e) {
            System.out.println("Test 3 Failed: " + e.getMessage());
            allTestsPassed = false;
        }

        // Test 4: FacilityTile
        try {
            FacilityTile facility = new FacilityTile();
            assert facility.distanceCost == 1 : "FacilityTile distanceCost should be 1";
            assert facility.timeCost == 2 : "FacilityTile timeCost should be 2";
            assert facility.damageCost == 0 : "FacilityTile damageCost should be 0";
            assert facility.type == TileType.Facility : "FacilityTile type should be Facility";
            System.out.println("Test 4 Passed: FacilityTile properties are correct.");
        } catch (AssertionError e) {
            System.out.println("Test 4 Failed: " + e.getMessage());
            allTestsPassed = false;
        }

        // Test 5: MetroTile
        try {
            MetroTile metro = new MetroTile();
            assert metro.distanceCost == 1 : "MetroTile distanceCost should be 1";
            assert metro.timeCost == 1 : "MetroTile timeCost should be 1";
            assert metro.damageCost == 2 : "MetroTile damageCost should be 2";
            assert metro.type == TileType.Metro : "MetroTile type should be Metro";
            System.out.println("Test 5 Passed: MetroTile properties are correct.");
        } catch (AssertionError e) {
            System.out.println("Test 5 Failed: " + e.getMessage());
            allTestsPassed = false;
        }

        // Test 6: ZombieInfectedRuinTile
        try {
            ZombieInfectedRuinTile zombieRuin = new ZombieInfectedRuinTile();
            assert zombieRuin.distanceCost == 1 : "ZombieInfectedRuinTile distanceCost should be 1";
            assert zombieRuin.timeCost == 3 : "ZombieInfectedRuinTile timeCost should be 3";
            assert zombieRuin.damageCost == 5 : "ZombieInfectedRuinTile damageCost should be 5";
            assert zombieRuin.type == TileType.ZombieInfectedRuin : "ZombieInfectedRuinTile type should be ZombieInfectedRuin";
            System.out.println("Test 6 Passed: ZombieInfectedRuinTile properties are correct.");
        } catch (AssertionError e) {
            System.out.println("Test 6 Failed: " + e.getMessage());
            allTestsPassed = false;
        }

        // Final Result
        System.out.println("\nLevel 0 Tests Completed.");
        if (allTestsPassed) {
            System.out.println("All Level 0 Tests Passed Successfully!");
        } else {
            System.out.println("Some Level 0 Tests Failed. Please Review the Errors Above.");
        }
    }
}
