package theinternet.base;

import org.testng.annotations.DataProvider;

public class TestUtilities extends BaseTest{
	//STATIC SLEEP
	protected void sleep(long millis) {
		try {
			Thread.sleep(millis);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	@DataProvider(name="files")
	protected Object[][] files(){
		return new Object[][] {
			{1,"fruits.png"},
			{2,"index.html"},
			{3,"text.txt"}
		};
	}

}
