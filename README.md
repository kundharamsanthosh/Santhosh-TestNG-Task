# HRMDemo

Simple Selenium-based automation demo using Java 17 and Maven. Contains tests using JUnit 5 and TestNG, and uses WebDriverManager to handle browser drivers.

## Requirements

1. Java 17 (set `JAVA_HOME` accordingly)
2. Maven 3.6+
3. A supported browser installed (Chrome, Edge, or Firefox)
4. Eclipse (optional) on Windows

## Project layout

1. Standard Maven layout: `src/main/java`, `src/test/java`
2. Project coordinates and dependencies are defined in `pom.xml`

## Build

1. Compile the project:

    mvn clean compile

2. Run all tests:

    mvn test

3. Run a single test class (replace `MyTest` with the class name):

    mvn -Dtest=MyTest test

## Running in Eclipse (Windows)

1. Import the project: File > Import > Maven > Existing Maven Projects
2. Right-click the project > Run As > Maven build...
3. Use `test` as the Goals to execute tests, or run individual test classes from the editor.

## WebDriver notes

1. WebDriverManager is included and will download browser drivers automatically at runtime.
2. Ensure the target browser is installed and up to date.
3. If you need a specific driver version or to run headless, configure your test code accordingly.

## Testing frameworks

1. JUnit 5 is available for standard unit/functional tests.
2. TestNG is included if preferred by some tests; configure the test runner as needed.

## Troubleshooting

1. If Maven complains about plugin placement, verify `pom.xml` plugin declarations and pluginManagement sections.
2. If browser driver issues occur, confirm network access for WebDriverManager to download drivers or configure local driver paths.

