# Playwright-Demoblaze

This repository demonstrates the use of **Playwright** for automating tests on the [Demoblaze](https://www.demoblaze.com/) web application.
It includes automation scripts written in Java, showcasing Playwright's capabilities for modern web automation testing.

## Features

- Automated test cases for the **Demoblaze** e-commerce platform.
- **Playwright** integration with Java for browser-based testing.
- Modular and reusable test structure.
- Cross-browser testing support (Chromium, Firefox, and WebKit).

## Prerequisites

Ensure you have the following installed:

- **Java Development Kit (JDK)** 17 or higher.
- **Maven** (for dependency management).
- **Node.js** (to install Playwright browsers).

## Setup Instructions

Follow these steps to set up and run the project:

### 1. Clone the Repository

```bash
git clone https://github.com/hala-samir/Playwright-Demoblaze.git
cd Playwright-Demoblaze
```

### 2. Install Playwright Browsers

Run the following command to install the required Playwright browsers:

```bash
npx playwright install
```

### 3. Import the Project in an IDE

- Open your preferred Java IDE (e.g., IntelliJ IDEA or Eclipse).
- Import the project as a **Maven Project**.

### 4. Run the Tests

Use Maven to execute the test cases:

```bash
mvn test
```

Alternatively, you can run individual test classes or methods directly from your IDE.

## Project Structure

```
Playwright-Demoblaze
├── src
│   ├── main
│   │   ├── java
│   │   │   └── [application-specific code]
│   └── test
│       ├── java
│       │   ├── tests
│       │   │   └── [test classes]
│       │   └── utils
│       │       └── [helper methods and utilities]
├── pom.xml
└── README.md
```

- **`src/main/java`**: Contains application-specific code (if any).
- **`src/test/java`**: Contains test cases and utilities.
- **`pom.xml`**: Maven configuration file for managing dependencies.

## Key Dependencies

The project uses the following dependencies:

- **Playwright for Java**: Web automation framework.
- **TestNG/JUnit**: Test framework (choose based on the implementation).
- Additional dependencies can be found in the `pom.xml` file.

## Playwright Features Used

- Browser and context management.
- Handling dynamic elements and asynchronous events.
- Cross-browser testing (Chromium, Firefox, WebKit).
- Emulating devices for responsive testing (optional).

## Writing and Running Tests

1. **Test Location**:
    - All test classes are located in `src/test/java/tests`.

2. **Adding a New Test**:
    - Create a new test class under `tests`.
    - Use Playwright APIs to automate the desired flows.

Example Test Code:

```java
@Test
public void verifyHomePageLoadsSuccessfully() {
    Page page = browser.newPage();
    page.navigate("https://www.demoblaze.com");
    Assert.assertTrue(page.title().contains("STORE"));
    page.close();
}
```

3. **Running Tests**:
    - Use `mvn test` to execute all tests.
    - Use IDE options to run specific test methods or classes.
