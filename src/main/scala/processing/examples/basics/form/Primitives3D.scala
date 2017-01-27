package processing.examples.basics.form

import processing.core.PApplet
import processing.core.PConstants._

/** Primitives 3D.
  *
  * Placing mathematically 3D objects in synthetic space.
  * The lights() method reveals their imagined dimension.
  * The box() and sphere() functions each have one parameter
  * which is used to specify their size. These shapes are
  * positioned using the translate() function.
  */
class Primitives3D extends PApplet {
  override def settings(): Unit = {
    size(640, 360, P3D)
  }

  override def setup(): Unit = {
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
}