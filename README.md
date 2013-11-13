# ProcessingTest

Builds Scala example of using the [Processing](http://processing.org/) core library, using sbt 0.13.

Processing libraries must be manually copied into `lib`. (`core.jar` and OpenGL stuff). It has been tested with Processing 2.0.3.

The examples have been translated from the original Processing Java sources.

To run `sbt run` or `sbt assembly` to create a standalone jar. Currently there is no sketch selection, just exchange the applet in the `Main.scala` class.
