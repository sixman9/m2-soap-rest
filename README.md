This is an example project outlining the use of both Jax-ws (Soap) and Jax-rs (Rest) implementations within a Maven/Spring-based project.

The project uses annotations to highlight which methods are to be exposed by which web service framework and with which naming and/or access paths (URL's etc.).

The project will produce a WAR file using:

  mvn package

and maybe deployed to a [local] Tomcat [manager] instance (assumed to be running at http://localhost:8080) using:

  mvn install

Eclipse projects can be generated via:

  mvn eclipse:eclipse