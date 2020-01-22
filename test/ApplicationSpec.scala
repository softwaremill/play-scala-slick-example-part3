import org.scalatestplus.play.{BaseOneAppPerTest, PlaySpec}
import play.api.test.Helpers._
import play.api.test._

/**
  *
  */
class ApplicationSpec extends PlaySpec
  with BaseOneAppPerTest
  with FPSlickExampleApplicationFactory {

  "Routes" should {
    "send 404 on a bad request" in {
      route(app, FakeRequest(GET, "/booom")).map(status(_)) mustBe Some(NOT_FOUND)
    }
  }

  "PersonController" should {
    "render the index page" in {
      val home = route(app, FakeRequest(GET, "/")).get

      status(home) mustBe OK
      contentType(home) mustBe Some("text/html")
      contentAsString(home) must include("Welcome to Play FP Slick Example")
    }
  }

}
