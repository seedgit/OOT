
1. mvn archetype:generate -DgroupId=th.ac.kmitl.it.oot -DartifactId=MotorCycle -DarchetypeArtifactId=maven-archetype-webapp

2. TO RUN THE APPLICATION USING MAVEN, ADD THE JETTY MAVEN-PLUGIN TO YOUR POM.XML
pom.xml jetty plugin

<build>
    ...   
    <plugins>
        <plugin>
            <groupId>org.eclipse.jetty</groupId>
            <artifactId>jetty-maven-plugin</artifactId>
            <version>9.4.7.v20170914</version>
            <configuration>
                <webApp>
                    <contextPath>/${build.finalName}</contextPath>
                </webApp>
                <stopKey>CTRL+C</stopKey>
                <stopPort>8999</stopPort>
                <scanIntervalSeconds>10</scanIntervalSeconds>
                <scanTargets>
                    <scanTarget>src/main/webapp/WEB-INF/web.xml</scanTarget>
                </scanTargets>
            </configuration>
        </plugin>
    </plugins>
</build>
The above plugin will enable you to run the application using mvn jetty:run

3. Add Struts 2 Jar Files To Class Path
pom.xml dependency node

<dependency>
    <groupId>org.apache.struts</groupId>
    <artifactId>struts2-core</artifactId>
    <version>${struts2.version}</version>
</dependency>

**replace the ${struts2.version} with the current Struts 2 version (or define within pom properties). Maven will get the struts2-core jar and the other jar files struts2-core requires (transitive dependencies).

4. Add Logging
To see what’s happening under the hood, the example application for this tutorial uses log4j2. Setup a log4j2.xml configuration in the src/main/resources folder which contains the following

log4j2.xml

<?xml version="1.0" encoding="UTF-8"?>
<Configuration>
    <Appenders>
        <Console name="STDOUT" target="SYSTEM_OUT">
            <PatternLayout pattern="%d %-5p [%t] %C{2} (%F:%L) - %m%n"/>
        </Console>
    </Appenders>
    <Loggers>
        <Logger name="com.opensymphony.xwork2" level="debug"/>
        <Logger name="org.apache.struts2" level="debug"/>
        <Root level="warn">
            <AppenderRef ref="STDOUT"/>
        </Root>
    </Loggers>
</Configuration>

pom.xml log4j dependency node

<dependency>
    <groupId>org.apache.logging.log4j</groupId>
    <artifactId>log4j-core</artifactId>
    <version>${log4j2.version}</version>
</dependency>
<dependency>
    <groupId>org.apache.logging.log4j</groupId>
    <artifactId>log4j-api</artifactId>
    <version>${log4j2.version}</version>
</dependency>