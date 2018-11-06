# Manifests

## Goal
Add external config to the sample app.

## Prerequisites

+ IDE (Spring Tool Suite, Eclipse, IntelliJ)
+ Local Copy of Sample Project

## Create the Config Server Instance

1. From the command line print a list of services in the marketplace.

    `$ cf marketplace`

1. You should see a plan called `p-config-server`.

1. From the command line type:

    `$ cf create-service p-service-registry trial <YOUR-CONFIG-SERVER-NAME>`

1. Navigate to `Apps Manager` and look in your space.  Your config server instance should show in the `Services` tab.  

    * It may take a few minutes for your service instance to be created.  

1. Once the status shows as `Running` click on the service name.  Click the `Manage` link to open the GUI in a new browser window.

1. Go back to `Apps Manager` and select the `Settings` tab.

1. In the `Configure Instance` select the `Enter JSON` slider and enter the following content:
    ```
    {
        "git": { "uri": "http://<YOUR-GIT-CONFIG-PATH>" },
        "searchPaths": "config",
        "username": "<YOUR-USERNAME>",
        "password": "<YOUR-PASSWORD>"
    }
    ```

1. Click the `Update` button to save your changes.

## Setup the Config Client

1. Navigate to the `starter-app`.

    `$ cd starter-app`

1. Create a new properties file for you app.  Make sure that your file name matches your Spring application name:

    `sample-app-dev.properties`

1. Add a value to the file:

    `message=configServer`

1. Commit your properties file to your Git repository in the `/config` directory.

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
          - config-server
    ```

1. Open `pom.xml` in your browser and add the following dependency:

    ```
    <dependency>
    	<groupId>org.springframework.cloud</groupId>
    	<artifactId>spring-cloud-starter-config</artifactId>
    	<version>2.0.2.RELEASE</version>
	</dependency>
    ```

1. Build the app using the following command:

    `$ mvn clean package -DskipTests`

1. When you deploy your app to PCF it will automatically register with your Eureka Discovery service.

1. Run the following command to view your config server variable:

    `$ curl https://<YOUR-APP-URL>/which-env`

1. You should see the value `dev` returned.

