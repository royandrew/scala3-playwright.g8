package $package$.playwright

class MySpec extends BaseChromiumSpec {
  "playwright" should "succeed" in {   
    page.navigate("https://playwright.dev");
    page.title should include ("Playwright")
  }
}
