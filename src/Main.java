import java.sql.*;

public class Main {
    public static void main(String[] args){
        CSVParser parser = new CSVParser();

        //DbHandler.createSportsFacilitiesTable();
        //DbHandler.fillSportsFacilitiesTable(parser.records);

        //DbHandler.createAddressTable();
        //DbHandler.fillAddressTable(parser.records);

        //DbHandler.createFederalTargetProgramTable();
        //DbHandler.fillFederalTargetProgramTable(parser.records);

        //DbHandler.createSupervisingAuthorityTable();
        //DbHandler.fillSupervisingAuthorityTable(parser.records);

        //DbHandler.createAccessInfoTable();
        //DbHandler.fillAccessInfoTable(parser.records);

        //DbHandler.createСoordinatesTable();
        //DbHandler.fillСoordinatesTable(parser.records);

        //DbHandler.createAdditionalInfoTable();
        //DbHandler.fillAdditionalInfoTable(parser.records);*/

        //avgFunding2012();
        //maxFundingSportsComplex();

        LineChartsBuilder chart = new LineChartsBuilder("Общий объем финансирования по годам завершения строительства");
        chart.pack( );
        chart.setVisible( true );

    }

    public static void avgFunding2012(){
        Connection c = null;
        try {
            c = DriverManager.getConnection("jdbc:sqlite:DBs/federalTargetProgram.db");
            Statement statement = c.createStatement();

            String sql = "SELECT AVG(totalFunding)" +
                    "FROM federalTargetProgram " +
                    "WHERE startDate >= date('2012-01-01')" +
                    "AND startDate < date('2013-01-01')";

            statement = c.createStatement();
            ResultSet result = statement.executeQuery(sql);

            result.next();
            System.out.println("Средний общий объем финансирования за 2012 год: " + result.getLong("avg(totalFunding)"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void maxFundingSportsComplex(){
        Connection c = null;
        try {
            c = DriverManager.getConnection("jdbc:sqlite:DBs/federalTargetProgram.db");




           /*String sql = "SELECT name, totalFunding " +
                    "FROM federalTargetProgram " +
                    "WHERE sportsComplexType LIKE '%многофункциональный спортивный комплекс%' " +
                    "OR sportsComplexType LIKE '%стадион%' " +
                    "WHERE totalFunding = MAX(totalFunding) GROUP BY totalFunding";*/

            String sql = "SELECT name, totalFunding FROM federalTargetProgram " +
                    "WHERE sportsComplexType LIKE '%многофункциональный спортивный комплекс%' " +
                    "OR sportsComplexType LIKE '%стадион%' " +
                    "ORDER BY totalFunding DESC LIMIT 1";




            Statement statement = c.createStatement();
            ResultSet result = statement.executeQuery(sql);

           while (result.next())
           {
               System.out.println("Название: " + result.getString("name"));
               System.out.println("Объем финансирования постройки: " + result.getString("totalFunding"));
           }



            System.out.println();


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
