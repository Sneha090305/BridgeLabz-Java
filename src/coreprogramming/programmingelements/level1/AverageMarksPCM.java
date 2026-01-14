package coreprogramming.programmingelements.level1;

public class AverageMarksPCM {

    public static void main(String[] args) {

        String studentName = "Sam";

        double mathsMarks = 94;
        double physicsMarks = 95;
        double chemistryMarks = 96;

        double averageMarks = (mathsMarks + physicsMarks + chemistryMarks) / 3;

        System.out.println(studentName + "'s average mark in PCM is " + averageMarks);
    }
}
