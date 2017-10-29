package is.ru.hugb;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TestTicTacToe extends SeleniumTestWrapper {
  

  @Test
  public void testClickXWins(){
  	driver.get(baseUrl);
    driver.findElement(By.className("button")).click();
  	driver.findElement(By.id("1")).click();
  	driver.findElement(By.id("2")).click();
  	driver.findElement(By.id("5")).click();
    driver.findElement(By.id("3")).click();
    driver.findElement(By.id("9")).click();
    assertEquals("X WON!", driver.findElement(By.className("message")).getText());
    driver.findElement(By.className("button")).click();
  }

  @Test
  public void testClickOWins(){
    driver.get(baseUrl);
    driver.findElement(By.className("button")).click();
    driver.findElement(By.id("3")).click();
    driver.findElement(By.id("1")).click();
    driver.findElement(By.id("2")).click();
    driver.findElement(By.id("5")).click();
    driver.findElement(By.id("4")).click();
    driver.findElement(By.id("9")).click();
    assertEquals("O WON!", driver.findElement(By.className("message")).getText());
    driver.findElement(By.className("button")).click();
  }

   @Test
  public void testClickTie(){
    driver.get(baseUrl);
    driver.findElement(By.className("button")).click();
    driver.findElement(By.id("1")).click();
    driver.findElement(By.id("3")).click();
    driver.findElement(By.id("2")).click();
    driver.findElement(By.id("4")).click();
    driver.findElement(By.id("6")).click();
    driver.findElement(By.id("5")).click();
    driver.findElement(By.id("7")).click();
    driver.findElement(By.id("8")).click();
    driver.findElement(By.id("9")).click();
    assertEquals("Draw!!", driver.findElement(By.className("message")).getText());
    driver.findElement(By.className("button")).click();
  }
}