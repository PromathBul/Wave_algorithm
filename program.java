
public class program {
    public static void main(String[] args) {
        int[][] field = methods.createField(6, 6);
        methods.buildingWalls(field, 5);

        // int[] start = new int[] { field.length - 2, 1 };
        int[] finish = new int[] { 1, field[0].length - 2 };

        field[field.length - 2][1] = 1;
        field[1][field[0].length - 2] = -2;
        methods.show2dArray(field);

        int step = methods.drawRoutes(field);
        System.out.println();
        methods.show2dArray(field);
        
        String reversedRoute = methods.writeRoute(field, finish, step);

        String[] reversedRouteArray = reversedRoute.split(" ");
        methods.ReverseArray(reversedRouteArray);
        System.out.println();
        methods.showArray(reversedRouteArray);
    }

}