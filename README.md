# Playwright-Demoblaze  [![Playwright Tests](https://github.com/hala-samir/Playwright-Demoblaze/actions/workflows/playwright.yml/badge.svg)](https://github.com/hala-samir/Playwright-Demoblaze/actions/workflows/playwright.yml)
[![The scheduled run of the Playwright Tests](https://github.com/hala-samir/Playwright-Demoblaze/actions/workflows/sheduledRun.yml/badge.svg)](https://github.com/hala-samir/Playwright-Demoblaze/actions/workflows/sheduledRun.yml)
This project uses Playwright for end-to-end UI automation testing of the Demoblaze e-commerce website.
It is built using the Page Object Model (POM) design pattern, integrated with TestNG for test execution and Maven for dependency management.

## Technologies Used

- **Playwright:** A Node.js library for browser automation, supporting multiple browsers.
- **TestNG:** A testing framework for managing and executing test cases.
- **Java 17:** The programming language used for scripting.
- **Maven:** Build automation tool for dependency and lifecycle management.
- **Docker:** Containerization for isolated test execution.
- **GitHub Actions:** CI/CD integration for automated test execution.
- **ExtentReports:** For generating detailed HTML test report.
- **Faker:** Dynamic data generation for tests.

## Features

- **Playwright for Java:** Ensures reliable and scalable end-to-end UI testing.
- **Page Object Model (POM):** Modular design for reusable and maintainable test code.
- **Data-Driven Testing:** Dynamic test execution with parameterized data.
- **Faker Library:** Generates realistic, randomized test data like names, emails, and passwords to mimic real-world scenarios.
- **CI/CD Integration:**
    **GitHub Actions:** Automatically runs tests on pull requests and code pushes to main or master.
    **Slack Notifications:** Sends test execution results to a dedicated Slack channel.

## Prerequisites

Ensure you have the following installed:

- **Java Development Kit (JDK)** 17 or higher.

```
 java -version
```

- **Maven** (for dependency management).

```
 mvn -v
```

- **Docker** (Optional for containerized execution)
  Install Docker and Docker Compose for running tests in an isolated environment.

## Setup Instructions

Follow these steps to set up and run the project:

### 1. Clone the Repository

```bash
git clone https://github.com/hala-samir/Playwright-Demoblaze.git
cd Playwright-Demoblaze
```

### 2. Run Tests Locally

Build the project and execute tests:
```
mvn clean test
```

### 3. Run Tests in Docker
```
docker-compose up --build
```

### 4. View Test Reports

After test execution, reports are generated in the target/surefire-reports directory (TestNG Report).

To view ExtentReports, reports are generated in under ./reports.

## Project Structure

```
Playwright-Demoblaze/
├── .github/
│   ├── workflows/
│       └── playwright-tests.yml
├── src/
│   ├── main/
│   │   └── java/
│   │       └── pages/
│   ├── test/
│       └── java/
│           └── tests/
├── target/
│   └── surefire-reports/
├── Dockerfile
├── docker-compose.yml
├── pom.xml
├── README.md
└── .gitignore
```


##  Continuous Integration with GitHub Actions

* Tests are automatically executed on push and pull_request events for main and master branches. 
* Test results are sent to a Slack channel (#all-testingexecutionresult) via webhook integration.

## Test Reports

* HTML Reports: Generated using ExtentReports and available in the target directory after test execution.
* Surefire Reports: Located at target/surefire-reports for detailed logs.

## Key Advantages
* Flexible & Scalable: Thanks to POM and data-driven testing.
* Realistic Data: Ensures tests mimic real-world scenarios using the Faker library.
* Seamless CI/CD: Fully integrated with GitHub Actions and Slack for efficient workflows.

## Writing and Running Tests

1. **Test Location**:

   - All test classes are located in `src/test/java/tests`.
2. **Adding a New Test**:

   - Create a new test class under `tests`.
   - Use Playwright APIs to automate the desired flows.

Example Test Code:

```java
@Test
public void userCanSignUpSuccessfully(){
   homePage = new HomePage(page);
   homePage.clickSignUpBtn();
   homePage.fillUsernameAndPassword();
   homePage.clickSignUpPopupBtn();
}
```
