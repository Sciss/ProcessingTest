name         := "ProcessingTest"
version      := "0.2.0-SNAPSHOT"
scalaVersion := "2.12.2"

libraryDependencies ++= Seq(
  "org.processing"         %  "core"        % "3.2.3",
  "org.scala-lang.modules" %% "scala-swing" % "2.0.0" 
)

fork in run := true

// ---- standalone ----

target          in assembly := baseDirectory.value
assemblyJarName in assembly := s"${name.value}.jar"
