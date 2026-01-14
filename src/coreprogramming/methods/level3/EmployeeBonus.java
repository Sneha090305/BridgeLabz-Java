package coreprogramming.methods.level3;


public class EmployeeBonus {

    public static void main(String[] args) {

        int employees = 10;
        double totalBonus = 0;
        double totalOldSalary = 0;
        double totalNewSalary = 0;

        System.out.println("Salary\tYears\tBonus\tNewSalary");

        for (int i = 1; i <= employees; i++) {

            double salary = (int)(Math.random() * 90000) + 10000;
            int years = (int)(Math.random() * 10) + 1;

            double bonus;
            if (years > 5)
                bonus = salary * 0.05;
            else
                bonus = salary * 0.02;

            double newSalary = salary + bonus;

            totalOldSalary += salary;
            totalBonus += bonus;
            totalNewSalary += newSalary;

            System.out.println(salary + "\t" + years + "\t" + bonus + "\t" + newSalary);
        }

        System.out.println("Total Old Salary: " + totalOldSalary);
        System.out.println("Total Bonus: " + totalBonus);
        System.out.println("Total New Salary: " + totalNewSalary);
    }
}
