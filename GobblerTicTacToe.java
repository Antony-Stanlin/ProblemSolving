
import java.util.Scanner;
import java.util.Stack;

public class GobblerTicTacToe {

    private static int rows = 3;
    private static int cols = 3;
    private static Stack<String> board[][];
    private static boolean isRunning = true;
    private static char currentPlayer = 'O';

    public static void main(String ar[]) {
        start();
    }

    public static void fillBoard() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                board[i][j] = new Stack();
                board[i][j].push("__");
            }
        }
    }

    public static boolean isValidPlayer(String color) {
        return currentPlayer == color.charAt(0);
    }

    public static boolean checkWin() {
        boolean horizontal = true, vertical = true, diagonalRight = true, diagonalLeft = true;
        for (int i = 0; i < rows; i++) {
            horizontal = true;
            vertical = true;
            for (int j = 0; j < cols; j++) {

                if (horizontal && board[i][j].peek().charAt(0) != currentPlayer) {
                    horizontal = false;
                }
                if (vertical && board[j][i].peek().charAt(0) != currentPlayer) {
                    vertical = false;
                }
                if (i == j && diagonalRight && board[i][j].peek().charAt(0) != currentPlayer) {
                    diagonalRight = false;
                }
                if (j == Math.abs(cols - i - 1) && diagonalLeft && board[i][j].peek().charAt(0) != currentPlayer) {
                    diagonalLeft = false;
                }
            }
            if (vertical || horizontal) {
                return true;
            }
        }
        return diagonalLeft || diagonalRight;
    }

    public static boolean CheckDraw() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j].peek().equals("__")) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void start() {

        Scanner sc = new Scanner(System.in);
        System.out.print("Do you want to define the size of Board?[Y/N]:");
        String choice = sc.nextLine();

        if (choice.equalsIgnoreCase("y")) {
            System.out.println("Enter No of row or column:");
            rows = sc.nextInt();
            cols = rows;
            sc.nextLine();
        }

        board = new Stack[rows][cols];

        fillBoard();

        while (isRunning) {
            printBoard();
            System.out.println(currentPlayer == 'O' ? "Robert" : "Clive");

            System.out.print("Color: ");
            String color = sc.nextLine();
            if (!isValidPlayer(color)) {
                System.out.println("Invalid input color,Please try again");
                continue;
            }

            System.out.print("Position: ");
            String position = sc.nextLine();
            int col = position.charAt(0) - 'A';
            int row = position.charAt(1) - '0' - 1;
            if (!setPeice(color, row, col)) {
                System.out.println("You can't move to top of bigger or same size,Please try again");
                continue;
            }

            if (checkWin()) {
                System.out.print(currentPlayer == 'O' ? "Robert " : "Clive ");
                System.out.println("wins");
                isRunning = false;
                printBoard();
            }
            if (CheckDraw()) {
                System.out.println("Match Draw");
                isRunning = false;
                printBoard();
            }
            switchPlayer();
        }

        sc.close();
    }

    public static boolean setPeice(String color, int row, int col) {
        char currentSize = board[row][col].peek().charAt(1);
        if (currentSize != '_' && currentSize >= color.charAt(1)) {
            return false;
        }

        label1:
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j].peek().equals(color)) {
                    board[i][j].pop();
                    break label1;
                }
            }
        }

        board[row][col].push(color);
        return true;
    }

    public static void printBoard() {
        for (int i = -1; i < rows; i++) {
            for (int j = -1; j < cols; j++) {
                if (i == -1) {
                    if (j == -1) {
                        System.out.print("  ");
                    } else {
                        System.out.print((char) ('A' + j) + "  ");
                    }
                } else {
                    if (j == -1) {
                        System.out.print(i + 1 + " ");
                    } else {
                        System.out.print(board[i][j].peek() + " ");
                    }
                }
            }
            System.out.println();
        }
    }

    public static void switchPlayer() {
        currentPlayer = currentPlayer == 'O' ? 'B' : 'O';
    }
}
