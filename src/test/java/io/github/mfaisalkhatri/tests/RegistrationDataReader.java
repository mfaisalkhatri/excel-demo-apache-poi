package io.github.mfaisalkhatri.tests;

import static io.github.mfaisalkhatri.data.ExcelDynamicReader.getData;

import java.util.List;
import java.util.Map;

import io.github.mfaisalkhatri.data.ExcelDynamicReader;
import io.github.mfaisalkhatri.data.RegistrationData;

public class RegistrationDataReader {

    public static void main (String[] args) {

        String filePath = "./src/test/resources/registration-test-data.xlsx";
        List<Map<String, Object>> table = ExcelDynamicReader.readExcelAsTable (filePath, "registration-data");
        List<RegistrationData> registrationData = getData (table, RegistrationData.class);
        registrationData
            .forEach (System.out::println);
    }
}