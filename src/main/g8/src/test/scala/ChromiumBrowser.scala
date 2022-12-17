package $package$.playwright

import com.microsoft.playwright.{Playwright, Browser}

trait ChromiumBrowser {
  def playwright: Playwright
  def browser = playwright.chromium().launch();
}
