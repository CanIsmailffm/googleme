package com;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class googleme {

    public static void main(String[] args) throws InterruptedException {

            WebDriverManager.chromedriver().setup();

            WebDriver driver = new ChromeDriver();

            String search = args[0];

            driver.get("https://www.google.de/");

            driver.findElement(By.name("q")).sendKeys(search + Keys.ENTER);
            String ergebnisse = driver.findElement(By.id("result-stats")).getText();
            String [] delimeter = ergebnisse.split(" \\(");
            System.out.println(delimeter[0] + ". Die ersten 3 sind:");

            String a1 = driver.findElement(By.xpath("(//div[@class='r']//cite)[1]")).getText();
            String a2 = driver.findElement(By.xpath("(//div[@class='r']//cite)[3]")).getText();
            String a3 = driver.findElement(By.xpath("(//div[@class='r']//cite)[5]")).getText();

            System.out.println(a1 + "\n" + a2 + "\n" + a3);

            Thread.sleep(2000);

            driver.quit();


    }

}

