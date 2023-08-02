package com.eurotech.tests.day7_TestNG;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class TestNGAssertionDemo {
    @BeforeMethod
    public void setUp() {
        System.out.println("Opening Browser");
    }

    @Test
    public void test1() {
        System.out.println("First Assertion");
        Assert.assertEquals("title", "title", "Checking the titles");

        System.out.println("Second Assertion");
        Assert.assertEquals("url", "URL", "Checking the URLs");
    }

    @Ignore         // this annotation ignore this method from class level run.  2. way: we can put //@Test (comment out this annotation)
    @Test
    public void test2() {
        Assert.assertEquals("tesT", "test", "Test are not equals");
    }

    @Test
    public void test3() {
        String expectedTitle="Euro";
        String actualTitle="Eurotech";
        Assert.assertTrue(actualTitle.contains(expectedTitle), "Checking actualTitle contains 'Euro' or NOT");
        Assert.assertTrue(actualTitle.startsWith(expectedTitle), "Checking if actualTitle starts with 'Euro' .. ");
        Assert.assertNotEquals(actualTitle,expectedTitle,"Actual and Expected Titles are Equal");
    }

    @Test
    public void test14() {
        String email="johndoe@gmail.com";
        Assert.assertTrue(email.contains("@"), "Check mail");
//        Assert.assertTrue(email.contains("?"), "Check mail");
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("Close Browser");
    }
}
