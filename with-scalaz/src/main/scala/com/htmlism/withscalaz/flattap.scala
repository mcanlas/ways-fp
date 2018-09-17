package com.htmlism.withscalaz

import scalaz._, Scalaz._
import scalaz.ioeffect._

object flattap {
  val start: Task[Int] =
    Task(2)

  def sideEffectOnly(n: Int): Task[Char] =
    Task {
      println("throwing away this character")
      'a'
    }

  def nextValue(n: Int): Task[Double] =
    Task(n + 1)
      .map(_.toDouble)

  /**
   * `Scalaz` lacks a named method for the flat tap idiom.
   */
  val withMethods: Task[Double] =
    start flatMap nextValue

  /**
   * The symbolic alias for flat tap `>>!` is similar to the traditional join operator `>>=`.
   */
  val withSymbols: Task[Double] =
    start >>! sideEffectOnly >>= nextValue
}