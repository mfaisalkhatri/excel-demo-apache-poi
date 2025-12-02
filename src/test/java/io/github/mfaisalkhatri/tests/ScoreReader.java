package io.github.mfaisalkhatri.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import io.github.mfaisalkhatri.data.ResultData;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ScoreReader {

    public static void main (String[] args) {
        String filePath = "./src/test/resources/results_score.xlsx";

        List <ResultData> resultData = getResultData (filePath);
        resultData.forEach (System.out::println);
        System.out.println ("Printing data from first row:");
        System.out.println (resultData.get (0).getName ());
        System.out.println (resultData.get (0).getScore ());

        System.out.println ("Printing the data with statement using streams map and for loop");
        resultData.stream ().map (results -> results.getName () + " " +results.getScore ())
            .forEach (System.out::println);

        System.out.println ("Sorting data in descending order by comparing scores: ");
        resultData.stream ().sorted (Comparator.comparingDouble (ResultData::getScore).reversed ())
            .forEach (System.out::println);
    }

    private static List<ResultData> getResultData (String filePath) {
        List<ResultData> resultDataList = new ArrayList<> ();

        try (
            FileInputStream fis = new FileInputStream (filePath); Workbook workbook = new XSSFWorkbook (fis)) {

            Sheet sheet = workbook.getSheetAt (0);
            for (Row row : sheet) {
                if (row.getRowNum () == 0)
                    continue;
                Cell nameCell = row.getCell (0);
                Cell scoreCell = row.getCell (1);


                if (nameCell != null && scoreCell != null) {
                    String name = nameCell.getStringCellValue ();
                    double score = scoreCell.getNumericCellValue ();
                    resultDataList.add (new ResultData (name, score));
                }
            }
        } catch (IOException e) {
            throw new RuntimeException (e);
        }
        return  resultDataList;
    }
}