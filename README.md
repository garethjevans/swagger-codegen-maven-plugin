swagger-codegen-maven-plugin
============================

A Maven plugin to support the swagger code generation project

Prerequisites
============================

This project depends on a number of unreleased features.  These will all need to be built locally until released versions are available.

* swagger-core (develop_2.0)
* swagger-codegen (develop_2.0)

e.g.


	git clone https://github.com/wordnik/swagger-core.git
	cd swagger-core
	git checkout develop_2.0
	mvn clean install
	cd ..
	git clone https://github.com/wordnik/swagger-codegen.git
	cd swagger-codegen
	git checkout develop_2.0
	mvn clean install

Usage
============================

	<build>
		<plugins>
			<plugin>
				<groupId>com.wordnik.swagger</groupId>
				<artifactId>swagger-codegen-maven-plugin</artifactId>
				<version>0.0.1-SNAPSHOT</version>
				<configuration>
					<output>${project.build.directory}/generated-sources/swagger</output>
					<inputSpec>src/main/resources/petstore.json</inputSpec>
					<language>java</language>
				</configuration>
			</plugin>
		</plugins>
	</build>

Followed by:

	mvn swagger-codegen:generate
