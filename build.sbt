name := "BoardDrawingEngine"

version := "1.0.6"

scalaVersion := "2.13.8"

scalacOptions ++= Seq("-unchecked", "-deprecation", "-Xcheckinit", "-encoding", "utf8", "-Ymacro-annotations")

Compile / resourceDirectory := (Compile / scalaSource).value
libraryDependencies ++= Seq(
  "org.scalafx" %% "scalafx" % "18.0.1-R27",
  "org.scalafx" %% "scalafxml-core-sfx8" % "0.5"
)

// Add OS specific JavaFX dependencies
val javafxModules = Seq("base", "controls", "fxml", "graphics", "media", "swing", "web")
val osName = System.getProperty("os.name") match {
  case n if n.startsWith("Linux") => "linux"
  case n if n.startsWith("Mac") => "mac"
  case n if n.startsWith("Windows") => "win"
  case _ => throw new Exception("Unknown platform!")
}
libraryDependencies ++= javafxModules.map(m => "org.openjfx" % s"javafx-$m" % "18.0.1" classifier osName)
libraryDependencies += "com.jfoenix" % "jfoenix" % "9.0.10"

resolvers += Opts.resolver.sonatypeSnapshots

// Fork a new JVM for 'run' and 'test:run', to avoid JavaFX double initialization problems
fork := true