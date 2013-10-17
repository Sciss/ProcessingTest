import AssemblyKeys._

name := "ProcessingTest"

version := "0.1.0"

scalaVersion := "2.10.3"

libraryDependencies += "org.scala-lang" % "scala-swing" % scalaVersion.value

fork in run := true

// ---- standalone ----
assemblySettings

target in assembly := baseDirectory.value