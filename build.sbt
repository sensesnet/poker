name := "poker-hand-evaluator"

version := "0.1"

scalaVersion := "2.13.3"

libraryDependencies ++= Seq(
  "io.circe" %% "circe-generic-extras" % "0.13.0",
  "com.beachape" %% "enumeratum-circe" % "1.6.1",
  "org.scalatest" %% "scalatest" % "3.2.3" % "test"
)