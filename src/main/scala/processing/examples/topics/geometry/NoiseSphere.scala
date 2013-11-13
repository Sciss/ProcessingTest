package processing.examples.topics.geometry

import processing.core.PApplet
import processing.core.PConstants._

/** Noise Sphere
  * by David Pena.
  *
  * Uniform random distribution on the surface of a sphere.
  */
class NoiseSphere extends PApplet {
  val cuantos = 4000
  val w       = 640
  val h       = 360
  val radio   = h / 3f
  val lista   = Array.fill(cuantos)(new Pelo)

  var rx      = 0f
  var ry      = 0f

  override def setup(): Unit = {
    size(w, h, P3D)
    noiseDetail(3)
  }

  override def draw(): Unit = {
    background(0)
    val wh = width / 2f
    val hh = height / 2f
    translate(wh, hh)

    val rxp = (mouseX - wh) * 0.005f
    val ryp = (mouseY - hh) * 0.005f
    rx      = (rx * 0.9f) + (rxp * 0.1f)
    ry      = (ry * 0.9f) + (ryp * 0.1f)
    rotateY(rx)
    rotateX(ry)
    fill(0)
    noStroke()
    sphere(radio)

    lista.foreach(_.dibujar())
  }

  class Pelo {
    import math.{asin, cos, sin}

    val z0    = random(-radio, radio)
    val phi   = random(TWO_PI)
    val largo = random(1.15f, 1.2f)
    val theta = asin(z0 / radio).toFloat

    def dibujar (): Unit = {
      val off     = (noise(millis() * 0.0005f, sin(phi).toFloat) - 0.5f) * 0.3f
      val offb    = (noise(millis() * 0.0007f, sin(z0).toFloat * 0.01f) - 0.5f) * 0.3f

      val thetaff = theta + off
      val phff    = phi   + offb
      val x       = (radio * cos(theta) * cos(phi)).toFloat
      val y       = (radio * cos(theta) * sin(phi)).toFloat
      val z       = (radio * sin(theta)           ).toFloat

      val xo      = (radio * cos(thetaff) * cos(phff)).toFloat
      val yo      = (radio * cos(thetaff) * sin(phff)).toFloat
      val zo      = (radio * sin(thetaff)            ).toFloat

      val xb      = xo * largo
      val yb      = yo * largo
      val zb      = zo * largo

      beginShape(LINES)
      stroke(0)
      vertex(x, y, z)
      stroke(200, 150)
      vertex(xb, yb, zb)
      endShape()
    }
  }
}