package proctest

import processing.core.{PConstants, PApplet}
import PConstants._
import scala.swing._
import Swing._
import scala.swing.event.WindowClosing

object Test extends SimpleSwingApplication {
  def top: MainFrame = new MainFrame {
    title = "Processing"
    val embed = new Primitives3D()
    peer.add(embed)
    embed.init()
    pack()
    size = (640, 360)

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

class Primitives3D extends PApplet {
  override def setup(): Unit = {
    size(640, 360, P3D)
    noLoop()
  }

  override def draw(): Unit = {
    background(0)
    lights()
    noStroke()
    pushMatrix()
    translate(130, height/2, 0)
    rotateY(1.25f)
    rotateX(-0.4f)
    box(100)
    popMatrix()

    noFill()
    stroke(255)
    pushMatrix()
    translate(500, height*0.35f, -200)
    sphere(280)
    popMatrix()
  }

  // override def mousePressed(): Unit = {
  // redraw()
  // }
}

class Colors extends PApplet {
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