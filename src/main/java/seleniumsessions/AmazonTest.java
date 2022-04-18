package seleniumsessions;

public class AmazonTest {

	public static void main(String[] args) {

		BrowserUtils br = new BrowserUtils();

		br.launchBrowser("chrome");
		br.launchUrl("https://www.amazon.com");
		String title = br.getPageTitle();
		System.out.println(title);

		if (title.contains("Amazon")) {
			System.out.println("correct title");
		} else {
			System.out.println("Incorrect title");
		}

		System.out.println(br.getPageUrl());

		br.closeBrowser();
	}

}
