import sbt.Keys.scalaVersion

val scalaV11 = "2.11.11"
val scalaV12 = "2.12.3"

lazy val project12 = (project in file("project12")).settings(
  name := "p12roject12",
  scalaVersion := scalaV12
).dependsOn(shared2Jvm_2_12)


lazy val project11 = (project in file("project11")).settings(
  name := "p11roject11",
  scalaVersion := scalaV11
).dependsOn(shared2Jvm_2_11)

lazy val shared2 = (crossProject.crossType(CrossType.Pure) in file("shared2")).
  settings(
    name := "schared2",
    libraryDependencies ++= Seq(),
    scalaVersion := scalaV12
  )
  .jsConfigure(_.dependsOn(shared1Js))

lazy val shared2Jvm = shared2.jvm.cross.dependsOn(shared1Jvm)
lazy val shared2Jvm_2_11 = shared2Jvm(scalaV11)
lazy val shared2Jvm_2_12 = shared2Jvm(scalaV12)
lazy val shared2Js = shared2.js


lazy val shared1 = (crossProject.crossType(CrossType.Full) in file("shared1")).
  settings(
    name := "sbhared1",
    libraryDependencies ++= Seq(),
    scalaVersion := scalaV12
  )
  .jsConfigure(_.dependsOn(shared0Js))

lazy val shared1Jvm = shared1.jvm.cross.dependsOn(shared0Jvm)
lazy val shared1Jvm_2_11 = shared1Jvm(scalaV11)
lazy val shared1Jvm_2_12 = shared1Jvm(scalaV12)
lazy val shared1Js = shared1.js

lazy val shared0 = (crossProject.crossType(CrossType.Pure) in file("shared0")).
  settings(
    name := "sahared0",
    libraryDependencies ++= Seq(),
    scalaVersion := scalaV12
  )

lazy val shared0Jvm = shared0.jvm.cross
lazy val shared0Jvm_2_11 = shared0Jvm(scalaV11)
lazy val shared0Jvm_2_12 = shared0Jvm(scalaV12)
lazy val shared0Js = shared0.js