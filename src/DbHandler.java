import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Date;

public class DbHandler {

    public static void createSportsFacilitiesTable(){
        String dbName = "sportsFacilities";
        String jdbcUrl = "jdbc:sqlite:DBs/" + dbName + ".db";

        try {
            Connection c = DriverManager.getConnection(jdbcUrl);
            Statement statement = c.createStatement();

            statement.executeUpdate("CREATE TABLE IF NOT EXISTS " + dbName + " (" +
                    "id integer primary key, " +
                    "name varchar(50), " +
                    "nameEN varchar(50), " +
                    "isActive varchar(1), " +
                    "shortDescription varchar(1000), " +
                    "detailedDescription varchar(1000), " +
                    "shortDescriptionEN varchar(1000), " +
                    "detailedDescriptionEN varchar(1000)" +
                    ");");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void fillSportsFacilitiesTable(List<List<String>> data){
        String dbName = "sportsFacilities";
        String jdbcUrl = "jdbc:sqlite:DBs/" + dbName + ".db";
        int i = 0;
        String sql = "";

        try {
            Connection c = DriverManager.getConnection(jdbcUrl);
            Statement statement = c.createStatement();
            statement.executeUpdate("delete from " + dbName + ";");
            statement.executeUpdate("vacuum;");

            for (var row: data){

                int id = Integer.valueOf(row.get(0));
                i = id;
                sql = "INSERT INTO " + dbName + String.format(" VALUES (%s, '%s', '%s', '%s', '%s', '%s', '%s', '%s');",
                        id,
                        row.get(1),
                        row.get(2),
                        row.get(3),
                        row.get(4),
                        row.get(5),
                        row.get(6),
                        row.get(7)
                        );
                //System.out.println(sql);
                statement.executeUpdate(sql);

            }

            //String sql = "SELECT * FROM " + dbName;


            sql = "SELECT * FROM " + dbName;
            statement = c.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()){
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

    public static void createAddressTable(){
        String dbName = "address";
        String jdbcUrl = "jdbc:sqlite:DBs/" + dbName + ".db";

        try {
            Connection c = DriverManager.getConnection(jdbcUrl);
            Statement statement = c.createStatement();

            statement.executeUpdate("CREATE TABLE IF NOT EXISTS " + dbName + " (" +
                    "id integer primary key, " +
                    "MO varchar(50), " +
                    "subjectOfTheFederation varchar(50), " +
                    "significance varchar(50), " +
                    "locality varchar(50), " +
                    "localityEN varchar(50), " +
                    "address varchar(100), " +
                    "addressEN varchar(100)," +
                    "OKTMO varchar(20)" +
                    ");");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void fillAddressTable(List<List<String>> data){
        String dbName = "address";
        String jdbcUrl = "jdbc:sqlite:DBs/" + dbName + ".db";
        int i = 0;
        String sql = "";

        try {
            Connection c = DriverManager.getConnection(jdbcUrl);
            Statement statement = c.createStatement();
            statement.executeUpdate("delete from " + dbName + ";");
            statement.executeUpdate("vacuum;");

            for (var row: data){

                int id = Integer.valueOf(row.get(0));
                i = id;
                sql = "INSERT INTO " + dbName + String.format(" VALUES (%s, '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s');",
                        id,
                        row.get(8),
                        row.get(9),
                        row.get(10),
                        row.get(11),
                        row.get(12),
                        row.get(13),
                        row.get(14),
                        row.get(15)
                );
                //System.out.println(sql);
                statement.executeUpdate(sql);

            }

            //String sql = "SELECT * FROM " + dbName;


           /*sql = "SELECT * FROM " + dbName;
            statement = c.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()){
                System.out.println(result.getString("id") +
                        " " +
                        result.getString("MO") +
                        " " +
                        result.getString("subjectOfTheFederation") +
                        " " +
                        result.getString("significance") +
                        " " +
                        result.getString("locality") +
                        " " +
                        result.getString("localityEN") +
                        " " +
                        result.getString("address") +
                        " " +
                        result.getString("addressEN") +
                        " " +
                        result.getString("OKTMO"));
            }*/
        } catch (SQLException e) {
            System.out.println("error on id: " + i + "  " + sql);
            e.printStackTrace();
        }
    }

    public static void createFederalTargetProgramTable(){
        String dbName = "federalTargetProgram";
        String jdbcUrl = "jdbc:sqlite:DBs/" + dbName + ".db";

        try {
            Connection c = DriverManager.getConnection(jdbcUrl);
            Statement statement = c.createStatement();

            statement.executeUpdate("CREATE TABLE IF NOT EXISTS " + dbName + " (" +
                    "id integer primary key, " +
                    "FTP varchar(50), " +
                    "name varchar(50), " +
                    "sportsComplexType varchar(100), " +
                    "actions varchar(50), " +
                    "startDate datetime, " +
                    "endDate datetime, " +
                    "totalFunding integer, " +
                    "federalBudgetFunding integer, " +
                    "federalBudgetFundingUsed integer, " +
                    "subjectFunding integer," +
                    "subjectFundingUsed integer," +
                    "municipalityFunding integer," +
                    "municipalityFundingUsed integer," +
                    "extraBudgetarySourcesFunding integer," +
                    "extraBudgetarySourcesFundingUsed integer" +
                    ");");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void fillFederalTargetProgramTable(List<List<String>> data){
        String dbName = "federalTargetProgram";
        String jdbcUrl = "jdbc:sqlite:DBs/" + dbName + ".db";
        int i = 0;
        String sql = "";

        try {
            Connection c = DriverManager.getConnection(jdbcUrl);
            Statement statement = c.createStatement();
            statement.executeUpdate("delete from " + dbName + ";");
            statement.executeUpdate("vacuum;");

            for (var row: data){

                int id = Integer.valueOf(row.get(0));
                i = id;
                sql = "INSERT INTO " + dbName + String.format(" VALUES (%s, '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s');",
                        id,
                        row.get(16),
                        row.get(1),
                        row.get(43),
                        row.get(17),
                        convertStringToTimestamp(row.get(18)),
                        convertStringToTimestamp(row.get(19)),
                        row.get(20),
                        row.get(21),
                        row.get(22),
                        row.get(23),
                        row.get(24),
                        row.get(25),
                        row.get(26),
                        row.get(27),
                        row.get(28)
                );
                //System.out.println(sql);
                statement.executeUpdate(sql);

            }

            //String sql = "SELECT * FROM " + dbName;


           sql = "SELECT * FROM " + dbName;
            statement = c.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()){
                System.out.println(result.getString("id") +
                        " " +
                        result.getString("FTP") +
                        " " +
                        result.getString("name") +
                        " " +
                        result.getString("sportsComplexType") +
                        " " +
                        result.getString("actions") +
                        " " +
                        result.getString("startDate") +
                        " " +
                        result.getString("endDate") +
                        " " +
                        result.getString("totalFunding") +
                        " " +
                        result.getString("federalBudgetFunding") +
                        " " +
                        result.getString("federalBudgetFundingUsed") +
                        " " +
                        result.getString("subjectFunding") +
                        " " +
                        result.getString("subjectFundingUsed") +
                        " " +
                        result.getString("municipalityFunding") +
                        " " +
                        result.getString("municipalityFundingUsed") +
                        " " +
                        result.getString("extraBudgetarySourcesFunding") +
                        " " +
                        result.getString("extraBudgetarySourcesFundingUsed"));

            }
        } catch (SQLException e) {
            System.out.println("error on id: " + i + "  " + sql);
            e.printStackTrace();
        }
    }

    public static void createSupervisingAuthorityTable(){
        String dbName = "supervisingAuthority";
        String jdbcUrl = "jdbc:sqlite:DBs/" + dbName + ".db";

        try {
            Connection c = DriverManager.getConnection(jdbcUrl);
            Statement statement = c.createStatement();

            statement.executeUpdate("CREATE TABLE IF NOT EXISTS " + dbName + " (" +
                    "id integer primary key, " +
                    "supervisingAuthority varchar(50), " +
                    "supervisingAuthorityEN varchar(50), " +
                    "supervisingAuthorityAddress varchar(50), " +
                    "supervisingAuthorityAddressEN varchar(50), " +
                    "supervisingAuthorityPhone varchar(20)" +
                    ");");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void fillSupervisingAuthorityTable(List<List<String>> data){
        String dbName = "accessInfo";
        String jdbcUrl = "jdbc:sqlite:DBs/" + dbName + ".db";
        int i = 0;
        String sql = "";

        try {
            Connection c = DriverManager.getConnection(jdbcUrl);
            Statement statement = c.createStatement();
            statement.executeUpdate("delete from " + dbName + ";");
            statement.executeUpdate("vacuum;");

            for (var row: data){

                int id = Integer.valueOf(row.get(0));
                i = id;
                sql = "INSERT INTO " + dbName + String.format(" VALUES (%s, '%s', '%s', '%s', '%s', '%s');",
                        id,
                        row.get(30),
                        row.get(31),
                        row.get(32),
                        row.get(33),
                        row.get(34)
                );
                //System.out.println(sql);
                statement.executeUpdate(sql);

            }

            //String sql = "SELECT * FROM " + dbName;


            /*sql = "SELECT * FROM " + dbName;
            statement = c.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()){
                System.out.println(result.getString("id") +
                        " " +
                        result.getString("supervisingAuthority") +
                        " " +
                        result.getString("supervisingAuthorityEN") +
                        " " +
                        result.getString("supervisingAuthorityAddress") +
                        " " +
                        result.getString("supervisingAuthorityAddressEN") +
                        " " +
                        result.getString("supervisingAuthorityPhone"));
            }*/
        } catch (SQLException e) {
            System.out.println("error on id: " + i + "  " + sql);
            e.printStackTrace();
        }
    }

    public static void createAccessInfoTable(){
        String dbName = "accessInfo";
        String jdbcUrl = "jdbc:sqlite:DBs/" + dbName + ".db";

        try {
            Connection c = DriverManager.getConnection(jdbcUrl);
            Statement statement = c.createStatement();

            statement.executeUpdate("CREATE TABLE IF NOT EXISTS " + dbName + " (" +
                    "id integer primary key, " +
                    "objectPhone varchar(50), " +
                    "workingHoursMon_Fri varchar(50), " +
                    "workingHoursSat varchar(50), " +
                    "workingHoursSun varchar(50), " +
                    "email varchar(50)," +
                    "url varchar(100)" +
                    ");");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void fillAccessInfoTable(List<List<String>> data){
        String dbName = "accessInfo";
        String jdbcUrl = "jdbc:sqlite:DBs/" + dbName + ".db";
        int i = 0;
        String sql = "";

        try {
            Connection c = DriverManager.getConnection(jdbcUrl);
            Statement statement = c.createStatement();
            statement.executeUpdate("delete from " + dbName + ";");
            statement.executeUpdate("vacuum;");

            for (var row: data){

                int id = Integer.valueOf(row.get(0));
                i = id;
                sql = "INSERT INTO " + dbName + String.format(" VALUES (%s, '%s', '%s', '%s', '%s', '%s', '%s');",
                        id,
                        row.get(35),
                        row.get(36),
                        row.get(37),
                        row.get(38),
                        row.get(40),
                        row.get(41)
                );
                //System.out.println(sql);
                statement.executeUpdate(sql);

            }

            //String sql = "SELECT * FROM " + dbName;


            /*sql = "SELECT * FROM " + dbName;
            statement = c.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()){
                System.out.println(result.getString("id") +
                        " " +
                        result.getString("objectPhone") +
                        " " +
                        result.getString("workingHoursMon_Fri") +
                        " " +
                        result.getString("workingHoursSat") +
                        " " +
                        result.getString("workingHoursSun") +
                        " " +
                        result.getString("email") +
                        " " +
                        result.getString("url"));
            }*/
        } catch (SQLException e) {
            System.out.println("error on id: " + i + "  " + sql);
            e.printStackTrace();
        }
    }

    public static void createСoordinatesTable(){
        String dbName = "coordinates";
        String jdbcUrl = "jdbc:sqlite:DBs/" + dbName + ".db";

        try {
            Connection c = DriverManager.getConnection(jdbcUrl);
            Statement statement = c.createStatement();

            statement.executeUpdate("CREATE TABLE IF NOT EXISTS " + dbName + " (" +
                    "id integer primary key, " +
                    "x integer, " +
                    "y integer, " +
                    "mapScale integer, " +
                    "centerX integer, " +
                    "centerY integer," +
                    "miniX integer," +
                    "miniY integer" +
                    ");");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void fillСoordinatesTable(List<List<String>> data){
        String dbName = "coordinates";
        String jdbcUrl = "jdbc:sqlite:DBs/" + dbName + ".db";
        int i = 0;
        String sql = "";

        try {
            Connection c = DriverManager.getConnection(jdbcUrl);
            Statement statement = c.createStatement();
            statement.executeUpdate("delete from " + dbName + ";");
            statement.executeUpdate("vacuum;");

            for (var row: data){

                int id = Integer.valueOf(row.get(0));
                i = id;
                sql = "INSERT INTO " + dbName + String.format(" VALUES (%s, '%s', '%s', '%s', '%s', '%s', '%s', '%s');",
                        id,
                        row.get(46),
                        row.get(47),
                        row.get(48),
                        row.get(49),
                        row.get(50),
                        row.get(51),
                        row.get(52));
                //System.out.println(sql);
                statement.executeUpdate(sql);

            }

            //String sql = "SELECT * FROM " + dbName;


            /*sql = "SELECT * FROM " + dbName;
            statement = c.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()){
                System.out.println(result.getString("id") +
                        " " +
                        result.getString("x") +
                        " " +
                        result.getString("y") +
                        " " +
                        result.getString("mapScale") +
                        " " +
                        result.getString("centerX") +
                        " " +
                        result.getString("centerY") +
                        " " +
                        result.getString("miniX") +
                        " " +
                        result.getString("miniY"));
            }*/
        } catch (SQLException e) {
            System.out.println("error on id: " + i + "  " + sql);
            e.printStackTrace();
        }
    }

    public static void createAdditionalInfoTable(){
        String dbName = "additionalInfo";
        String jdbcUrl = "jdbc:sqlite:DBs/" + dbName + ".db";

        try {
            Connection c = DriverManager.getConnection(jdbcUrl);
            Statement statement = c.createStatement();

            statement.executeUpdate("CREATE TABLE IF NOT EXISTS " + dbName + " (" +
                    "id integer primary key, " +
                    "registered varchar(10), " +
                    "sportsComplexType varchar(100), " +
                    "competitions varchar(10), " +
                    "sports varchar(200), " +
                    "generalPlan integer," +
                    "supplementaryPlans integer," +
                    "photos integer," +
                    "urlPhotos varchar(100)," +
                    "videos integer," +
                    "panoramas integer," +
                    "webcast integer," +
                    "other integer" +
                    ");");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void fillAdditionalInfoTable(List<List<String>> data){
        String dbName = "additionalInfo";
        String jdbcUrl = "jdbc:sqlite:DBs/" + dbName + ".db";
        int i = 0;
        String sql = "";

        try {
            Connection c = DriverManager.getConnection(jdbcUrl);
            Statement statement = c.createStatement();
            statement.executeUpdate("delete from " + dbName + ";");
            statement.executeUpdate("vacuum;");

            for (var row: data){

                int id = Integer.valueOf(row.get(0));
                i = id;
                sql = "INSERT INTO " + dbName + String.format(" VALUES (%s, '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s');",
                        id,
                        row.get(42),
                        row.get(43),
                        row.get(44),
                        row.get(45),
                        row.get(53),
                        row.get(54),
                        row.get(55),
                        row.get(56),
                        row.get(57),
                        row.get(58),
                        row.get(59),
                        row.get(60));
                //System.out.println(sql);
                statement.executeUpdate(sql);

            }

            //String sql = "SELECT * FROM " + dbName;


            /*sql = "SELECT * FROM " + dbName;
            statement = c.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()){
                System.out.println(result.getString("id") +
                        " " +
                        result.getString("registered") +
                        " " +
                        result.getString("sportsComplexType") +
                        " " +
                        result.getString("competitions") +
                        " " +
                        result.getString("sports") +
                        " " +
                        result.getString("generalPlan") +
                        " " +
                        result.getString("supplementaryPlans") +
                        " " +
                        result.getString("urlPhotos") +
                        " " +
                        result.getString("videos") +
                        " " +
                        result.getString("panoramas") +
                        " " +
                        result.getString("webcast") +
                        " " +
                        result.getString("other"));
            }*/
        } catch (SQLException e) {
            System.out.println("error on id: " + i + "  " + sql);
            e.printStackTrace();
        }
    }

    public static Timestamp convertStringToTimestamp(String strDate) {
        DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        // you can change format of date
        Date date = null;
        try {
            date = formatter.parse(strDate);
            if (date.getYear() + 1900 < 1970){
                return new Timestamp(0);
            }
        } catch (ParseException e) {
            return new Timestamp(0);
        }
        Timestamp timeStampDate = new Timestamp(date.getTime());

        return timeStampDate;
    }


}

