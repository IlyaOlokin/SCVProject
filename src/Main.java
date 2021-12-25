import java.sql.*;

public class Main {
    public static void main(String[] args){
        CSVParser parser = new CSVParser();

        //DbHandler.createSportsFacilitiesTable();
        //DbHandler.fillSportsFacilitiesTable(parser.records);

        //DbHandler.createAddressTable();
        //DbHandler.fillAddressTable(parser.records);

        //DbHandler.createFederalTargetProgramTable();*/
        //DbHandler.fillFederalTargetProgramTable(parser.records);

        //DbHandler.createSupervisingAuthorityTable();
        //DbHandler.fillSupervisingAuthorityTable(parser.records);

        //DbHandler.createAccessInfoTable();
        //DbHandler.fillAccessInfoTable(parser.records);

        //DbHandler.createСoordinatesTable();
        //DbHandler.fillСoordinatesTable(parser.records);

        //DbHandler.createAdditionalInfoTable();
        //DbHandler.fillAdditionalInfoTable(parser.records);*/

        //meanFunding2012();
        
    }

    public static void meanFunding2012(){
        Connection c = null;
        try {
            c = DriverManager.getConnection("jdbc:sqlite:DBs/federalTargetProgram.db");
            Statement statement = c.createStatement();

            String sql = "SELECT SUM(totalFunding), COUNT(totalFunding) " +
                    "FROM federalTargetProgram " +
                    "WHERE startDate >= date('2012-01-01')" +
                    "AND startDate < date('2013-01-01')";

            statement = c.createStatement();
            ResultSet result = statement.executeQuery(sql);
            long sum = 0;
            double count = 0;
            while (result.next()){
                sum = result.getLong("sum(totalFunding)");
                count = result.getInt("count(totalFunding)");
            }
            //System.out.println(sum);
            //System.out.println(count);
            double res = sum / count;
            System.out.println(String.format("Средний общий объем финансирования за 2012 год: %.1f", res));
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
