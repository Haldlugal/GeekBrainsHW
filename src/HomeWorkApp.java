public class HomeWorkApp {
    public static void main(String[] args) {

    }

    public static boolean testSum(int a, int b) {
        return (a + b) >= 10 && (a + b) <= 20;
    }

    public static void checkSign(int a) {
        if (a >= 0) System.out.println("Положительное");
        else System.out.println("Отрицательное");
    }

    public static boolean isPositive(int a) {
        return a >= 0;
    }

    public static void repetitivePrint(String value, int number) {
        for (int i = 0; i < number; i++) {
            System.out.println(value);
        }
    }

    public static boolean isLeapYear(int year) {
        if (year % 400 == 0) {
            return true;
        } else if (year % 100 == 0) {
            return false;
        } else if (year % 4 == 0) {
            return true;
        }
        return false;
    }


}
