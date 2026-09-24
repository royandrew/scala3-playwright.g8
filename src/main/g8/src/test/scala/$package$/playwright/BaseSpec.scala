package $package$.playwright

import java.nio.file.{Files, Paths}
import java.time.Instant

import com.microsoft.playwright.{Browser, Page, Playwright}
import org.scalatest.{BeforeAndAfterAll, Outcome}
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

trait BaseSpec extends AnyFlatSpec with Matchers with BeforeAndAfterAll {
  protected lazy val playwright: Playwright = Playwright.create()
  protected def browser: Browser
  private var currentPage: Option[Page] = None

  protected def page: Page = currentPage.getOrElse(
    throw new IllegalStateException("The Playwright page is only available while a test is running")
  )

  override protected def withFixture(test: NoArgTest): Outcome = {
    val testPage = browser.newPage()
    currentPage = Some(testPage)

    try {
      val outcome = super.withFixture(test)

      if (outcome.isFailed) {
        captureScreenshot(test.name)
      }

      outcome
    } finally {
      try {
        testPage.close()
      } finally {
        currentPage = None
      }
    }
  }

  private def captureScreenshot(testName: String): Unit = {
    val screenshotDirectory = Paths.get("target", "screenshots")
    val screenshotPath = screenshotDirectory.resolve(
      sanitize(suiteName) + "-" + sanitize(testName) + "-" + Instant.now().toEpochMilli + ".png"
    )

    try {
      Files.createDirectories(screenshotDirectory)
      page.screenshot(
        new Page.ScreenshotOptions()
          .setPath(screenshotPath)
          .setFullPage(true)
      )
      info("Saved failure screenshot to " + screenshotPath.toAbsolutePath)
    } catch {
      case error: Exception =>
        alert("Could not save failure screenshot: " + error.getMessage)
    }
  }

  private def sanitize(value: String): String =
    value.replaceAll("[^A-Za-z0-9._-]+", "_")

  override protected def afterAll(): Unit = {
    try {
      browser.close()
    } finally {
      try {
        playwright.close()
      } finally {
        super.afterAll()
      }
    }
  }
}
