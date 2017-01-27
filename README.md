# ProcessingTest

Builds Scala example of using the [Processing](http://processing.org/) core library, using sbt 0.13.

The examples have been translated from the original Processing Java sources.

To run `sbt run` or `sbt assembly` to create a standalone jar. Currently there is no sketch selection, just exchange the applet in the `Main.scala` class. Note that only sketches using the `JAVA2D` renderer can be placed in a Swing frame.