import java.sql.*;
import java.util.List;

public class DbHandler {

    public static void createSportsFacilitiesDb(){
        String dbName = "sportsFacilities";
        String jdbcUrl = "jdbc:sqlite:DBs/" + dbName + ".db";

        try {
            Connection c = DriverManager.getConnection(jdbcUrl);
            Statement statement = c.createStatement();

            statement.executeUpdate("create table " + dbName + " (" +
                    "id integer primary key, " +
                    "name varchar(50), " +
                    "nameEN varchar(50), " +
                    "isActive varchar(1), " +
                    "shortDescription varchar(1000), " +
                    "detailedDescription varchar(5000), " +
                    "shortDescriptionEN varchar(1000), " +
                    "detailedDescriptionEN varchar(5000)" +
                    ");");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void fillSportsFacilitiesDb(List<List<String>> data){
        String dbName = "sportsFacilities";
        String jdbcUrl = "jdbc:sqlite:DBs/" + dbName + ".db";
        int i = 0;
        String sql = "";

        try {
            Connection c = DriverManager.getConnection(jdbcUrl);
            Statement statement = c.createStatement();
            statement.executeUpdate("delete from sportsFacilities;");
            statement.executeUpdate("vacuum;");

            for (var row: data){

                int id = Integer.valueOf(row.get(0).replaceAll("\"", ""));
                i = id;
                sql = "INSERT INTO " + dbName + String.format(" VALUES (%s, '%s', '%s', '%s', '%s', '%s', '%s', '%s');",
                        id,
                        row.get(1),
                        row.get(2).replace('\'', ' '),
                        row.get(3).replace('\'', ' ').replace('&', ' '),
                        row.get(4).replace('\'', ' ').replace('&', ' '),
                        row.get(5).replace('\'', ' ').replace('&', ' '),
                        row.get(6).replace('\'', ' ').replace('&', ' '),
                        row.get(7).replace('\'', ' ').replace('&', ' ')
                        );
                //System.out.println(sql);
                statement.executeUpdate(sql);

            }

            //String sql = "SELECT * FROM " + dbName;


            sql = "SELECT * FROM " + dbName;
            statement = c.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()){
                String id = result.getString("id");
                String name = result.getString("name");
                String email = result.getString("nameEN");

                System.out.println(result.getString("id") +
                        " " +
                        result.getString("name") +
                        " " +
                        result.getString("nameEN") +
                        " " +
                        result.getString("isActive") +
                        " " +
                        result.getString("shortDescription") +
                        " " +
                        result.getString("detailedDescription") +
                        " " +
                        result.getString("shortDescriptionEN") +
                        " " +
                        result.getString("detailedDescriptionEN"));
            }
        } catch (SQLException e) {
            System.out.println("error on id: " + i + "  " + sql);
            e.printStackTrace();
        }
    }

}

