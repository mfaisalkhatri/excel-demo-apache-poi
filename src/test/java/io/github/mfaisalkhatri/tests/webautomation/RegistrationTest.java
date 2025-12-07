package io.github.mfaisalkhatri.tests.webautomation;

import static io.github.mfaisalkhatri.data.ExcelDynamicReader.getData;
import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import io.github.mfaisalkhatri.data.ExcelDynamicReader;
import io.github.mfaisalkhatri.data.RegistrationData;
import io.github.mfaisalkhatri.pages.RegistrationPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegistrationTest extends BaseTest {

    @DataProvider
    public Iterator<Object[]> getRegistrationData () {
        String filePath = "./src/test/resources/registration-test-data.xlsx";
        List<Map<String, Object>> table = ExcelDynamicReader.readExcelAsTable (filePath, "registration-data");
        List<RegistrationData> registrationData = getData (table, RegistrationData.class);

        List<Object[]> data = new ArrayList<> ();
        for (RegistrationData reg : registrationData) {
            data.add (new Object[] { reg });
        }
        return data.iterator ();
    }

    @Test (dataProvider = "getRegistrationData")
    public void testRegistrationPasswordAlert (RegistrationData registrationData) {
        RegistrationPage registrationPage = new RegistrationPage (driver);
        driver.get ("https://practicesoftwaretesting.com/auth/register");

        assertEquals (registrationPage.pageHeader (), "Customer registration");
        registrationPage.fillRegistrationForm (registrationData);

        assertEquals (registrationPage.passwordAlertMessage (),
            "The given password has appeared in a data leak. Please choose a different password.");
     }
}