import java.sql.*;
import java.util.List;

public class DbHandler {

    public static void createDb(List<List<String>> data, String dbName){
        String jdbcUrl = "jdbc:sqlite:DBs/" + dbName + ".db";
        //String i = "";

        try {
            Connection c = DriverManager.getConnection(jdbcUrl);

            Statement statement = c.createStatement();
            statement.executeUpdate("create table " + dbName + " (" +
                    "id integer primary key, " +
                    "name varchar(50), " +
                    "nameEN varchar(50)" +
                    ");");
            for (var row: data){
                //i = row.get(0);
                int id = Integer.valueOf(row.get(0).replaceAll("\"", ""));
                String sql = "insert into " + dbName + String.format(" values (%s, '%s', '%s')", id, row.get(1), row.get(2).replace('\'', ' '));
                statement.executeUpdate(sql);

            }

            //String sql = "SELECT * FROM " + dbName;


            String sql = "SELECT * FROM " + dbName;
            statement = c.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()){
                String id = result.getString("id");
                String name = result.getString("name");
                String email = result.getString("nameEN");

                System.out.println(id + " " + name + " " + email);
            }
        } catch (SQLException e) {
            //System.out.println("error on id: " + i);
            e.printStackTrace();
        }
    }
}
