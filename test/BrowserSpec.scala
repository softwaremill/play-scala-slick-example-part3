import org.scalatestplus.play._

class BrowserSpec
  extends PlaySpec
    with BaseOneServerPerTest
    with OneBrowserPerTest
    with FPSlickExampleApplicationFactory
    with HtmlUnitFactory {

  "BrowserSpec" should {

    "work from within a browser" in {

      go to ("http://localhost:" + port)

      pageSource must include ("Welcome to Play FP Slick Example")
    }
  }
}