SHELL := /bin/bash
CONSOLERIZER_VERSION := 2.2.2

b: build
build: build-maven build-maven-spring-boot
build-maven:
	mvn clean install
build-maven-spring-boot:
	cd consolerizer-spring-boot-tester && mvn clean install
test:
	mvn test
local:
	mkdir -p bin
coverage-old:
	mvn clean jacoco:prepare-agent install package jacoco:report omni-coveragereporter:report
coverage:
	mvn clean jacoco:prepare-agent install jacoco:report
report:
	mvn omni-coveragereporter:report
no-test:
	mvn clean install -DskipTests
release-old:
	export GPG_TTY=$(tty); \
	export MAVEN_OPTS=--illegal-access=permit; \
	mvn clean deploy -Prelease; \
	mvn nexus-staging:release -Prelease;
release:
	export GPG_TTY=$(tty); \
	mvn clean deploy -Prelease; \
	mvn nexus-staging:release -Prelease;
update-version:
	bash update_version.sh
install-xmlstarlet:
	sudo apt-get install xmlstarlet