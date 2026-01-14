package coreprogramming.controlflow.level3;

import java.util.Scanner;

public class StudentGrade {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Physics marks: ");
        int physics = sc.nextInt();

        System.out.print("Enter Chemistry marks: ");
        int chemistry = sc.nextInt();

        System.out.print("Enter Maths marks: ");
        int maths = sc.nextInt();

        int total = physics + chemistry + maths;
        double percentage = total / 3.0;

        System.out.println("Average Marks: " + percentage);

        if (percentage >= 80)
            System.out.println("Grade A – Excellent");
        else if (percentage >= 70)
            System.out.println("Grade B – Good");
        else if (percentage >= 60)
            System.out.println("Grade C – Average");
        else if (percentage >= 50)
            System.out.println("Grade D – Below Average");
        else if (percentage >= 40)
            System.out.println("Grade E – Poor");
        else
            System.out.println("Grade R – Fail");

        sc.close();
    }
}
