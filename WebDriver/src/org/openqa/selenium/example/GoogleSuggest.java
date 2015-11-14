package org.openqa.selenium.example;

import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GoogleSuggest {
    public static void main(String[] args) throws Exception {
        // The Firefox driver supports javascript 
        WebDriver driver = new FirefoxDriver();
        
        // Go to the Google Suggest home page
        //driver.get("http://www.google.com/webhp?complete=1&hl=en");
        driver.get("http://www4.ncsu.edu/~zrjones/wq6.html");
        
        // Enter the query string "Cheese"
        //WebElement query = driver.findElement(By.name("q"));
        //query.sendKeys("Cheese!");
        WebElement nameInputField = driver.findElement(By.id("name"));
        WebElement emailInputField = driver.findElement(By.id("email"));

        // Sleep until the div we want is visible or 5 seconds is over
        long end = System.currentTimeMillis() + 5000;
        while (System.currentTimeMillis() < end) {
        	Scanner input = new Scanner(System.in);
        	nameInputField.sendKeys(input.next());
        	emailInputField.sendKeys(input.next());
        	
            WebElement resultsDiv = driver.findElement(By.className("gssb_e"));

            // If results have been returned, the results are displayed in a drop down.
            if (resultsDiv.isDisplayed()) {
              break;
            }
        }

        // And now list the suggestions
        List<WebElement> allSuggestions = driver.findElements(By.xpath("//td[@class='gssb_a gbqfsf']"));
        
        for (WebElement suggestion : allSuggestions) {
            System.out.println(suggestion.getText());
        }

        driver.quit();
    }
}