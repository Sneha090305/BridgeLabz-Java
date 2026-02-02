import java.io.*;

public class UserInputToFile {
    public static void main(String[] args) {
        try {
            BufferedReader br =
                    new BufferedReader(new InputStreamReader(System.in));

            FileWriter fw = new FileWriter("user_details.txt");

            System.out.print("Enter Name: ");
            String name = br.readLine();

            System.out.print("Enter Age: ");
            String age = br.readLine();

            System.out.print("Favorite Language: ");
            String lang = br.readLine();

            fw.write("Name: " + name + "\n");
            fw.write("Age: " + age + "\n");
            fw.write("Language: " + lang + "\n");

            fw.close();
            System.out.println("Data saved to user_details.txt");

        } catch (IOException e) {
            System.out.println("Error occurred while reading/writing");
        }
    }
}
