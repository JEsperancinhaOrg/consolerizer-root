SHELL := /bin/bash
CONSOLERIZER_PRE_VERSION := 2.2.2
CONSOLERIZER_VERSION := 2.2.3

b: build
build: build-maven build-maven-spring-boot
build-maven:
	mvn clean install
build-maven-spring-boot:
	cd consolerizer-spring-boot-tester; \
	mvn clean install
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
	bash update_version.sh $(CONSOLERIZER_PRE_VERSION) $(CONSOLERIZER_VERSION)
install-xmlstarlet:
	sudo apt-get install xmlstarlet
get-consolerizer-first-version-spring:
	xmlstarlet select -N w=http://maven.apache.org/POM/4.0.0 --template --match '//w:project/w:dependencies/w:dependency' --value-of '*[last()]' --nl consolerizer-spring-boot-tester/pom.xml
deps-plugins-update:
	curl -sL https://raw.githubusercontent.com/jesperancinha/project-signer/master/pluginUpdatesOne.sh | bash -s -- $(PARAMS)
deps-java-update:
	curl -sL https://raw.githubusercontent.com/jesperancinha/project-signer/master/javaUpdatesOne.sh | bash
deps-node-update:
	curl -sL https://raw.githubusercontent.com/jesperancinha/project-signer/master/nodeUpdatesOne.sh | bash
deps-quick-update: deps-plugins-update deps-java-update deps-node-update
accept-prs:
	curl -sL https://raw.githubusercontent.com/jesperancinha/project-signer/master/acceptPR.sh | bash
