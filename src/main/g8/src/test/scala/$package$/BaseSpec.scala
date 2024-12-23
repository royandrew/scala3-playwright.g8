package $package$

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

import com.microsoft.playwright.*;

trait BaseSpec extends AnyFlatSpec with Matchers {
  def playwright = Playwright.create()
  def browser: Browser
}
