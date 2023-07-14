FROM maven as build
WORKDIR /build
COPY pom.xml .
COPY src src
RUN mvn clean -DskipTests package

FROM openjdk:17

COPY --from=build /build/target/jira-1.0.jar /jira-1.0.jar
ENTRYPOINT ["java","-Dspring.profiles.active=prod","-jar","/jira-1.0.jar"]
