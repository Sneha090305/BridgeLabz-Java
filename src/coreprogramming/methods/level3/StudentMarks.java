package coreprogramming.methods.level3;



import java.util.Scanner;

public class StudentMarks {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        System.out.println("Name\tPhysics\tChemistry\tMath\tTotal\tAverage\tPercentage");

        for (int i = 1; i <= n; i++) {

            int p = (int)(Math.random() * 90) + 10;
            int c = (int)(Math.random() * 90) + 10;
            int m = (int)(Math.random() * 90) + 10;

            int total = p + c + m;
            double avg = total / 3.0;
            double percent = (total / 300.0) * 100;

            System.out.println(i + "\t" + p + "\t" + c + "\t\t" + m + "\t" + total + "\t" + avg + "\t" + percent);
        }

        sc.close();
    }
}
