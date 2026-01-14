package coreprogramming.string.level2;

import java.util.Scanner;

public class RockPaperScissors {

    public static String getChoice() {
        int r = (int)(Math.random() * 3);
        if (r == 0) return "rock";
        if (r == 1) return "paper";
        return "scissors";
    }

    public static String winner(String user, String comp) {
        if (user.equals(comp)) return "Draw";
        if ((user.equals("rock") && comp.equals("scissors")) ||
                (user.equals("paper") && comp.equals("rock")) ||
                (user.equals("scissors") && comp.equals("paper")))
            return "User";
        return "Computer";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of games: ");
        int n = sc.nextInt();

        int userWin = 0, compWin = 0;

        for (int i = 1; i <= n; i++) {
            System.out.print("Enter rock/paper/scissors: ");
            String user = sc.next();

            String comp = getChoice();
            String win = winner(user, comp);

            if (win.equals("User")) userWin++;
            if (win.equals("Computer")) compWin++;

            System.out.println("Computer: " + comp + " Winner: " + win);
        }

        System.out.println("User win %: " + (userWin * 100 / n));
        System.out.println("Computer win %: " + (compWin * 100 / n));

        sc.close();
    }
}

