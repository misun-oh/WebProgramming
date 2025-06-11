package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigTest {
	public static void main(String[] args) {
		Properties prop = new Properties();

        try (FileInputStream fis = new FileInputStream("config.properties")) {
            prop.load(fis);

            String url = prop.getProperty("db.url");
            String user = prop.getProperty("db.user");
            String password = prop.getProperty("db.password");

            System.out.println("DB URL: " + url);
            System.out.println("User: " + user);
            System.out.println("Password: " + password);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}
