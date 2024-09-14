# Consolerizer - A small DSL to give color to your console.

---


[![Generic badge](https://img.shields.io/static/v1.svg?label=GitHub&message=Consolerizer&color=informational)](https://github.com/JEsperancinhaOrg/consolerizer-root)
[![GitHub release](https://img.shields.io/github/release-pre/JEsperancinhaOrg/consolerizer-root.svg)](#)
[![Maven Central](https://img.shields.io/maven-central/v/org.jesperancinha.console/consolerizer-root)](https://search.maven.org/search?q=consolerizer-root)
[![javadoc](https://javadoc.io/badge2/org.jesperancinha.console/consolerizer-root/javadoc.svg)](https://javadoc.io/doc/org.jesperancinha.console/consolerizer-root)
[![GitHub License](https://img.shields.io/badge/license-Apache%20License%202.0-blue.svg?style=flat)](https://www.apache.org/licenses/LICENSE-2.0)

[![CircleCI](https://circleci.com/gh/JEsperancinhaOrg/consolerizer-root.svg?style=svg)](https://circleci.com/gh/JEsperancinhaOrg/consolerizer-root)
[![Build status](https://ci.appveyor.com/api/projects/status/w8bav23989g3nhh7?svg=true)](https://ci.appveyor.com/project/jesperancinha/consolerizer-root)
[![consolerizer-root](https://github.com/JEsperancinhaOrg/consolerizer-root/actions/workflows/consolerizer-root.yml/badge.svg)](https://github.com/JEsperancinhaOrg/consolerizer-root/actions/workflows/consolerizer-root.yml)

[![Codacy Badge](https://app.codacy.com/project/badge/Grade/4d5fcd800ef941309dd767ad384eeb0c)](https://www.codacy.com/gh/JEsperancinhaOrg/consolerizer-root/dashboard?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=JEsperancinhaOrg/consolerizer-root&amp;utm_campaign=Badge_Grade)
[![codebeat badge](https://codebeat.co/badges/176e694d-4bc1-4771-9a6c-4cd94bc8f5f8)](https://codebeat.co/projects/github-com-jesperancinhaorg-consolerizer-root-main)
[![Known Vulnerabilities](https://snyk.io/test/github/JEsperancinhaOrg/consolerizer-root/badge.svg)](https://snyk.io/test/github/JEsperancinhaOrg/consolerizer-root)

[![Codacy Badge](https://app.codacy.com/project/badge/Coverage/4d5fcd800ef941309dd767ad384eeb0c)](https://www.codacy.com/gh/JEsperancinhaOrg/consolerizer-root/dashboard?utm_source=github.com&utm_medium=referral&utm_content=JEsperancinhaOrg/consolerizer-root&utm_campaign=Badge_Coverage)
[![Coverage Status](https://coveralls.io/repos/github/JEsperancinhaOrg/consolerizer-root/badge.svg?branch=main)](https://coveralls.io/github/JEsperancinhaOrg/consolerizer-root?branch=main)
[![codecov](https://codecov.io/gh/JEsperancinhaOrg/consolerizer-root/branch/main/graph/badge.svg?token=LQytJ90vR1)](https://codecov.io/gh/JEsperancinhaOrg/consolerizer-root)

[![GitHub language count](https://img.shields.io/github/languages/count/JEsperancinhaOrg/consolerizer-root.svg)](#)
[![GitHub top language](https://img.shields.io/github/languages/top/JEsperancinhaOrg/consolerizer-root.svg)](#)
[![GitHub top language](https://img.shields.io/github/languages/code-size/JEsperancinhaOrg/consolerizer-root.svg)](#)

---

## Technologies used

Please check the [TechStack.md](TechStack.md) file for details.

## Introduction

This project offers way to seamlessly add coloured log messages in academic, study or research projects. This is not a production ready module and shouldn't be used in a production setting. It is designed also for use in tutorials, classes, teaching and knowledge sharing.

#### Stable releases

-   [2.1.0](https://github.com/JEsperancinhaOrg/consolerizer-root/tree/2.1.0) - [1ad22801591b0ff05451d81a9ea4371b514c2fc4](https://github.com/JEsperancinhaOrg/consolerizer-root/tree/2.1.0) - JDK11 - Java
-   [2.2.0](https://github.com/JEsperancinhaOrg/consolerizer-root/tree/2.2.0) - [99d0e9753289a1ea2b69b1297813b29beabb11fe](https://github.com/JEsperancinhaOrg/consolerizer-root/tree/2.2.0) - JDK11 - Java
-   [2.2.1](https://github.com/JEsperancinhaOrg/consolerizer-root/tree/2.2.1) - [fde6a767a53f7f853eba886510208d4f23365800](https://github.com/JEsperancinhaOrg/consolerizer-root/tree/2.2.1) - JDK11 - Java
-   [2.2.2](https://github.com/JEsperancinhaOrg/consolerizer-root/tree/2.2.2) - [b2595480d4e5f929458cfb35c1c33813539ff66d](https://github.com/JEsperancinhaOrg/consolerizer-root/tree/2.2.2) - JDK11 - Java


## Inner Modules Java Docs

### Consolerizer

[![javadoc](https://javadoc.io/badge2/org.jesperancinha.console/consolerizer/javadoc.svg)](https://javadoc.io/doc/org.jesperancinha.console/consolerizer)

## Release Notes

More details on the [Release Notes](ReleaseNotes.md) document

```xml
<dependency>
    <groupId>org.jesperancinha.console</groupId>
    <artifactId>consolerizer</artifactId>
    <version>2.2.3</version>
</dependency>
```

## Delivery to Sonatype Repository

### Tools

```bash
git push --delete origin 2.2.3
git tag --delete 2.2.3
git tag 2.2.3
git push --tags
```

```bash
gpg --keyserver hkp://keyserver.ubuntu.com --send-keys <your GPG key>
gpg --list-keys
export GPG_TTY=$(tty)
mvn clean deploy -Prelease
mvn nexus-staging:release -Prelease
```

```bash
mvn -f coverage.xml clean install coveralls:report -Dconsolerizer.show=false -DrepoToken=${COVERALLS_TOKEN}
```

### Repository settings.xml

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<settings xsi:schemaLocation='http://maven.apache.org/SETTINGS/1.0.0 http://maven.apache.org/xsd/settings-1.0.0.xsd'
          xmlns='http://maven.apache.org/SETTINGS/1.0.0' xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance'>
    <profiles>
        <profile>
            <id>ossrh</id>
            <activation>
                <activeByDefault>true</activeByDefault>
            </activation>
            <properties>
                <gpg.executable>gpg</gpg.executable>
                <gpg.passphrase>{{password}}</gpg.passphrase>
            </properties>
        </profile>
    </profiles>
    <activeProfiles>
        <activeProfile>ossrh</activeProfile>
    </activeProfiles>
    <servers>
        <server>
            <id>ossrh</id>
            <username>{{username}}</username>
            <password>{{password}}</password>
        </server>
    </servers>
</settings>
```

!!Important!!: Please remove test module before release!

---

## References

### Online

-   [Extended ASCII Table from the BBC - Data representation](https://www.bbc.co.uk/bitesize/guides/zscvxfr/revision/4)
-   [Definitive Guide To Java 12](https://blog.codefx.org/java/java-12-guide/)
-   [Publish AAR to jCenter and Maven Central](https://gist.github.com/lopspower/6f62fe1492726d848d6d)
-   [Publishing Android Library to Bintray with Gradle + Buddy.Works](https://medium.com/camerakit/publishing-android-library-to-bintray-with-gradle-buddy-works-dd50cbd03df5)
-   [How to distribute your own Android library through jCenter and Maven Central from Android Studio](https://inthecheesefactory.com/blog/how-to-upload-library-to-jcenter-maven-central-as-dependency/en)
-   [Creating .asc signature files with GPG](http://www.benmccann.com/creating-asc-signature-files-with-gpg/)
-   [Publish java library to JFrog Bintray and OSS Sonatype with Gradle](https://medium.com/@rosolko/publish-java-library-to-jfrog-bintray-and-sonatype-with-gradle-1a3ebd5b8be8)
-   [Enjoy Bintray and use it as pain-free gateway to Maven Central](https://blog.bintray.com/2014/02/11/bintray-as-pain-free-gateway-to-maven-central/)
-   [Android Library Publishing Maven Artifacts via gradle](https://gist.github.com/danielesegato/3ea6f99c968ce0b795c5390844ad4ff7)
-   [Gradle generate javadoc for Android](https://gist.github.com/kibotu/994c9cc65fe623b76b76fedfac74b34b)
-   [A Complete Guide to Create and Publish an Android Library to Maven Central](https://medium.com/@zubairehman.work/a-complete-guide-to-create-and-publish-an-android-library-to-maven-central-6eef186a42f5)
-   [Publish a Java Project to Maven Central with Gradle](http://weibeld.net/java/publish-to-maven-central.html)
-   [Sign and publish on Maven Central a Project with the new maven-publish Gradle plugin](https://medium.com/@nmauti/sign-and-publish-on-maven-central-a-project-with-the-new-maven-publish-gradle-plugin-22a72a4bfd4b)
-   [How to Upload an Open-Source Java Library to Maven Central](https://www.freecodecamp.org/news/how-to-upload-an-open-source-java-library-to-maven-central-cac7ce2f57c/)
-   [Nexus Sonatype](https://oss.sonatype.org/#welcome)
-   [Working with PGP Signatures](https://central.sonatype.org/pages/working-with-pgp-signatures.html)

## About me

[![GitHub followers](https://img.shields.io/github/followers/jesperancinha.svg?label=Jesperancinha&style=for-the-badge&logo=github&color=grey "GitHub")](https://github.com/jesperancinha)
