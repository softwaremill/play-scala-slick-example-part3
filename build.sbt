name := """play-scala-slick-example-part3"""

version := "2.8.x"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.13.1"

//libraryDependencies += guice
libraryDependencies ++= Seq(jdbc)
libraryDependencies += "org.postgresql" % "postgresql" % "9.4-1201-jdbc41"
libraryDependencies += "com.typesafe.play" %% "play-slick" % "4.0.2"
libraryDependencies += "com.typesafe.play" %% "play-slick-evolutions" % "4.0.2"
libraryDependencies += "org.typelevel" %% "cats-effect" % "2.0.0"
libraryDependencies += "com.softwaremill.macwire" %% "macros" % "2.3.3" % "provided"

libraryDependencies += "com.h2database" % "h2" % "1.4.199"

//libraryDependencies += specs2 % Test
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "5.0.0" % Test
libraryDependencies += "org.mockito" % "mockito-all" % "1.10.19" % Test


scalacOptions ++= Seq(
  "-feature",
  "-deprecation",
  "-Xfatal-warnings",
  "-language:higherKinds"
)
