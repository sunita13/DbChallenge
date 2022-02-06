# DB Coding Challenge test automation using Selenium Webdriver with Java, JUnit and Maven

## Prerequisites

* Have [java](http://www.oracle.com/technetwork/java/javase/downloads/index.html) installed
* Have [maven](http://maven.apache.org/) installed
* check chromedriver version in folder /src/main/java/resources. Make sure it is compatible with the chrome browser of your system.

## Installation
### Clone

- Clone this repository to your local machine using the command below:
```
	$ git clone https://github.com/sunita13/DbChallenge
```

---

### Execution

> Access project root

```
	$ cd ../DBCodingChallenge
```
> Execute the command to run all tests in the project

```
	$ mvn clean test
```
> Execute the command to run only one test class in the project

```
	$ mvn clean test -Dtest=<testname>
```

---
## Technologies:
- Selenium WebDriver
- Java
- Maven