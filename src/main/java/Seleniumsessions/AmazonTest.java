package Seleniumsessions;

public class AmazonTest {

	public static void main(String[] args) {

		BrowserUtil util = new BrowserUtil();
		util.launchBrowser("chrome");
		util.launchUrl("https://demo.opencart.com/index.php?route=account/login");
		String title = util.getPageTitle();
		System.out.println(title);
		String url = util.getPageUrl();
		System.out.println(url);
		util.closeBrowser();

	}

}
