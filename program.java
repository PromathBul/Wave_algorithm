import java.util.Scanner;

public class program {
    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);

        int rows = methods.inputNum("Введите количество строк поля. ", iScanner);
        int columns = methods.inputNum("Введите количество столбцов поля. ", iScanner);
        int walls = methods.inputNum("Введите количество стен: ", iScanner);
        while (!methods.numberWalls(rows, columns, walls)) {
            System.out.println("Количество стен превышает количество ячеек.");
            System.out.printf("Количество стен должно быть в диапазоне от 0 до %d.\n", rows * columns - 2);
            walls = methods.inputNum("Введите количество стен: ", iScanner);
        }

        iScanner.close();

        int[][] field = methods.createField(rows, columns);
        methods.buildingWalls(field, walls);

        // int[] start = new int[] { field.length - 2, 1 };
        int[] finish = new int[] { 1, field[0].length - 2 };

        field[field.length - 2][1] = 1;
        field[1][field[0].length - 2] = -2;

        int step = methods.drawRoutes(field);
        System.out.println();

        if (methods.isRoute(field, finish)) {
            methods.show2dArray(field);
            String reversedRoute = methods.writeRoute(field, finish, step);

            String[] reversedRouteArray = reversedRoute.split(" ");
            methods.ReverseArray(reversedRouteArray);
            System.out.println();
            System.out.println("Пошаговый маршрут c координатами каждой точки: ");
            methods.showArray(reversedRouteArray);
        } else {
            methods.show2dArray(field);
            System.out.println("Построить маршрут невозможно.");
        }
    }

}