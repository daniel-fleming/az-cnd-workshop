# Going Cloud Native

## Goal
Checkout, build and run a sample application on your local machine.  Throughout the workshop we will build on this codebase to create a working cloud native application.

## Prerequisites

+ IDE (Spring Tool Suite, Eclipse, IntelliJ)
+ Java Runtime Installed
+ PostMan (Optional)

## Checkout the Source Code

1. Navigate to an empty project folder and clone the `starter-app` repository to your local machine.

    `$ git clone https://github.com/daniel-fleming/az-cnd-workshop.git`

1. Cloning the repository will download the workshop content as well.  Navigate to the `starter-app`.

    `$ cd starter-app`

1. Build the project and generate the Spring Boot jar file

    `$ mvn clean package`

1. Run the project on your local machine to ensure everything is working.

    `$ java -jar target/demo-0.0.1-SNAPSHOT.jar`

1. In PostMan (or browser), navigate to `http://localhost:8080/customers` and you should see a list of customers returned in `JSON` format.

    * Note: If you see an error, ensure that you are not using `https` in your FQDN.

1. We now have a working application!