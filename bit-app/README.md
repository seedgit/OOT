mvn archetype:generate -DgroupId=th.ac.kmitl.it.www -DartifactId=bit-app -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false
cd bit-app
mvn package

java -cp target/bit-app-1.0-SNAPSHOT.jar th.ac.kmitl.it.www.App

add 
<!-- https://mvnrepository.com/artifact/org.hibernate/hibernate-core -->
<dependency>
    <groupId>org.hibernate</groupId>
    <artifactId>hibernate-core</artifactId>
    <version>5.4.22.Final</version>
</dependency>

to pom.xml