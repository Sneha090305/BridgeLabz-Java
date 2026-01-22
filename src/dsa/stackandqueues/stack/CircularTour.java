import java.util.Scanner;

class CircularTour {

    static int findStartingPoint(int[] petrol, int[] distance) {
        int start = 0, balance = 0, deficit = 0;

        for (int i = 0; i < petrol.length; i++) {
            balance += petrol[i] - distance[i];
            if (balance < 0) {
                deficit += balance;
                start = i + 1;
                balance = 0;
            }
        }
        return (balance + deficit >= 0) ? start : -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of petrol pumps: ");
        int n = sc.nextInt();

        int[] petrol = new int[n];
        int[] distance = new int[n];

        for (int i = 0; i < n; i++) {
            petrol[i] = sc.nextInt();
            distance[i] = sc.nextInt();
        }

        System.out.println(findStartingPoint(petrol, distance));
        sc.close();
    }
}
