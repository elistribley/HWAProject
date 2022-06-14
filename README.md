# HWA Project  - Eli Stribley

For my second project for QA training course I had to create an entity within MySQL using Java for creation and setting purposes and using HTML to statically serve up information and show our skills using HTML, CSS and JS in order to combine the two.

## Getting Started
Fitst of all you will need GitBash and an IDE, I used Visual Studio Code. If you would like to create an empty folder on your desktop, right click inside and click GitBash, this will open up a terminal and you can enter the following commands:

git init <br/>
git clone https://github.com/elistribley/HWAProject <br/>
code .

This will initialise the folder into a repo, clone down my project and open up all code inside. All my code has been put into a fatJar so you want would like to alternatively do that.

## Prerequisites
You will need SQL Workbench to visualise the information in my sql-schema and sql-data files which are located within the project inside src/main/resources. You can open up the code in any IDE but with require maven for testing purposes and GitBash for any commands you wish to access.
Building
In order to build my code, you will be able to enter the HWAProject Eli Stribley, and open a GitBash terminal within that file. Type in "mvn clean package" to build a new fatjar. Then run with the commands "java -jar ims-0.0.1-jar-with-dependencies".(you can copy and paste the quoted command, This will open my java executable in a console for you to interact with. 

## Running the tests
For test purposes you can open the code in whatever your preffered IDE in a find where src/test/java is, then you can right click, run as JUNIT Test and this will run all the tests, if you wish to find coverage for the project, simply instead of run as you hover over coverage as and that will show you how much of my code is covered by tests.

## Unit and Integration Tests
There are unit tests for my controller and services classes, plus further integration tests in my controllerTests class.

## Built With
Maven - Dependency and Build Management
Github - Repository management and integration with Jira for automatic Jira update
Mockito - Mocking dependencies for unit testing
Jira - Kanban board and epic/stories visualisation
MySQLWorkbench and Server
Git - Gitbash functionality for command line interface
Junit - Testing
## Authors
Eli Stribley
## License
This project is licensed under the MIT license - see the LICENSE.md file for details

## Acknowledgments
---Anoush---

## Jira Board link
https://hwaelistribley.atlassian.net/jira/software/projects/EL/boards/1
qa@gmail.com has access.

Thank you!
