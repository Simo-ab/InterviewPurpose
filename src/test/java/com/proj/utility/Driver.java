package com.proj.utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Driver {




    private Driver() {}


    private static InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();


    public static WebDriver getDriver() {


        if (driverPool.get() == null) {
            String browserName = System.getProperty("browser") != null ? System.getProperty("browser") : ConfigurationReader.getProperty("browser");

            switch(browserName){

                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driverPool.set(new ChromeDriver());
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driverPool.set(new FirefoxDriver());
                    break;
            }

        }

        return driverPool.get();

    }

    public static void closeDriver(){
        if(driverPool.get() != null){
            driverPool.get().quit();
            driverPool.remove();
        }

    }
}