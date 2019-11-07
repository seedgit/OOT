mvn archetype:generate -DgroupId=th.ac.kmitl.it.oot.app01 -DartifactId=App01 -DarchetypeArtifactId=maven-archetype-webapp -DinteractiveMode=false


<plugin>
    <groupId>org.apache.tomcat.maven</groupId>
    <artifactId>tomcat7-maven-plugin</artifactId>
    <version>2.2</version>
    <configuration>
      <port>9090</port>
      <path>/</path>
    </configuration>
</plugin>

mvn tomcat7:run
