#Problem Statement

Create a tinyurl like service, where user can shorten URLs.

### Requirements
* User will input a URL, and will receive a shrunk URL for the same.
* On inputting the short url the user will be redirected to the original page.


##Project Setup
* Make sure to have Java Version >= *1.8*
* Project comes with maven wrapper
* Clone the github repo
* From the repo directory run the following commands:
    * ``` mvn clean install ``` : This will clean and compile the source code.
    * ``` java -jar {project-root}/target/url-shortener-0.0.1-SNAPSHOT.jar``` : This will run the jar on port 8080
* You can now consume the API
* Please find API docs [here](documentation/README.md)