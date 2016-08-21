name := "ApacheSparkCatalystInternals"

version := "1.0"

scalaVersion := "2.11.8"

val sparkVersion = "1.6.2"

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-sql" % sparkVersion withSources() withJavadoc()
)
    