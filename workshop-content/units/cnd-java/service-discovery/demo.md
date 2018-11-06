# Manifests

## Goal
Add service discovery to the sample app.

## Prerequisites

+ IDE (Spring Tool Suite, Eclipse, IntelliJ)
+ Local Copy of Sample Project

## Create the Eureka Service Instance

1. From the command line print a list of services in the marketplace.

    `$ cf marketplace`

1. You should see a plan called `p-service-registry`.

1. From the command line type:

    `$ cf create-service p-service-registry trial <YOUR-SERVICE-DISCOVERY-NAME>`

1. Navigate to `Apps Manager` and look in your space.  Your service discovery instance should show in the `Services` tab.  

    * It may take a few minutes for your service instance to be created.  

1. Once the status shows as `Running` click on the service name.  Click the `Manage` link to open the GUI in a new browser window.

## Setup the Service Discovery Client

1. Navigate to the `starter-app`.

    `$ cd starter-app`

1. Open `DemoApplication.java` in your editor or IDE.

1. Add the `@EnableDiscoveryClient` annotation.

    ```
    @SpringBootApplication
    @EnableDiscoveryClient
    public class DemoApplication {
        ...
    ```
    
1. Open `manifest.yml` in your editor of choice.

1. Add the service binding to your newly created eureka instance.

    ```
    applications:
    -   name: sample-app
        random-route: true
        memory: 1G
        instances: 1
        path: target/demo-0.0.1-SNAPSHOT.jar
        services:
          - svc-discovery
    ```

1. Open `pom.xml` file in your editor.  Add the following dependency:

    ```
    <dependency>
		<groupId>io.pivotal.spring.cloud</groupId>
		<artifactId>spring-cloud-services-starter-service-registry</artifactId>
        <version>2.0.2.RELEASE</version>
	</dependency>
    ```

1. Build the app using the following command:

    `$ mvn clean package -DskipTests`

1. When you deploy your app to PCF it will automatically register with your Eureka Discovery service.

