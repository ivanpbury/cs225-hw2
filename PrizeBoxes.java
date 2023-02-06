// **********************************
// Class: PrizeBoxes
// Author: Ivan Bury
// Created: 2-6-23
// Modified: None
// Purpose: Initializes arrays of prize boxes and validates contents
// Attributes: -boxesArray: int[]
// Methods: +PrizeBoxes(): void
//          +initializeTest1(): void
//          +initializeTest2(): void
//          +initializeRandom(): void
//          +validateBoxes(): void
//          +getBoxes(): int[]
// **********************************

public class PrizeBoxes {
    private int[] boxesArray;

    public PrizeBoxes() {
        boxesArray = new int[30];
	}

    public void initializeTest1() {
        for (int i = 0; i < boxesArray.length; i++) {
            boxesArray[i] = 101;
        }
    }

    public void initializeTest2() {
        for (int i = 0; i < boxesArray.length; i++) {
            boxesArray[i] = 50;
        }
    }

    public void initializeRandom() {
        int upperBound = 100;
        int lowerBound = 20;

        int boxWith0 = (int) (Math.random() * 30);
        int boxWithNegative100;

        do {
            boxWithNegative100 = (int) (Math.random() * 30);
        } while (boxWith0 == boxWithNegative100);

        boxesArray[boxWith0] = 0;
        boxesArray[boxWithNegative100] = -100;

        for (int i = 0; i < boxesArray.length; i++) {
            if (i != boxWith0 && i != boxWithNegative100) {
                boxesArray[i] = (int) (Math.random() * (upperBound + 1 - lowerBound) + lowerBound);
            }
        }

    }

    public void validateBoxes() {
        boolean hasNegative100 = false;
        boolean greaterThan100 = false;
        boolean has0 = false;

        for (int i = 0; i < boxesArray.length; i++) {
            if (boxesArray[i] > 100) {
                greaterThan100 = true;
            }
            if (boxesArray[i] == -100) {
                hasNegative100 = true;
            }
            if (boxesArray[i] == 0) {
                has0 = true;
            }
        }

        if (greaterThan100) {
            System.out.println("Error: at least one box has value greater than 100");
        }
        if (!hasNegative100) {
            System.out.println("Error: no box with value of -100");
        }
        if (!has0) {
            System.out.println("Error: no box with value of 0");
        }
    }

    public int[] getBoxes() {
        return boxesArray;
    }
}
