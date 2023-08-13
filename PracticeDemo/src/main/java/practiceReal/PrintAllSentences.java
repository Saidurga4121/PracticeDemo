package practiceReal;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class PrintAllSentences 
{
	static WebDriver driver;

	public static void main(String[] args) {
		WebElement select = driver.findElement(By.xpath("//*[@id='custfoodtable']/tbody/tr[2]/td/div/select"));
		String[] expected = { "GRAM", "OUNCE", "POUND", "MILLIMETER", "TSP", "TBSP", "FLUID_OUNCE" };
		//
		List<WebElement> allOptions = select.findElements(By.tagName("option"));

		// #######################################################################
//			if (expected.length != allOptions.size()) {
//			    System.out.println("fail, wrong number of elements found");
//			}
//			//
//			for (int i = 0; i < expected.length; i++) 
//			{
//			    String optionValue = allOptions.get(i).getAttribute("value");
//			    if (optionValue.equals(expected[i])) 
//			    {
//			        System.out.println("passed on: " + optionValue);
//			    } 
//			    else 
//			    {
//			        System.out.println("failed on: " + optionValue);
//			    }
//			}
		// #######################################################################
		Assert.assertEquals(expected.length, allOptions.size());
		for (int i = 0; i < expected.length; i++) {
			Assert.assertEquals(expected[i], allOptions.get(i).getAttribute("value"));
		}
		// #######################################################################

//			String[] act = new String[allOptions.length];
//			int i = 0;
//			for (WebElement option : allOptions) {
//			    act[i++] = option.getValue();
//			}
		//
//			List<String> expecte = Arrays.asList(expected);
//			List<String> actual = Arrays.asList(act);
		//
//			Assert.assertNotNull(expected);
//			Assert.assertNotNull(actual);
//			Assert.assertTrue(expected.containsAll(actual));
//			Assert.assertTrue(expected.size() == actual.size());

	}
}
