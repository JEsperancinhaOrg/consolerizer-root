#!/usr/bin/env bash

previous=2.2.2
next=2.2.3
xmlstarlet ed -L -N w=http://maven.apache.org/POM/4.0.0 -u '//w:project/w:version' -v "$next" pom.xml
sed -i "s@<version>$previous</version>@<version>$next</version>@g" Readme.md
sed -i "s@git push --delete origin $previous@git push --delete origin $next@g" Readme.md
sed -i "s@git tag --delete $previous@git tag --delete $next@g" Readme.md
sed -i "s@git tag $previous@git tag $next@g" Readme.md
