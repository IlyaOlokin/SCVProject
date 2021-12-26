import org.jfree.chart.*;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.chart.ui.ApplicationFrame;

import java.sql.*;

public class LineChartsBuilder extends ApplicationFrame{

    public LineChartsBuilder(String title) {
        super(title);
        //Общий объем финансирования по годам завершения строительства
        JFreeChart lineChart = ChartFactory.createLineChart(title,
                "Год",
                "Общий объём финансирования",
                createDataset(),
                PlotOrientation.VERTICAL,
                true,true,false);

        ChartPanel chartPanel = new ChartPanel( lineChart );
        chartPanel.setPreferredSize( new java.awt.Dimension( 1120 , 734 ) );
        setContentPane(chartPanel);
    }

    public static CategoryDataset createDataset(){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset( );

        try {
            Connection c = DriverManager.getConnection("jdbc:sqlite:DBs/federalTargetProgram.db");
            Statement statement = c.createStatement();

            String sql = "SELECT AVG(totalFunding), strftime('%Y', endDate) year " +
                    "FROM federalTargetProgram " +
                    "GROUP BY year";

            statement = c.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()){
                int year = result.getInt("year");
                if (year == 1970) continue; // skip empty endDate
                dataset.addValue(result.getInt("avg(totalFunding)"), "Общий объём финансирования", String.valueOf(year));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dataset;
    }

}
