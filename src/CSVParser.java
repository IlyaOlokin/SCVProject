import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVParser {
    List<List<String>> records = new ArrayList<>();

    public CSVParser(){
        /*List<List<String>> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("Спортивные учреждения.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(" ");
                records.add(Arrays.asList(values));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        var a = 0;*/



        String file = "Спортивные учреждения.csv";
        BufferedReader reader = null;
        String line = "";
        String line2 = "";

        int i = 0;

        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "windows-1251"));
            line = reader.readLine(); // skip column names
            line = reader.readLine();
            while(line != null) {

                String[] row = line.split(",");
                if ((line = reader.readLine()) != null) {
                    records.add(Arrays.asList(row));
                }

                for(String index : row) {

                    //System.out.printf("%-10s", index);

                }
                //System.out.println();
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void fillSQLiteSportsFacilitiesDB(){
        DbHandler.createDb(records, "sportsFacilities");
    }
}
