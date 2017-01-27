package processing.examples

import javax.swing.JFrame

import processing.awt.PSurfaceAWT
import processing.core.PApplet

import scala.swing._
import scala.swing.event.WindowClosing

object Main extends SimpleSwingApplication {
  def top: MainFrame = {
    // NoiseSphere needs OpenGL
//    val sketch = new topics.geometry.NoiseSphere
    val sketch = new basics.color.Brightness

    // ---- all this bullshit of removal of necessary API was introduced in Processing 3 ----

    val pAppletClass    = classOf[PApplet]
    val pAppletMethods  = pAppletClass.getDeclaredMethods

//    pAppletMethods.map(_.getName).sorted.foreach(println)

    val mHandleSettings = pAppletMethods.find(_.getName == "handleSettings").get
    mHandleSettings.setAccessible(true)
    mHandleSettings.invoke(sketch)
    val mInitSurface    = pAppletMethods.find(_.getName == "initSurface").get
    mInitSurface.setAccessible(true)
    val surface = mInitSurface.invoke(sketch) match {
      case s: PSurfaceAWT => s
      case _ => sys.error("Processing does not use AWT rendering")
    }
    val mStartSurface    = pAppletMethods.find(_.getName == "startSurface").get
    mStartSurface.setAccessible(true)

    val canvas = surface.getNative match {
      case c: java.awt.Canvas => c
      case _ => sys.error("Processing does not use AWT rendering")
    }

    canvas.getParent.remove(canvas)

    new MainFrame {
      resizable = false
      title     = sketch.getClass.getSimpleName
      pack()
      listenTo(this)
      reactions += {
        case WindowClosing(_) =>
          try {
            sketch.noLoop()
            sketch.stop()
          } finally {
            sys.exit()
          }
      }
      override lazy val peer: JFrame with InterfaceMixin = new JFrame with InterfaceMixin {
        getContentPane.add(canvas)
        mStartSurface.invoke(sketch)
      }
    }
  }
}