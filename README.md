This suite uses TestNG as its default test runner. Java 8+ must be installed and added to the local Path variable.

In order to run the back-end suite, the Spring Boot application needs to be running locally.
For instructions on how to build the application in your local environment refer to
https://bitbucket.org/waesworks/backend-for-testers.git
# WAES technical test

This project contains only a few test scenarios that run against the static site https://waesworks.bitbucket.io

## Getting Started

To clone or download the project use https://github.com/MartinSorani/WAES.git as fetch remote.

### Prerequisites

In order to run the project you will need:

- Java 8+ installed and added to the local system environment.
- Maven 3+ installed and running on the local environment.
- Spring boot app (for instructions on how to run it, refer to https://bitbucket.org/waesworks/backend-for-testers.git)
- Google Chrome
- IntelliJ

### Installing

Clone the repository from https://github.com/MartinSorani/WAES.git

```
git clone https://github.com/MartinSorani/WAES.git
```
Open the project from IntelliJ

```
File > Open > Project Directory > {path-to-repo}waestechtest
```

## Running the tests

From the Project view navigate to
```
waestechtest/src/test/resources/runners
```
Right-click testng.xml

Click 'Run {path-to-file}testng.xml'

### Tests cases

Due to time constraints only a few basic tests have been included in order to test the core functionality of the static site, but the project is scalable and more scenarios can be added if needed.

Some tests rely on a data provider class that sources the necessary parameters in order to run the same scenario with different input.

The data provider class is specified inside the @Test annotation and more data can be added if necessary.

```
@Test(dataProvider = "usersDetails", dataProviderClass = DataProviderSource.class)
```

### Reporting

Every test run generates automatically an html report named index.html and can be accessed at the end of each run from:

```
src/test-output/html
```
Right-click the file and select 'Open in browser'.

Inside each test case you will find a detailed step-by-step description of the recently run scenario.

Since the back-end scenarios rely on a single request, no breakdown is needed for those cases.

## Built With

* [Selenium WebDriver](https://www.seleniumhq.org) - UI automated framework
* [Maven](https://maven.apache.org/) - Dependency Management
* [TestNG](https://testng.org) - Suite management
* [ReportNG](https://reportng.uncommons.org) - Report generation
* [REST Assured](http://rest-assured.io/) - Back-end tests creation

## Authors

* **Martin Sorani**
