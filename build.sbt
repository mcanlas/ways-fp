import com.htmlism.helpers._

lazy val cats = projectAt("with-cats")
  .commonSettings
  .settings(libraryDependencies += "org.typelevel" %% "cats-core" % "1.4.0")
  .settings(libraryDependencies += "org.typelevel" %% "cats-effect" % "1.0.0")
  .settings(libraryDependencies += "org.typelevel" %% "mouse" % "0.18")
  .settings(initialCommands in console := "import cats._, cats.data._, cats.implicits._, mouse.all._")

lazy val scalaz = projectAt("with-scalaz")
  .commonSettings
  .settings(libraryDependencies += "org.scalaz" %% "scalaz-ioeffect" % "2.10.1")
