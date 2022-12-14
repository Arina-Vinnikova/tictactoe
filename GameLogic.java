import java.util.Scanner;

public class GameLogic {
    public static final String FIRST_PLAYER = "X";
    public static final String SECOND_PLAYER = "O";
    //Field field = new Field();


    public static void Players() {
        int count = 0;
        Field.initMatrix();
        while (true) {
            Field.showMatrix();
            playerGo(FIRST_PLAYER, 1);
            count++;
            if (checkWin(FIRST_PLAYER)) {
                System.out.println("1 WIN!!!");
                Field.showMatrix();
                break;
            }
            playerGo(SECOND_PLAYER, 2);
            count++;
            if (checkWin(SECOND_PLAYER)) {
                System.out.println("2 WIN!!!");
                Field.showMatrix();
                break;
            }
            if (count == Math.pow(3, 2)) {
                Field.showMatrix();
                break;
            }
        }
    }

    public static void playerGo(String symb, int i) {
        int x = 1;
        int y = 1;
        do {
            System.out.println("Player " + i + " x/y : ");
            Scanner num = new Scanner(System.in);
            x = num.nextInt() - 1;
            y = num.nextInt() - 1;
        }
        while (isCell(x, y));
        Field.matrix[x][y] = symb;
    }

    public static boolean isCell(int x, int y) {
        if (x < 0 || y < 0 || x > 3 - 1 || y > 3 - 1) {
            return false;
        }
        return Field.matrix[x][y] != Field.NOT_SYMB;
    }

    public static boolean checkWin(String symb) {
        {
            for (int i = 0; i < 3; i++) {
                if (Field.matrix[i][0] == symb && Field.matrix[i][1] == symb && Field.matrix[i][2] == symb) {
                    return true;
                }
            }
        }
        {
            for (int j = 0; j < 3; j++) {
                if (Field.matrix[0][j] == symb && Field.matrix[1][j] == symb && Field.matrix[2][j] == symb) {
                    return true;
                }
            }
        }
        {
            if (Field.matrix[0][0] == symb && Field.matrix[1][1] == symb && Field.matrix[2][2] == symb) {
                return true;
            }
            if (Field.matrix[0][2] == symb && Field.matrix[1][1] == symb && Field.matrix[2][0] == symb) {
                return true;
            }
        }
        return false;
    }
}

