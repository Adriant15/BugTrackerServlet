# Bug Tracker

Simple servlet app created with Java, HMTL, CSS, JavaScript, Tomcat and MySQL.

## Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [Setup](#setup)

## General info
This project is a simple bug tracking servlet app that lists, adds, modifies and delete bug entries. The servlet runs on Tomcat server that communicates with MySQL database. 
	
## Technologies
Project is created with:

* Eclipse 4.17.0
* Java 8
* HTML 5
* CSS
* Javascript 1.5
* Apache Tomcat 9.0
* MySQL 8.0
* MySQL Workbench 8.0.21
* MySQL Connector Java 8.0.22
* JavaServer Pages(TM) Standard Tag Library API 1.2.1
	
## Setup
To set up this project on Windows, perform the following steps:

1. Create the sample database on MySQL running the SQL script bug-tracker.sql. 
2. Configure SQL connection to use localhost port 3306.
3. Configure user name and password to "root". If a different credential is desired, context.xml inside project will need to be edited.

To run servlet without Eclipse:

1.	Copy the project folder into the webapps directory under Tomcat folder in your computer's program files. 
2.	Open a browser and write http://localhost:8080/Bug_Tracker/BugTrackerController.

To run servlet in Eclipse:

1.	Install Eclipse 4.17.0 or higher.
1.	Open project within Eclipse.
2.	In Eclipse, navigate to Windows -> Preferences -> Server -> Runtim Environments.
3.	Click on the "Add" button to add Tomcat v9.0 server.
4.	Click on browse and select directory where Tomcat was installed and click finish.
6.	In the package explorer in Eclipse, navigate to Bug Tracker -> src -> com.ato.web.controller, right click on BugTrackerController.java, run as, and run on server. Note: some HTML feature such as the date selector may not work on the browser, in which case copy the URL link and run in dedicate web browser.

## Servlet Features

* List entries in bug tracker SQL database and populate HTML table with each bug's information.
* User can add a new bug specifying title, issue description, name of reporter, due date, level of severity. Created date is automatically selected to current date and status of the bug is automatically set to be open.
* Each entry will have two additional options to delete the bug or modify it.
* In the modify menu of a entry, the form is prefilled with information of said entry. User can edit and save any changes made.

## OOP Feature

The strategy design pattern was used to define the different algorithms used to interact with the SQL database, encapsulating one, and making them interchangeable. 

The client application can pass the algorithm to be used, an instance of a concrete strategy class, as a parameter. 

In the bug track project, a context class (SqlCommand) is created with a method execute() that takes an instance of interface type SqlQuery. Inside execute(), an implementing class of interface SqlQuery is also called to run its implementation of execute(). 

Each function to interface with database and updating the HTML pages are defined in a separate class that implements SqlQuery interface and execute(). These are the concrete strategy classes. 

During runtime, a new instance of SqlCommand is created with the parameter being an instance of whichever concrete strategy class is required (polymorphism). 

Advantages:

1.	By encapsulating algorithm separately, new algorithm complying with same interface can easily be added.
2.	Simplifies unit testing because each algorithm is in its own class and can be tested through its interface.
3.	Can test code without worrying about interactions caused by coupling.

## Source

This app is inspired by tutorial Chad Darby "JSP, Servlets and JDBC for Beginners: Build a Database App" 
