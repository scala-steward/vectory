Global / onChangedBuildSource := ReloadOnSourceChanges

lazy val vectory = crossProject(JVMPlatform, JSPlatform)
  .crossType(CrossType.Pure)
  .settings(
    organization       := "com.github.fdietze",
    name               := "vectory",
    version            := "master-SNAPSHOT",
    crossScalaVersions := Seq("2.12.15", "2.13.8", "3.1.0"),
    scalaVersion       := crossScalaVersions.value.last,
    scalacOptions --= Seq("-Xfatal-warnings"), // overwrite sbt-tpolecat setting

    resolvers += ("jitpack" at "https://jitpack.io"),
    libraryDependencies ++= (
      "org.scalatest"                 %%% "scalatest" % "3.2.11" % Test ::
        "com.github.fdietze.flatland" %%% "flatland"  % "01f4a55" ::
        Nil
    ),
    scalaJSStage in Test               := FullOptStage,
    console / initialCommands          := """
  import vectory._
  """,
  )
  .jvmSettings(
    libraryDependencies += "org.scala-js" %% "scalajs-stubs" % "1.1.0" % "provided",
  )
