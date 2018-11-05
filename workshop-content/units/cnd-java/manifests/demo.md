# Manifests

## Goal
Add a manifest file to the sample app to prepare it for deployment to PCF.

## Prerequisites

+ IDE (Spring Tool Suite, Eclipse, IntelliJ)
+ Local Copy of Sample Project

## Navigate to the root directory

1. Navigate to the `starter-app`.

    `$ cd starter-app`

1. Create a new file `manifest.yml` in your editor of choice.

1. Create the following content in your `manifest.yml` file.

    ```
    applications:
        name: sample-app
        random-route: true
        memory: 1G
        instances: 1
        path: target/demo-0.0.1-SNAPSHOT.jar
    ```

1. Providing these deployment instructions tells PCF how to deploy your app.