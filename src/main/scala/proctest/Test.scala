package proctest

import processing.core.{PConstants, PApplet}
import PConstants._
import scala.swing._
import Swing._
import scala.swing.event.WindowClosing

object Test extends SimpleSwingApplication {
  def top: MainFrame = new MainFrame {
    title = "Processing"
    val embed = new Embedded()
    peer.add(embed)
    embed.init()
    pack()
    size = (400, 400)

    listenTo(this)
    reactions += {
      case WindowClosing(_) =>
        embed.noLoop()
        embed.stop()
        sys.exit()
    }

    centerOnScreen()
    open()
  }
}

class Embedded extends PApplet {
  // setPreferredSize(new Dimension(400, 400))

  override def setup(): Unit = {
    size(400, 400)
    colorMode(HSB, 360, 100, height)
    noStroke()
    background(0)
  }

  var barWidth = 5
  var lastBar = -1

  override def draw(): Unit = {
    val whichBar = mouseX / barWidth
    if (whichBar != lastBar) {
      val barX = whichBar * barWidth
      fill(barX, 100, mouseY)
      rect(barX, 0, barWidth, height)
      lastBar = whichBar
    }
  }

  // override def mousePressed(): Unit = {
  // redraw()
  // }
}