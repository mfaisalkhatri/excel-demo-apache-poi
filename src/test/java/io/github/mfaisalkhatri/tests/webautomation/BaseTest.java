package io.github.mfaisalkhatri.tests.webautomation;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    protected WebDriver driver;

    @BeforeClass
    public void beforeClass () {
        driver = new ChromeDriver ();
        driver.manage ()
            .window ()
            .maximize ();
        driver.manage ()
            .timeouts ()
            .implicitlyWait (Duration.ofSeconds (30));
    }

    @AfterClass
    public void tearDown () {
        driver.quit ();
    }
}