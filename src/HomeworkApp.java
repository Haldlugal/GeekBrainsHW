import java.util.Random;
import java.util.Scanner;


public class HomeworkApp {
    public static int SIZE = 5;
    public static int DOTS_TO_WIN = 4;
    public static final char DOT_EMPTY = '•';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static char[][] map;
    public static Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();
    public static void main(String[] args) {
        initMap();
        printMap();
        while (true) {
            humanTurn();
            printMap();
            if (checkWin(DOT_X)) {
                System.out.println("Победил человек");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
            aiTurn();
            printMap();
            if (checkWin(DOT_O)) {
                System.out.println("Победил Искуственный Интеллект");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
        }
        System.out.println("Игра закончена");
    }
    //ДЗ
    public static boolean checkWin(char symb) {
        for (Direction direction : Direction.values()) {
            if (checkWinDirection(symb, direction)) return true;
        }
        return false;
    }
    //ДЗ
    public static boolean checkWinDirection(char symb, Direction direction) {
        if (direction == Direction.HORIZONTAL) {
            for (int i = 0; i < SIZE; i++) {
                if (checkArrayForSymbol(map[i], symb, DOTS_TO_WIN)) return true;
            }
        } else if (direction == Direction.VERTICAL) {
            char[] arrayToCheck = new char[SIZE];
            for (int i = 0; i < SIZE; i++) {
                for (int t = 0; t < SIZE; t++) {
                    arrayToCheck[t] = map[t][i];
                }
                if (checkArrayForSymbol(arrayToCheck, symb, DOTS_TO_WIN)) return true;
            }
        } else if (direction == Direction.DIAGONAL) {
            char[] testArrayLeft = new char[SIZE];
            char[] testArrayRight = new char[SIZE];
            int diff = SIZE - DOTS_TO_WIN;
            for (int i = -diff; i <= diff; i++) {
                for (int t = 0; t < SIZE; t++) {
                    if ((t + i) < 0 || (t + i )> SIZE - 1) {
                        testArrayLeft[t] = DOT_EMPTY;
                        testArrayRight[t] = DOT_EMPTY;
                    } else {
                        testArrayLeft[t] = map[t][t+i];
                        testArrayRight[t] = map[t][(SIZE - 1) - (t+i)];
                    }
                }
                if (checkArrayForSymbol(testArrayLeft, symb, DOTS_TO_WIN) || checkArrayForSymbol(testArrayRight, symb, DOTS_TO_WIN)) return true;
            }
        }
        return false;
    }
    //ДЗ
    public static boolean checkArrayForSymbol(char[]array, char symbol, int searchLength) {
        for (int i = 0; i <= (array.length - searchLength); i++) {
            boolean check = true;
            for (int t = i; t < searchLength + i; t++) {
                if (array[t] != symbol) {
                    check = false;
                    break;
                }
            }
            if (check) return true;
        }
        return false;
    }

    public static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }
    public static void aiTurn() {
        int x, y;
        do {
            x = rand.nextInt(SIZE);
            y = rand.nextInt(SIZE);
        } while (!isCellValid(x, y));
        System.out.println("Компьютер походил в точку " + (x + 1) + " " + (y + 1));
        map[y][x] = DOT_O;
    }
    public static void humanTurn() {
        int x, y;
        do {
            System.out.println("Введите координаты в формате X Y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x, y)); // while(isCellValid(x, y) == false)
        map[y][x] = DOT_X;
    }
    public static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) return false;
        if (map[y][x] == DOT_EMPTY) return true;
        return false;
    }
    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }
    public static void printMap() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}

enum Direction  {
    VERTICAL,
    HORIZONTAL,
    DIAGONAL
}

