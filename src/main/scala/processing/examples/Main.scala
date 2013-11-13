package processing.examples

import scala.swing._
import scala.swing.event.WindowClosing
import java.awt.event.{ComponentEvent, ComponentAdapter}

object Main extends SimpleSwingApplication {
  def top: MainFrame = new MainFrame {
    resizable = false
    pack()
    val embed = new topics.geometry.NoiseSphere // basics.color.Brightness
    title = embed.getClass.getSimpleName
    peer.add(embed)
    embed.init()

    embed.addComponentListener(new ComponentAdapter {
      override def componentResized(e: ComponentEvent): Unit = {
        embed.removeComponentListener(this)
        // println(s"w ${embed.width}, h ${embed.height}; default? ${embed.defaultSize}")
        pack()
        centerOnScreen()
        embed.addComponentListener(this)
      }
    })

    listenTo(this)
    reactions += {
      case WindowClosing(_) =>
        try {
          embed.noLoop()
          embed.stop()
        } finally {
          sys.exit()
        }
    }
  }
}