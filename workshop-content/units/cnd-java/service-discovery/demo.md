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

    `$ cf create-service p-service-registry standard service-discovery`

1. Navigate to `Apps Manager` and look in your space.  Your service discovery instance should show in the `Apps` list.  

    * It may take a few minutes for your service instance to be created.  

1. Once the status shows as `Running` click the route and navigate to your service discovery instance in the browser.

## Navigate to the root directory

1. Navigate to the `starter-app`.

    `$ cd starter-app`

1. Open the `application.yml` in `src/main/resources` with your editor.

1. Add the following line to the `application.yml` file:

    ```
    spring:
      application:
        name: starter-app

    eureka:
      client:
      registerWithEureka: true
      fetchRegistry: true
      serviceUrl:
        defaultZone: https://localhost:8761/eureka/
    instance:
      hostname: ${vcap.application.uris[0]}
      metadata-map:
        management:
          port: 80
      non-secure-port: 80
      secure-port: 443
      status-page-url: http://${vcap.application.uris[0]}/actuator/info
      health-check-url: http://${vcap.application.uris[0]}/actuator/health
    ```
    
1. Open `manifest.yml` in your editor of choice.

1. Add the service binding to your newly created eureka instance.

    ```
    applications:
        name: sample-app
        random-route: true
        memory: 1G
        instances: 1
        path: target/demo-0.0.1-SNAPSHOT.jar
        services:
          - service-discovery
    ```

1. When you deploy your app to PCF it will automatically register with your Eureka Discovery service.

