# FitPeo Automation Script

## Prerequisites

1. Java Development Kit (JDK) installed.
2. Eclipse IDE or any other Java IDE installed.
3. Chrome browser installed.
4. ChromeDriver executable downloaded and path set in the script.

## Setup

1. Clone the repository or download the source code.
2. Open the project in your IDE.
3. Add Selenium WebDriver and Log4j dependencies to your `pom.xml`.

## Running the Script

1. Open the `FitPeoAutomation.java` file.
2. Set the path for `ChromeDriver` in the script.
3. Run the script.

## Notes

- Ensure the IDs used in the script (`slider-section-id`, `slider-id`, `text-field-id`, `reimbursement-header-id`) match the actual IDs of the elements on the web page.
- The script will open the FitPeo homepage, navigate to the revenue calculator page, adjust the slider, update the text field, select CPT codes, and validate the total recurring reimbursement value.

## Troubleshooting

- Ensure the ChromeDriver version matches your installed Chrome browser version.
- If elements are not found, verify the IDs and update them accordingly.
- Handle any exceptions and ensure the script runs smoothly.

