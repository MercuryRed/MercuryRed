<p align="center">
	<img src="https://avatars3.githubusercontent.com/u/6113075?s=460&v=4" height="130">
</p>
-- TODO START: Create these resources for Mercury Red also
<p align="center">	
	<a href="https://www.codacy.com/gh/LoboEvolution/LoboEvolution/dashboard?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=LoboEvolution/LoboEvolution&amp;utm_campaign=Badge_Grade" alt="Codacy">
		<img src="https://app.codacy.com/project/badge/Grade/899f68bba4a5463d8a7699821d840c5c" />
	</a>
	<a href="https://codebeat.co/projects/github-com-loboevolution-loboevolution-master"><img alt="codebeat badge" src="https://codebeat.co/badges/74e4393e-77b9-44a9-ad98-0b33fb839754" /></a>
	<a href="https://codeclimate.com/github/LoboEvolution/LoboEvolution/maintainability"><img src="https://api.codeclimate.com/v1/badges/eaeed65cfc69b72b4701/maintainability" /></a>
	<a href="" alt="PRs">
		<img src="https://img.shields.io/badge/PRs-welcome-brightgreen.svg" />
	</a>
</p>
<p align="center">
	<a href="https://loboevolution.github.io/LoboEvolution-maven-release/index.html">
		<img src="https://inch-ci.org/github/oswetto/LoboEvolution.svg" alt="Docs">
	</a>
	<a href="http://sourceforge.net/projects/loboevolution/">
		<img src="https://img.shields.io/website-up-down-green-red/http/shields.io.svg" alt="Website">
	</a>
	<a href="https://github.com/oswetto/LoboEvolution/blob/master/LICENSE/">
		<img src="https://img.shields.io/badge/License-GPLv3-blue.svg" alt="GPLv3 license">
	</a>
	<a href="https://github.com/oswetto/LoboEvolution/commits/master">
		<img src="https://img.shields.io/badge/Maintained%3F-yes-green.svg" alt="Maintenance">
	</a>
</p>

<p align="center">
	<a href="https://github.com/oswetto/LoboEvolution/actions?query=workflow%3A%22Java+CI%22">
		<img src="https://github.com/oswetto/LoboEvolution/workflows/Java%20CI/badge.svg" alt="CI">
	</a>
</p>

-- TODO END

Mercury Red is as a fork of Lobo Evolution [credits](https://github.com/LoboEvolution/LoboEvolution).
Mercury Red is an extensible all-Java web browser and RIA platform. It supports HTML 4, HTML 5, Javascript, CSS2/CSS3 and Java (Swing/AWT) rendering.

### Features in progress to be released in Vermilion Release:
 - Multiple Canvas Support (Java Swing, Image in Mwemory, Andoid Canvas, ...)
 - Use as a Component in Java and Android Projects
 - Native Interaction Interface for Automation (without need of Driver, like used in Selenium)


### Building
Create a local clone of the repository and you are ready to start.

### Local Building
Run 
[PlatformInit.java](https://github.com/MercuryRed/MercuryRed/blob/master/LoboEvo/src/main/java/org/loboevolution/init/PlatformInit.java)

### Maven Users
```
mvn install -Dmaven.test.skip=true
```

### Maven Unit Test & report
```
mvn surefire-report:report
```

Show report in [doc folder](https://github.com/MercuryRed/MercuryRed/tree/master/docs) or [TODO - current result](https://mercuryred.github.io/MercuryRed/)


### How To Do
[TODO](https://github.com/MercuryRed/MercuryRed/wiki/How-TODO)

### Status build - TODO
[Build](https://github.com/MercuryRed/MercuryRed/actions)

### Maven Dependency(add in your pom) - TODO (use following from LoboEvolution until MercuryRed ones are ready)
```
<dependency>
  <groupId>com.github.oswetto</groupId>
  <artifactId>loboevolution</artifactId>
  <version>2.0</version>
</dependency>
```
