package io.github.mfaisalkhatri.tests;

import static io.github.mfaisalkhatri.data.ExcelDynamicReader.getData;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

import io.github.mfaisalkhatri.data.ExcelDynamicReader;
import io.github.mfaisalkhatri.data.ScoreData;

public class DynamicExcelReader {

    public static void main (String[] args) {

        String filePath = "./src/test/resources/results_score.xlsx";

        List<Map<String,Object>> table = ExcelDynamicReader.readExcelAsTable (filePath, "Sheet1");
        List<ScoreData> scoreData = getData(table, ScoreData.class);
        System.out.println ("Printing the data with statement using streams map and for loop");

        scoreData.stream ().map (results -> results.getName () + " " +results.getScore ())
            .forEach (System.out::println);

        scoreData.stream ().sorted (Comparator.comparingDouble (ScoreData::getScore).reversed ())
            .forEach (System.out::println);
    }
}