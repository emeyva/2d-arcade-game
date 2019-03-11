package Game2d;

import java.util.Random;

public class gamePlay {

    public static void main(String[] args) {
        // test game

        int width = 20;
        int height = 20;
        int[][] colorsArray = new int[width][height];
        for (int i = 0; i < width; i++) {

            for (int j = 0; j < height; j++) {
                colorsArray[i][j] = (int)(Math.random()*(gameConstruction.colors.length));
            }
        }

        new editJFrame(new gameConstruction(colorsArray), "Eurico Pinto 1502342", gameConstruction.shapesDetails, gameConstruction.shapesRand, gameConstruction.textArea);
    }
}