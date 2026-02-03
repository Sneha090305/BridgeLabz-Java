import java.util.Scanner;

public class RethrowDemo {


    static int performDivision(int numerator, int denominator) {
        if (denominator == 0) {
            throw new ArithmeticException("Denominator cannot be zero");
        }
        return numerator / denominator;
    }

    static int calculate(int numerator, int denominator) {
        try {
            return performDivision(numerator, denominator);
        } catch (ArithmeticException e) {

            throw new ArithmeticException(
                    "Calculation failed: invalid division attempt (" +
                            numerator + " / " + denominator + ")"
            );
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter numerator: ");
            int n = sc.nextInt();

            System.out.print("Enter denominator: ");
            int d = sc.nextInt();

            int result = calculate(n, d);
            System.out.println("Result = " + result);

        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
