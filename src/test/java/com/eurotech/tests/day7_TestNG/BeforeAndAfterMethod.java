package com.eurotech.tests.day7_TestNG;

import org.testng.annotations.*;

public class BeforeAndAfterMethod {
    @BeforeClass
    public void setupClass() {
        System.out.println("......Before Class........");
        System.out.println(".....Execute 1 time before the class");
    }

    @AfterClass
    public void tearDownClass() {
        System.out.println("...AFTER CLASS.......");
        System.out.println(".....Some reporting Code here.........");
    }

    @Test
    public void test1() {
        System.out.println("First Test Case");
    }

    @BeforeMethod
    public void setUp() {
        System.out.println("Web driver, opening browser");
        System.out.println("Navigate DevEx Url");
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("Thread.sleep(1000)");
        System.out.println("User logout");
        System.out.println("Closing Browser quit");
    }

    @Test
    public void test2() {
        System.out.println("Second Test Case");
    }

    @Test
    public void test3() {
        System.out.println("Third Test Case");
    }

    @Test
    public void test4() {
        System.out.println("Fourth Test Case");
    }
}
