import org.scalatestplus.play.FakeApplicationFactory
import play.api.inject.DefaultApplicationLifecycle
import play.api.{Application, ApplicationLoader, Configuration, Environment}
import play.core.DefaultWebCommands
import wiring.AppLoader

trait FPSlickExampleApplicationFactory extends FakeApplicationFactory {

  private class FPSlickExampleApplicationBuilder {
    def build(): Application = {
      val env = Environment.simple()
      val context = ApplicationLoader.Context.create(env)
      val loader = new AppLoader()
      loader.load(context)
    }
  }

  def fakeApplication(): Application = new FPSlickExampleApplicationBuilder().build()

}

