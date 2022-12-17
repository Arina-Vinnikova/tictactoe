public class Field {
    public static String[][] matrix = new String[3][3];
    public static final String NOT_SYMB = "*";

    public void initMatrix() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrix[i][j] = NOT_SYMB;
            }
        }
    }

    public void showMatrix() {
        System.out.println();
        for (int i = 0; i < 3; i++) {
            //System.out.print((i + 1) + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}


