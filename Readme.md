# consolerizer-root

---

[![Twitter URL](https://img.shields.io/twitter/url?logoColor=blue&style=social&url=https%3A%2F%2Fimg.shields.io%2Ftwitter%2Furl%3Fstyle%3Dsocial)](https://twitter.com/intent/tweet?text=%20Checkout%20this%20%40github%20repo%20by%20%40joaofse%20%F0%9F%91%A8%F0%9F%8F%BD%E2%80%8D%F0%9F%92%BB%3A%20https%3A//github.com/JEsperancinhaOrg/consolerizer-root)
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

---

[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-50/java-50.png "Java")](https://www.oracle.com/nl/java/)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-50/lombok-50.png "Lombok")](https://projectlombok.org/)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-50/mockito-50.png "Mockito")](https://site.mockito.org/)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-50/assertj-50.png "AssertJ")](https://assertj.github.io/doc/)

---

## Introduction

This project offers way to seamlessly add coloured log messages in academic, study or research projects. This is not a production ready module and shouldn't be used in a production setting. It is designed also for use in tutorials, classes, teaching and knowledge sharing.

#### Stable releases

-   [2.1.0](https://github.com/JEsperancinhaOrg/consolerizer-root/tree/2.1.0) - [1ad22801591b0ff05451d81a9ea4371b514c2fc4](https://github.com/JEsperancinhaOrg/consolerizer-root/tree/2.1.0) - JDK11 - Java


## Inner Modules Java Docs

### Consolerizer

[![javadoc](https://javadoc.io/badge2/org.jesperancinha.console/consolerizer/javadoc.svg)](https://javadoc.io/doc/org.jesperancinha.console/consolerizer)

### Consolerizer for Java 8

[![javadoc](https://javadoc.io/badge2/org.jesperancinha.console/consolerizer8/javadoc.svg)](https://javadoc.io/doc/org.jesperancinha.console/consolerizer8)

## Release Notes

More details on the [Release Notes](ReleaseNotes.md) document
## Maven

Consolerizer for Java 11 and above:

```xml

<dependency>
    <groupId>org.jesperancinha.console</groupId>
    <artifactId>consolerizer</artifactId>
    <version>2.1.0</version>
</dependency>
```

Consolerizer for Java 8 (Discontinued):

```xml

<dependency>
    <groupId>org.jesperancinha.console</groupId>
    <artifactId>consolerizer8</artifactId>
    <version>2.0.3</version>
</dependency>
```

## Delivery to Sonatype Repository

### Tools

```bash
git push --delete origin 2.1.0
git tag --delete 2.1.0
git tag 2.1.0
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

<div align="center">

[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-100/JEOrgLogo-27.png "João Esperancinha Homepage")](http://joaofilipesabinoesperancinha.nl)
[![](https://img.shields.io/badge/youtube-%230077B5.svg?style=for-the-badge&logo=youtube&color=FF0000)](https://www.youtube.com/@joaoesperancinha)
[![](https://img.shields.io/badge/Medium-12100E?style=for-the-badge&logo=medium&logoColor=white)](https://medium.com/@jofisaes)
[![](https://img.shields.io/badge/Buy%20Me%20A%20Coffee-%230077B5.svg?style=for-the-badge&logo=buymeacoffee&color=yellow)](https://www.buymeacoffee.com/jesperancinha)
[![](https://img.shields.io/badge/Twitter-%230077B5.svg?style=for-the-badge&logo=twitter&color=white)](https://twitter.com/joaofse)
[![](https://img.shields.io/badge/Mastodon-%230077B5.svg?style=for-the-badge&logo=mastodon&color=afd7f7)](https://masto.ai/@jesperancinha)
[![](https://img.shields.io/badge/Sessionize-%230077B5.svg?style=for-the-badge&logo=sessionize&color=cffff6)](https://sessionize.com/joao-esperancinha)
[![](https://img.shields.io/badge/Instagram-%230077B5.svg?style=for-the-badge&logo=instagram&color=purple)](https://www.instagram.com/joaofisaes)
[![](https://img.shields.io/badge/Tumblr-%230077B5.svg?style=for-the-badge&logo=tumblr&color=192841)](https://jofisaes.tumblr.com)
[![](https://img.shields.io/badge/Spotify-1ED760?style=for-the-badge&logo=spotify&logoColor=white)](https://open.spotify.com/user/jlnozkcomrxgsaip7yvffpqqm)
[![](https://img.shields.io/badge/linkedin-%230077B5.svg?style=for-the-badge&logo=linkedin)](https://www.linkedin.com/in/joaoesperancinha/)
[![](https://img.shields.io/badge/Xing-%230077B5.svg?style=for-the-badge&logo=xing&color=064e40)](https://www.xing.com/profile/Joao_Esperancinha/cv)
[![](https://img.shields.io/badge/YCombinator-%230077B5.svg?style=for-the-badge&logo=ycombinator&color=d0d9cd)](https://news.ycombinator.com/user?id=jesperancinha)
[![GitHub followers](https://img.shields.io/github/followers/jesperancinha.svg?label=Jesperancinha&style=for-the-badge&logo=github&color=grey "GitHub")](https://github.com/jesperancinha)
[![](https://img.shields.io/badge/bitbucket-%230077B5.svg?style=for-the-badge&logo=bitbucket&color=blue)](https://bitbucket.org/jesperancinha)
[![](https://img.shields.io/badge/gitlab-%230077B5.svg?style=for-the-badge&logo=gitlab&color=orange)](https://gitlab.com/jesperancinha)
[![](https://img.shields.io/badge/Sonatype%20Search%20Repos-%230077B5.svg?style=for-the-badge&color=red)](https://central.sonatype.com/search?smo=true&q=org.jesperancinha)
[![](https://img.shields.io/badge/Stack%20Overflow-%230077B5.svg?style=for-the-badge&logo=stackoverflow&color=5A5A5A)](https://stackoverflow.com/users/3702839/joao-esperancinha)
[![](https://img.shields.io/badge/Credly-%230077B5.svg?style=for-the-badge&logo=credly&color=064e40)](https://www.credly.com/users/joao-esperancinha)
[![](https://img.shields.io/badge/Coursera-%230077B5.svg?style=for-the-badge&logo=coursera&color=000080)](https://www.coursera.org/user/da3ff90299fa9297e283ee8e65364ffb)
[![](https://img.shields.io/badge/Docker-%230077B5.svg?style=for-the-badge&logo=docker&color=cyan)](https://hub.docker.com/u/jesperancinha)
[![](https://img.shields.io/badge/Reddit-%230077B5.svg?style=for-the-badge&logo=reddit&color=black)](https://www.reddit.com/user/jesperancinha/)
[![](https://img.shields.io/badge/Hackernoon-%230077B5.svg?style=for-the-badge&logo=hackernoon&color=0a5d00)](https://hackernoon.com/@jesperancinha)
[![](https://img.shields.io/badge/Dev.TO-%230077B5.svg?style=for-the-badge&color=black&logo=dev.to)](https://dev.to/jofisaes)
[![](https://img.shields.io/badge/Code%20Project-%230077B5.svg?style=for-the-badge&logo=codeproject&color=063b00)](https://www.codeproject.com/Members/jesperancinha)
[![](https://img.shields.io/badge/Free%20Code%20Camp-%230077B5.svg?style=for-the-badge&logo=freecodecamp&color=0a5d00)](https://www.freecodecamp.org/jofisaes)
[![](https://img.shields.io/badge/Hackerrank-%230077B5.svg?style=for-the-badge&logo=hackerrank&color=1e2f97)](https://www.hackerrank.com/jofisaes)
[![](https://img.shields.io/badge/LeetCode-%230077B5.svg?style=for-the-badge&logo=leetcode&color=002647)](https://leetcode.com/jofisaes)
[![](https://img.shields.io/badge/Codewars-%230077B5.svg?style=for-the-badge&logo=codewars&color=722F37)](https://www.codewars.com/users/jesperancinha)
[![](https://img.shields.io/badge/CodePen-%230077B5.svg?style=for-the-badge&logo=codepen&color=black)](https://codepen.io/jesperancinha)
[![](https://img.shields.io/badge/HackerEarth-%230077B5.svg?style=for-the-badge&logo=hackerearth&color=00035b)](https://www.hackerearth.com/@jofisaes)
[![](https://img.shields.io/badge/Khan%20Academy-%230077B5.svg?style=for-the-badge&logo=khanacademy&color=00035b)](https://www.khanacademy.org/profile/jofisaes)
[![](https://img.shields.io/badge/Pinterest-%230077B5.svg?style=for-the-badge&logo=pinterest&color=FF0000)](https://nl.pinterest.com/jesperancinha)
[![](https://img.shields.io/badge/Quora-%230077B5.svg?style=for-the-badge&logo=quora&color=FF0000)](https://nl.quora.com/profile/Jo%C3%A3o-Esperancinha)
[![](https://img.shields.io/badge/Google%20Play-%230077B5.svg?style=for-the-badge&logo=googleplay&color=purple)](https://play.google.com/store/apps/developer?id=Joao+Filipe+Sabino+Esperancinha)
[![](https://img.shields.io/badge/Coderbyte-%230077B5.svg?style=for-the-badge&color=blue&logo=coderbyte)](https://coderbyte.com/profile/jesperancinha)
[![](https://img.shields.io/badge/InfoQ-%230077B5.svg?style=for-the-badge&color=blue&logo=coderbyte)](https://www.infoq.com/profile/Joao-Esperancinha.2/)
[![](https://img.shields.io/badge/OCP%20Java%2011-%230077B5.svg?style=for-the-badge&logo=oracle&color=064e40)](https://www.credly.com/badges/87609d8e-27c5-45c9-9e42-60a5e9283280)
[![](https://img.shields.io/badge/OCP%20JEE%207-%230077B5.svg?style=for-the-badge&logo=oracle&color=064e40)](https://www.credly.com/badges/27a14e06-f591-4105-91ca-8c3215ef39a2)
[![](https://img.shields.io/badge/VMWare%20Spring%20Professional%202021-%230077B5.svg?style=for-the-badge&logo=spring&color=064e40)](https://www.credly.com/badges/762fa7a4-9cf4-417d-bd29-7e072d74cdb7)
[![](https://img.shields.io/badge/IBM%20Cybersecurity%20Analyst%20Professional-%230077B5.svg?style=for-the-badge&logo=ibm&color=064e40)](https://www.credly.com/badges/ad1f4abe-3dfa-4a8c-b3c7-bae4669ad8ce)
[![](https://img.shields.io/badge/Deep%20Learning-%230077B5.svg?style=for-the-badge&logo=ibm&color=064e40)](https://www.credly.com/badges/8d27e38c-869d-4815-8df3-13762c642d64)
[![](https://img.shields.io/badge/Certified%20Neo4j%20Professional-%230077B5.svg?style=for-the-badge&logo=neo4j&color=064e40)](https://graphacademy.neo4j.com/certificates/c279afd7c3988bd727f8b3acb44b87f7504f940aac952495ff827dbfcac024fb.pdf)
[![](https://img.shields.io/badge/Certified%20Advanced%20JavaScript%20Developer-%230077B5.svg?style=for-the-badge&logo=javascript&color=064e40)](https://cancanit.com/certified/1462/)
[![](https://img.shields.io/badge/Kong%20Champions-%230077B5.svg?style=for-the-badge&logo=kong&color=064e40)](https://konghq.com/kong-champions)
[![Generic badge](https://img.shields.io/static/v1.svg?label=GitHub&message=JEsperancinhaOrg&color=064e40&style=for-the-badge "jesperancinha.org dependencies")](https://github.com/JEsperancinhaOrg)
[![Generic badge](https://img.shields.io/static/v1.svg?label=All%20Badges&message=Badges&color=064e40&style=for-the-badge "All badges")](https://joaofilipesabinoesperancinha.nl/badges)
[![Generic badge](https://img.shields.io/static/v1.svg?label=Status&message=Project%20Status&color=orange&style=for-the-badge "Project statuses")](https://github.com/jesperancinha/project-signer/blob/master/project-signer-quality/Build.md)

</div>
