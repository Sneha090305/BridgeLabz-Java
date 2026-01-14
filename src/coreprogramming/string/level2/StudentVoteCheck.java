package coreprogramming.string.level2;

public class StudentVoteCheck {

    public static boolean canVote(int age) {
        if (age < 0) return false;
        return age >= 18;
    }

    public static void main(String[] args) {

        int[] ages = new int[10];

        for (int i = 0; i < 10; i++) {
            ages[i] = (int)(Math.random() * 40);
        }

        System.out.println("Age\tCan Vote");
        for (int age : ages) {
            System.out.println(age + "\t" + canVote(age));
        }
    }
}

