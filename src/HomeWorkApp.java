import java.lang.reflect.Array;
import java.util.Arrays;

public class HomeWorkApp {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(shiftArray(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, -9)));

    }
    //Задача 1
    public static void changeArray() {
        int[] homeworkArray = new int[]{1,1,0,0,1,0,1,1,0,0};
        for (int i = 0; i < homeworkArray.length; i++) {
            if (homeworkArray[i] == 1) {
                homeworkArray[i] = 0;
            } else if (homeworkArray[i] == 0) {
                homeworkArray[i] = 1;
            }
        }
    }
    //Задача 2
    public static void fillArray() {
        int[] hwArray = new int[100];
        for (int i = 0; i < 100; i++) {
            hwArray[i] = i+1;
        }
    }
    //Задача 3
    public static void multiplyArrayParts() {
        int[] hwArray = new int[]{ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        for (int i = 0; i< hwArray.length; i++) {
            if (hwArray[i] < 6 ){
                hwArray[i]*=2;
            }
        }
    }
    //Задача 4
    public static void multiArrayFill() {
        int[][] hwArray = new int[9][9];
        for(int i = 0; i < hwArray.length; i++) {
            int length = hwArray[0].length - 1;
            hwArray[i][i] = 1;
            hwArray[i][length - i] = 1;
        }
    }
    //Задача 5
    public static int[] generateArray(int len, int initialValue) {
        int[] array = new int[len];
        for (int i = 0; i < array.length; i++) {
            array[i] = initialValue;
        }
        return array;
    }
    //Задача 6
    public static void findMinMax() {
        int[] hwArray = new int[]{ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, -9, 1 };
        int min = hwArray[0];
        int max = hwArray[0];
        for(int i : hwArray) {
            if (i < min) {
                min = i;
            }
            if (i > max) {
                max = i;
            }
        }
    }
    //Задача 7
    public static boolean checkBalance(int[] array) {
        int totalSum = 0;
        for (int j : array) {
            totalSum += j;
        }
        int sumLeft = totalSum;
        int sumRight = 0;
        for (int i = 1; i < array.length; i++) {
            sumLeft -= array[array.length - i];
            sumRight += array[array.length - i];
            if (sumLeft == sumRight) {
                return true;
            }
        }
        return false;
    }

    //Задача 8
    public static int[] shiftArray(int[] array, int bias) {
        int normalizedBias = bias % array.length;
        if (normalizedBias > 0 ) {
            for (int i = 0; i < normalizedBias; i++) {
                shiftArrayRight(array);
            }
        } else {
            for (int i = 0; i > normalizedBias; i-- ) {
                shiftArrayLeft(array);
            }
        }
        return array;
    }

    public static void shiftArrayRight(int[] array) {
        int temp = array[array.length - 1];
        for (int i = array.length - 1; i > 0; i--) {
            array[i] = array[i-1];
        }
        array[0] = temp;
    }

    public static void shiftArrayLeft(int[] array) {
        int temp = array[0];
        for (int i = 0; i < array.length - 1; i++) {
            array[i] = array[i+1];
        }
        array[array.length - 1] = temp;
    }



}
