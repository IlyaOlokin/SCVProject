import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class CSVParser {

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

        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "windows-1251"));
            while((line = reader.readLine()) != null) {

                String[] row = line.split(",");

                for(String index : row) {
                    System.out.printf("%-10s", index);
                }
                System.out.println();
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                reader.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
