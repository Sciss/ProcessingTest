package processing.examples.basics.color

import processing.core.PApplet
import processing.core.PConstants._

/** Brightness
  * by Rusty Robison.
  *
  * Brightness is the relative lightness or darkness of a color.
  * Move the cursor vertically over each bar to alter its brightness.
  */
class Brightness extends PApplet {
  var barWidth = 20
  var lastBar  = -1

  override def settings(): Unit = {
    size(640, 360, JAVA2D)
  }

  override def setup(): Unit = {
//    size(640, 360)
    colorMode(HSB, width, 100, width)
    noStroke()
    background(0)
  }

  override def draw(): Unit = {
    val whichBar = mouseX / barWidth
    if (whichBar != lastBar) {
      val barX = whichBar * barWidth
      fill(barX, 100, mouseY)
      rect(barX, 0, barWidth, height)
      lastBar = whichBar
    }
  }
}