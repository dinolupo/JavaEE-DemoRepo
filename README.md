# Sample Java EE repository for demo Web Service

I am using Wildfly 11 in the following examples.

Examples shown in this repository:

## Example 1 - Class loader isolation betweeen Web Services

Language: **Scala**

Description: show that a simple Singleton Cache object in an Application servers is isolated thanks to the classloading 

#### 1) compile and install the 2 wars

> org.wildfly.plugins:wildfly-maven-plugin:2.1.0.Beta1:deploy

```bash
mvn clean install

cd ws1
mvn wildfly:deploy

cd ..
cd ws2
mvn wildfly:deploy
``` 

#### 2) open Postman (or curl command line) and do the following 

put some keys to the following *PUT* endpoint

```
http://127.0.0.1:8080/ws1/resources/cache/test1
http://127.0.0.1:8080/ws1/resources/cache/test2
http://127.0.0.1:8080/ws1/resources/cache/test3
```


You can show the current cached values at the following *GET* endpoints

```
http://127.0.0.1:8080/ws1/resources/cache
```

Do the same with the **ws2** and verify that the cached keys mantain the isolation between the web services.


## Example 2 - Class loader isolation betweeen Web Services

Language: **Java**

Description: sample configuration of a swagger service descriptor with RestEasy

Documentation at: [Github Swagger](https://github.com/swagger-api/swagger-core/wiki/Swagger-Core-RESTEasy-2.X-Project-Setup-1.5#using-the-application-class)

> org.wildfly.plugins:wildfly-maven-plugin:2.1.0.Beta1:deploy

```bash
mvn clean install

cd ws3-swagger
mvn wildfly:deploy
``` 

Shows swagger configuration at:

```
http://127.0.0.1:8080/ws3/resources/swagger.json
```


