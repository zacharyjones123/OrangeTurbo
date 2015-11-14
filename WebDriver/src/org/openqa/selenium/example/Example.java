package org.openqa.selenium.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Example  {
    public static void main(String[] args) {
        // Create a new instance of the html unit driver
        // Notice that the remainder of the code relies on the interface, 
        // not the implementation.
        WebDriver driver = new HtmlUnitDriver();

        // And now use this to visit Google
        //driver.get("http://www.google.com");
        driver.get("http://www4.ncsu.edu/~zrjones/wq6.html");

        // Find the text input element by its name
       // WebElement element = driver.findElement(By.name("q"));
        WebElement nameInputField = driver.findElement(By.id("name"));

        // Enter something to search for
       // element.sendKeys("Cheese!");
        nameInputField.sendKeys("Zachary");

        // Now submit the form. WebDriver will find the form for us from the element
        //element.submit();

        // Check the title of the page
        System.out.println("Page title is: " + driver.getTitle());
        System.out.println("Name input field is :" + nameInputField.getText() );

        driver.quit();
    }
}

/**
 * <table>
 * <tbody>
 * <tr><td>Some Text</td></tr>
 * <tr class="network"><td><input ...>
 * <tr><td>Some More Text</td></tr>
 * <tr class="network"><td><input ...>
 * </tbody>
 * </table>
 * 
 * And code in this Example
 * 
 * List<WebElement> tableRows = radioTable.findElements(By.xpath("tbody/tr"));
 * for (WebElement row : tableRows) {
 *     String s = row.getAttribute("class");
 *     if (s.equals("network")) {
 *     currentGroup.add(row.findElement(By.xpath(//input[@type='radio']")));
 *     }
 * }
 * 
 * --------------------------------------------------------------------------------------
 * For:
 * <input type="text" name="passwd" id="passwd-id" />
 * To:
 * WebElement element;
 * element = driver.findElement(By.id("passwd-id"));
 * element = driver.findElement(By.name("passwd"));
 * element = driver.findElement(By.xpath("//input[@id='passwd-id']"));
 * 
 * -----------------------------------------------------------------------------------------
 * By ID
 * driver.findElement(By.id("element id"))
 * By Class
 * driver.findElement(By.className("element class"))
 * By Name
 * driver.findElement(By.name("element name"))
 * By TagName
 * driver.findElement(By.tagName("element html tag name"))
 * By CSS Selector
 * driver.findElement(By.cssSelector("css selector"))
 * By Link
 * driver.findElement(By.link("link text"))
 * By XPath
 * driver.findElement(By.xpath("xpath expression"))
 */