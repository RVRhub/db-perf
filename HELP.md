# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.2.1.RELEASE/gradle-plugin/reference/html/)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.2.1.RELEASE/reference/htmlsingle/#boot-features-developing-web-applications)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)

### Additional Links
These additional references should also help you:

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)



### Docker build image 

```shell script
docker build -t db-perf .
```

### Running the docker image

```shell script
docker run -p 5000:8080 db-perf
```

### Running the docker image in the background, in detached mode.

```shell script
docker run -d -p 5000:8080 db-perf
```


## Pushing the docker image to docker hub

Login with your Docker Id

```shell script
docker login
```

Tag the image

docker tag image username/repository:tag
docker tag db-perf rybak90/db-perf:0.0.1-SNAPSHOT

docker push rybak90/db-perf


mvn package dockerfile:build

mvn dockerfile:push


https://spring.io/guides/topicals/spring-boot-docker/