package test.day9_testbase_properties_driverUtil;

import utilities.ConfigurationReader;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadingFromProperties {
    @Test
    public void reading_properties_file() throws IOException {
        //
        Properties properties=new Properties();
        String path="configuration.properties";
        FileInputStream file=new FileInputStream(path);

        properties.load(file);

        System.out.println("properties.getProperty(\"browser\") = " + properties.getProperty("browser"));
        System.out.println("properties.getProperty(\"username\") = " + properties.getProperty("username"));
        System.out.println("properties.getProperty(\"password\") = " + properties.getProperty("password"));
    }
    @Test
    public void using(){
        String browser=ConfigurationReader.getProperty("browser");
        System.out.println("browser = " + browser);
        String username=ConfigurationReader.getProperty("username");
        System.out.println("username = " + username);
    }
}
