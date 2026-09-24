package $package$.playwright

import com.microsoft.playwright.Browser

trait ChromiumBrowser { self: BaseSpec =>
  override protected lazy val browser: Browser = playwright.chromium().launch()
}
