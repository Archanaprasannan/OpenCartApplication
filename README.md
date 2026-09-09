# 🛒 OpenCart Test Automation Framework

A UI test automation framework for the **OpenCart E-Commerce application**, built using **Java, Selenium WebDriver, and TestNG**.

The framework follows the **Page Object Model (POM)** and supports data-driven testing, multiple browsers, multiple environments, parallel execution, reporting, and Jenkins CI/CD integration.

## 🚀 Key Features

* Page Object Model (POM)
* Selenium WebDriver automation
* TestNG test execution and assertions
* Multi-browser testing — Chrome, Firefox, Edge
* Multi-environment support — QA, Dev, Stage, UAT
* Parallel test execution using `ThreadLocal<WebDriver>`
* Data-driven testing using Apache POI and TestNG DataProvider
* Reusable explicit wait utilities
* Automated failure screenshots
* Allure and ChainTest reporting
* Maven-based test execution
* Jenkins CI/CD integration

## 🛠️ Tech Stack

| Technology         | Purpose                       |
| ------------------ | ----------------------------- |
| Java               | Programming Language          |
| Selenium WebDriver | UI Automation                 |
| TestNG             | Test Execution & Assertions   |
| Maven              | Build & Dependency Management |
| Apache POI         | Excel Test Data               |
| Allure             | Test Reporting                |
| ChainTest          | HTML Reporting                |
| Jenkins            | CI/CD                         |
| Git & GitHub       | Source Control                |

## 📁 Project Structure

```text
OpenCartApplication/
│
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/qa/automation/opencart/
│   │           ├── basefactory/
│   │           ├── constants/
│   │           ├── error/
│   │           ├── exception/
│   │           ├── listener/
│   │           ├── pages/
│   │           └── utils/
│   │
│   └── test/
│       ├── java/
│       │   └── com/qa/automation/opencart/
│       │       ├── base/
│       │       └── test/
│       │
│       └── resources/
│           ├── config/
│           ├── testdata/
│           └── testrunners/
│
├── jenkinsfile
├── pom.xml
└── README.md
```

## 🧪 Test Coverage

The framework covers the following OpenCart modules:

* **Login**

  * Page validation
  * Valid login
  * Login page elements

* **Registration**

  * Registration page validation
  * User registration
  * Data-driven registration testing

* **Account**

  * Account page validation
  * Account navigation

* **Product Search**

  * Product search
  * Search result validation

* **Product Information**

  * Product details validation
  * Product image validation

* **Address Book**

  * Navigation
  * Page validation

## ⚙️ Configuration

Environment-specific settings are maintained in property files:

```text
src/test/resources/config/
├── qa.config.properties
├── dev.config.properties
├── stage.config.properties
└── uat.config.properties
```

Browser and environment can be provided at runtime.

Example:

```bash
mvn clean test -Denv=qa
```

## ▶️ Test Execution

### Run Sanity Tests

```bash
mvn clean test -Dsurefire.suiteXmlFiles=src/test/resources/testrunners/sanity.xml
```

### Run Regression Tests

```bash
mvn clean test -Dsurefire.suiteXmlFiles=src/test/resources/testrunners/testng_regression.xml
```

### Run Cross-Browser Tests

```bash
mvn clean test -Dsurefire.suiteXmlFiles=src/test/resources/testrunners/crossBrowserTesting.xml
```

### Run Tests in Different Environments

```bash
mvn clean test -Denv=qa
mvn clean test -Denv=dev
mvn clean test -Denv=stage
mvn clean test -Denv=uat
```

## 📊 Reporting

### Allure Report

The framework generates Allure reports containing:

* Test execution results
* Test steps
* Test severity
* Failure screenshots
* Test execution details

### ChainTest Report

ChainTest provides an interactive HTML report containing:

* Test results
* Execution time
* Failure details
* Screenshots

Reports are generated after test execution and can be viewed in a web browser.

## 🔄 Jenkins Integration

The framework includes a Jenkins pipeline for CI/CD execution.

The pipeline supports:

* Maven build
* Regression test execution
* Sanity test execution
* Environment-based execution
* Allure report publishing
* ChainTest report publishing

## 🔐 Best Practices

* Page Object Model for maintainable UI automation
* Reusable utility classes
* Explicit waits instead of hardcoded sleeps
* Thread-safe WebDriver management
* Externalized environment configuration
* Data-driven testing
* Automated failure screenshots
* Git-based source control

## 👩‍💻 Author

**Archana Prasannan**

QA Automation Engineer

**GitHub:** [Archanaprasannan/OpenCartApplication](https://github.com/Archanaprasannan/OpenCartApplication)

**Application Under Test:** [OpenCart Demo](https://naveenautomationlabs.com/opencart/)
