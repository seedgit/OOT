## How to setup project
1. Create project using command ```mvn archetype:generate -DgroupId=th.ac.kmitl.it.www -DartifactId=bit-app -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false```
2. Go into project folder ```cd bit-app``` (! this folder shoud contain src folder and pom.xml)
3. Compile this project using ```mvn package```
4. ```mvn exec:java -Dexec.mainClass=th.ac.kmitl.it.www.App``` (It should show "Hello World!" in your console)
5. Add Hibernate and mysql connector by copy this xml script to pom.xml
```
<!-- https://mvnrepository.com/artifact/mysql/mysql-connector-java -->
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>8.0.21</version>
</dependency>
<!-- https://mvnrepository.com/artifact/org.hibernate/hibernate-core -->
<dependency>
    <groupId>org.hibernate</groupId>
    <artifactId>hibernate-core</artifactId>
    <version>5.4.22.Final</version>
</dependency>
```
