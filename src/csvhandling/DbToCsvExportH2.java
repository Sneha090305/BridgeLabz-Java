package csvhandling;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.sql.*;

public class DbToCsvExportH2 {

    public static void main(String[] args) {

        try (
                Connection con = DriverManager.getConnection("jdbc:h2:mem:testdb");
                Statement st = con.createStatement();
                BufferedWriter bw = new BufferedWriter(new FileWriter("db_export.csv"))
        ) {

            // create table
            st.execute("""
                CREATE TABLE employees(
                  id INT,
                  name VARCHAR,
                  department VARCHAR,
                  salary DOUBLE
                )
            """);

            // insert sample rows
            st.execute("INSERT INTO employees VALUES (1,'Amit','IT',60000)");
            st.execute("INSERT INTO employees VALUES (2,'Riya','HR',50000)");
            st.execute("INSERT INTO employees VALUES (3,'Karan','Finance',70000)");

            ResultSet rs = st.executeQuery("SELECT * FROM employees");

            // write CSV
            bw.write("ID,Name,Department,Salary");
            bw.newLine();

            while (rs.next()) {
                bw.write(
                        rs.getInt(1) + "," +
                                rs.getString(2) + "," +
                                rs.getString(3) + "," +
                                rs.getDouble(4)
                );
                bw.newLine();
            }

            System.out.println("Database → CSV export completed.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}