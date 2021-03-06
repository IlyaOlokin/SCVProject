import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class CSVParser {
    public List<List<String>> records = new ArrayList<>();

    public CSVParser(){
        records = new ArrayList<>();
        String file = "Спортивные учреждения.csv";
        BufferedReader reader = null;
        String line = "";

        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "windows-1251"));

            line = reader.readLine(); // skip column names
            line = reader.readLine();
            while(line != null) {

                List<String> row = new ArrayList<>();

                row.add(line.substring(0, line.indexOf(',')).replaceAll("\"", "")); // add id
                for (int j = 0; j < line.length(); j++){
                    if (line.charAt(j) == ','){
                        String newCell = "";
                        if (Character.isDigit(line.charAt(j + 1))){
                            var end = line.indexOf(",", j + 2) + 1;
                            if (end == 0){
                                end = line.length() + 1;
                            }
                            newCell = line.substring(j + 1, end - 1);

                            j += newCell.length();
                        }
                        else if (line.charAt(j + 1) != ',') {
                            var end = line.indexOf("\"", j + 2) + 1;
                            if (end == 0){
                                end = line.length() - 1;
                            }
                            newCell = line.substring(j + 1, end);

                            j += newCell.length();
                        }

                        row.add(newCell.replaceAll("\"", "").replace('\'', ' ').replace('&', ' '));
                    }
                }


                if ((line = reader.readLine()) != null) {
                    records.add(row);
                }
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


}
