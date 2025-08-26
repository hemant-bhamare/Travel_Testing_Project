# Travel Project - Automated Testing Framework

This is an automation testing project created using Selenium WebDriver and TestNG to test a travel site form at [phptravels.com/demo](https://phptravels.com/demo/).

## Project Overview
The project automates the testing of the travel site’s demo form by validating different combinations of input fields such as first name, last name, mobile number, business name, and email.
This includes both positive and negative test cases for comprehensive coverage.

## Technologies Used
- Java (JDK 1.8)
- Selenium WebDriver
- TestNG testing framework
- Maven for dependency management
- WebDriverManager for browser driver management
- Chrome and Edge browsers supported
- Page Object Model (POM) design pattern

## Project Structure
- `com.BaseTest`: Contains the base class for setup, browser initialization, and teardown.
- `com.PageObject`: Implements the Page Object Model classes representing pages and their elements.
- `com.TestClass`: Contains test classes using TestNG with data-driven testing via `@DataProvider`.
- `com.utility`: Utility classes like screenshot capture and test listeners.
- `ConfigurationFiles`: Property files such as browser and URL configuration.
- `Screenshotsv`: Folder where screenshots on test failure are saved.
- `testng.xml`: TestNG suite configuration file.

## How to Run Tests
1. Clone or download the repository.
2. Update `Config.properties` to select your preferred browser and URL.
3. Use Maven to build and run the TestNG test suite via Eclipse or command line.
4. Screenshots of failed test cases are stored in the `Screenshotsv` folder.

## Notes
- This is a work-in-progress project. some test cases and features are still under development.
- Error handling and reporting improvements are planned.
- Contributions and suggestions are welcome.

## Contact
Feel free to reach out for questions or collaboration:  
- LinkedIn: (http://www.linkedin.com/in/hemantbhamare073)  
- Email: hemantbhamare112@gmail.com

---

Thank you for reviewing my project!
