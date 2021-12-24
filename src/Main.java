import java.io.IOException;
import java.sql.*;

public class Main {
    public static void main(String[] args){
        CSVParser parser = new CSVParser();

        String jdbcUrl = "jdbc:sqlite:users.db";
        try {
            Connection c = DriverManager.getConnection(jdbcUrl);
            String sql = "SELECT * FROM users";

            Statement statement = c.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()){
                String name = result.getString("name");
                String email = result.getString("email");

                System.out.println(name + " " + email);
            }
        } catch (SQLException e) {
            System.out.println("error");
            e.printStackTrace();
        }
    }
}
