// **********************************
// Class: GameController
// Author: Ivan Bury
// Created: 2-6-23
// Modified: None
// Purpose: Runs tests and handles user input
// Attributes: None
// Methods: +main(String[]): void
//          +start(): void
//          +handleUserChoices(PrizeBoxes): void
// **********************************

import java.util.Scanner;

public class GameController {
    public static void main(String[] args) {
        GameController gameController = new GameController();

        gameController.start();
    }

    public void start() {
        PrizeBoxes prizeBoxes = new PrizeBoxes();

        System.out.println("Test case 1:");
        prizeBoxes.initializeTest1();
        prizeBoxes.validateBoxes();

        System.out.println("Test case 2:");
        prizeBoxes.initializeTest2();
        prizeBoxes.validateBoxes();

        System.out.println();
        prizeBoxes.initializeRandom();
        prizeBoxes.validateBoxes();
        this.handleUserChoices(prizeBoxes);
    }

    public void handleUserChoices(PrizeBoxes prizeBoxes) {
        Scanner input = new Scanner(System.in);
        int total = 0;

        for (int i = 0; i < 5; i++) {
            System.out.println((i+1) + ": Please select a box (1-30)");

            int value = prizeBoxes.getBoxes()[input.nextInt() - 1];
            total += value;

            System.out.println("The box you selected contains " + value);
        }

        System.out.println("Prize total is " + total);
        input.close();
    }
}
