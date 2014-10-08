package edu.luc.etl.cs313.scala.shapes.model

import scala.language.postfixOps

/**
 * A visitor to compute the number of basic shapes in a (possibly complex) shape.
 */
object size {

  // TODO entirely your job

  def apply(s: Shape): Int = s match {
    case Circle(_) => 1
    case Rectangle(_, _) => 1
    case Polygon(_, _, _, _) => 1
    case Location(_, _, shape) =>
      var len = 0
      len+=this.apply(shape)
      len
    case Fill(shape) =>
      var len = 0
      len+=this.apply(shape)
      len
    case Outline(shape) =>
      var len = 0
      len+=this.apply(shape)
      len
    case Stroke(_, shape) =>
      var len = 0
      len+=this.apply(shape)
      len
    case Group(shapeList) =>
      var len = 0
      for (shape:Shape <- shapeList) {
        len+=this.apply(shape)
      }
      len
    case _ => -1
  }
}