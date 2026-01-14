package coreprogramming.string.extra2;

import java.time.LocalDate;
import java.util.Scanner;

public class DateArithmetic {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        LocalDate date = LocalDate.parse(sc.next());

        LocalDate result = date.plusDays(7).plusMonths(1).plusYears(2);
        result = result.minusWeeks(3);

        System.out.println("Result Date: " + result);
    }
}
