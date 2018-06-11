package com.weborder;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Order {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/nkald/Documents/selenium dependencies/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
		driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
		driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
		driver.findElement(By.id("ctl00_MainContent_login_button")).click();
		driver.findElement(By.xpath("//*[@id=\"ctl00_menu\"]/li[3]/a")).click();

		Random rd = new Random();
		int number = rd.nextInt(100 - 1) + 1;
		driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_txtQuantity\"]")).sendKeys("" + number);

		//String middleName = "";

		
		
		 int middleNameLength = rd.nextInt(15);

	        int a = 97; // letter ‘a’
	        int z = 122; // letter ‘z’
	        Random r3 = new Random();
	        StringBuilder sb = new StringBuilder();
	        for (int i = 0; i < middleNameLength; i++) {
	            int randomLetterInt = r3.nextInt(z - a + 1)  + a;
	            sb.append((char) randomLetterInt);
	        }
	        String middleName = sb.toString();  // get a random middleName
		
		
		
		driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_txtName\"]")).sendKeys("John " +middleName+ " Smith");

		driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_TextBox2\"]")).sendKeys("123 Any st");
		driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_TextBox3\"]")).sendKeys("Anytown");
		driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_TextBox4\"]")).sendKeys("Virginia");
		// Random rd1 = new Random();
		int zipcode1 = rd.nextInt(10 - 1) + 1;
		int zipcode2 = rd.nextInt(10 - 1) + 1;
		int zipcode3 = rd.nextInt(10 - 1) + 1;
		int zipcode4 = rd.nextInt(10 - 1) + 1;
		int zipcode5 = rd.nextInt(10 - 1) + 1;

		driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_TextBox5\"]"))
				.sendKeys("" + zipcode1 + "" + zipcode2 + "" + zipcode3 + "" + zipcode4 + "" + zipcode5);

		Random random = new Random();
		int cardType = random.nextInt(3)+1;
		String cardNumber = "";
		String AmericanExpressNumber = "";
		for (int i = 0; i < 15; i++) {
			cardNumber += random.nextInt(10);
		}
		for (int i = 0; i < 14; i++) {
			AmericanExpressNumber += random.nextInt(10);
		}
		//System.out.println(cardType);
		if (cardType == 1) {
			driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_cardList_0\"]")).click();

		} else if (cardType == 2) {
			driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_cardList_1\"]")).click();

		} else  {
			driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_cardList_2\"]")).click();

		}

		if (driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_cardList_0\"]")).isSelected()) {
			driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_TextBox6\"]"))
					.sendKeys("" + 4 + cardNumber);
		} else if (driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_cardList_1\"]")).isSelected()) {
			driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_TextBox6\"]")).sendKeys(""+5+cardNumber);
		} else if (driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_cardList_2\"]")).isSelected()) {
			driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_TextBox6\"]"))
			 .sendKeys("" + 3 + AmericanExpressNumber);
		}

		int m=random.nextInt(12)+1;
		int m1=0;
		String month=""+m;
		if(m<10){
			month=m1+""+m;
		}
		
		int y=random.nextInt(100);
		String year=""+y;
		if (y<10){
			year=m1+""+y;
		}
		driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_TextBox1\"]")).sendKeys(""+month+"/"+year);
		driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_InsertButton\"]")).click();
		
		String expected="New order has been successfully added.";
		String actual=driver.getPageSource();
		if (actual.contains(expected)){
			System.out.println("pass");
		}else{
			System.out.println("fail");
			System.out.println("Expected:\t"+expected);
			System.out.println("Actual:\t"+actual);
		}
		
		
		

	}

}
