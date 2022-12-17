package $package$

import com.microsoft.playwright.*;

class MySpec extends BaseSpec {
  "playwright" should "succeed" in {   
    val page = browser.newPage();
    page.navigate("http://playwright.dev");
    page.title shouldBe "Fast and reliable end-to-end testing for modern web apps | Playwright"
  }
}
