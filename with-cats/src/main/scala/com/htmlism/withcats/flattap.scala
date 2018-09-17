package com.htmlism.withcats

import cats.implicits._
import cats.effect._

object flattap {
  val start: IO[Int] =
    IO(2)

  def sideEffectOnly(n: Int): IO[Char] =
    IO {
      println("throwing away this character")
      'a'
    }

  def nextValue(n: Int): IO[Double] =
    IO(n + 1)
      .map(_.toDouble)

  /**
   * Only `cats` has a named method for `flatTap`.
   */
  val withMethods: IO[Double] =
    start flatTap sideEffectOnly flatMap nextValue

  /**
   * Conversely, it lacks a symbolic representation for `flatTap`.
   */
  val withSymbols: IO[Double] =
    start >>= nextValue
}
