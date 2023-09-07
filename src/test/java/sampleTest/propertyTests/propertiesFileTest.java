package sampleTest.propertyTests;

import seleniumExample.TestNG_Demo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class propertiesFileTest {

    static Properties prop = new Properties();

    public static void main(String[] args) {

        getProperties();
        setProperties();
        getProperties();
    }

    public static void getProperties() {

        try {

            InputStream input = new FileInputStream("src/test/java/config/config.properties");
            prop.load(input);
            String browser=prop.getProperty("browser");
            System.out.println(browser);
            TestNG_Demo.browserName=browser;

        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }

    public static void setProperties()  {

        try {

            OutputStream outPut = new FileOutputStream("src/test/java/config/config.properties");
            prop.setProperty("browser","chrome");
            prop.store(outPut,null);
            String browser=prop.getProperty("browser");
            System.out.println(browser);

        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }





}
