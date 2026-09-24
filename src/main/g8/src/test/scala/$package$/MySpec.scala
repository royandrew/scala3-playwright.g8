package $package$.playwright

import com.microsoft.playwright.*;

class MySpec extends BaseChromiumSpec {
  "playwright" should "succeed" in {   
    val page = browser.newPage();
    page.navigate("https://playwright.dev");
    page.title shouldBe "Fast and reliable end-to-end testing for modern web apps | Playwright"
  }
}
