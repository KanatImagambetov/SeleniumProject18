package test.day5_firstNG;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class TestNG {
    @BeforeMethod
    public void setUp(){
        System.out.println("Before method running...");
    }
    @AfterMethod
    public void tearDown(){
        System.out.println("After method running...");
    }
    @Test
    public void test1(){
        System.out.println("Test1 is running...");
    }
    @Test
    public void test2(){
        System.out.println("Test2 is running...");
    }
}