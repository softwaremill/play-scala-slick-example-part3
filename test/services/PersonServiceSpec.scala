package services

import cats.effect.IO
import cats.implicits._
import models.Person
import org.scalatestplus.mockito.MockitoSugar
import org.scalatestplus.play.PlaySpec
import repositories.PersonRepository
import org.mockito.Mockito._

import scala.util.{Failure, Try}


/**
 * https://github.com/mockito/mockito-scala/blob/release/1.x/cats/src/test/scala/org/mockito/cats/MockitoCatsTest.scala
 */
class PersonServiceSpec extends PlaySpec with MockitoSugar with Fixture {

  "A PersonService" must {
    "create person in repository when it previously didn't exists" in {
      //given
      val personRepository = mock[PersonRepository[IO]]
      val personService = new PersonService[IO](personRepository)
      //when
      when(personRepository.get(person.name)).thenReturn(IO.pure(None))
      when(personRepository.create(person.name, person.age)).thenReturn(IO.pure(person))
      //then
      val result = personService.createPerson(person)
      result.unsafeRunSync() mustBe person
    }

    "throw an error if the person already exists" in {
      //given
      val personRepository = mock[PersonRepository[IO]]
      val personService = new PersonService[IO](personRepository)
      //when
      when(personRepository.get(person.name)).thenReturn(IO.pure(Some(person)))
      //then
      val result = personService.createPerson(person)
      a[IllegalArgumentException] must be thrownBy {
        result.unsafeRunSync() mustBe person
      }
    }

    "throw an error if the person already exists with Try" in {
      //given
      val personRepository = mock[PersonRepository[Try]]
      val personService = new PersonService[Try](personRepository)
      //when
      when(personRepository.get(person.name)).thenReturn(Try(Some(person)))
      //then
      val result = personService.createPerson(person)
      result.isFailure mustBe true
    }
  }
}

trait Fixture {
  val person = Person(
    id = Some(1L),
    name = "Tom",
    age = 22)
}
