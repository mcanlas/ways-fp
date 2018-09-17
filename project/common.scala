package com.htmlism

import sbt._
import sbt.Keys._

package object helpers {
  def projectAt(s: String): Project =
    Project(s, file(s))

  implicit class CommonSettings(p: Project) {
    def commonSettings: Project =
      p
        .settings(scalaVersion := "2.12.6")
  }
}
