package Seleniumsessions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDrivermanager {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
     
	}

}
