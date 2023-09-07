package sampleTest.dataProviderTests;

import org.testng.annotations.Test;

public class DataProviderInheritedTest2 {

    @Test(dataProvider = "data-provider", dataProviderClass = DP.class)
    public void myTest (String val) {
        System.out.println("Current Status : " + val);
    }

}