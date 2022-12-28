import java.util.Scanner;
import java.util.Random;

public class methods {
    static int inputNum(String msg, Scanner scanner) {
        System.out.print(msg);
        int num = scanner.nextInt();
        return num;
    }

    static int[][] createField(int rows, int columns) {
        int[][] field = new int[rows + 2][columns + 2];

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (i == 0 || i == rows + 1 || j == 0 || j == columns + 1)
                    field[i][j] = -1;
            }
        }
        return field;
    }

    static void show2dArray(int[][] array) {
        for (int i = 0; i < array[0].length * 8; i++) {
            System.out.print("_");
        }
        System.out.println();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (j != array[i].length - 1)
                    System.out.printf("| %d\t", array[i][j]);
                else
                    System.out.printf("| %d\t|", array[i][j]);
            }
            System.out.println();
            for (int k = 0; k < array[0].length * 8 + 1; k++) {
                if (k % 8 == 0)
                    System.out.print("|");
                else
                    System.out.print("_");
            }
            System.out.println();
        }
    }

    static void buildingWalls(int[][] array, int walls) {
        Random rnd = new Random();
        for (int i = 0; i < walls; i++) {
            int row = rnd.nextInt(1, array.length - 1);
            int column = rnd.nextInt(1, array[0].length - 1);
            while (array[row][column] == -1 || (row == array.length - 2 && column == 1)
                    || (row == 1 && column == array[0].length - 2)) {
                row = rnd.nextInt(1, array.length - 1);
                column = rnd.nextInt(1, array[0].length - 1);
            }
            array[row][column] = -1;
        }
    }

    static int drawRoutes(int[][] array) {
        int step = 1;
        for (; step < array.length * array[0].length - 2 * (array.length + array[0].length - 2); step++) {
            for (int i = 1; i < array.length - 1; i++) {
                for (int j = 1; j < array[i].length - 1; j++) {
                    if (array[i][j] == step) {
                        if (array[i + 1][j] == -2 || array[i - 1][j] == -2 || array[i][j + 1] == -2
                                || array[i][j - 1] == -2)
                            return step;
                        else {
                            if (array[i - 1][j] == 0)
                                array[i - 1][j] = step + 1;
                            if (array[i + 1][j] == 0)
                                array[i + 1][j] = step + 1;
                            if (array[i][j + 1] == 0)
                                array[i][j + 1] = step + 1;
                            if (array[i][j - 1] == 0)
                                array[i][j - 1] = step + 1;
                        }
                    }
                }
            }
        }
        return step;
    }

    static String writeRoute(int[][] array, int[] finish, int step) {
        String route = String.format("(%d;%d) ", finish[0], finish[1]);
        for (int i = 0, value = step; i < step; i++, value--) {
            if (array[finish[0]][finish[1] - 1] == value)
                finish[1]--;
            else if (array[finish[0]][finish[1] + 1] == value)
                finish[1]++;
            else if (array[finish[0] + 1][finish[1]] == value)
                finish[0]++;
            else
                finish[0]--;
            route += String.format("(%d;%d) ", finish[0], finish[1]);
        }
        return route;
    }

    static void ReverseArray(String[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            String helper = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = helper;
        }
    }

    static void showArray(String[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    static Boolean numberWalls(int rows, int columns, int walls){
        return walls <= rows * columns - 2;
    }
}
