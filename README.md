# Question-Paper-Generator-System

This application can be use by Subject teacher or Exam moderator for setting up question papaer for online or offline exams
 - Teacher can add the questions with different category, complexity.
 - Based on the added questions; Exam question paper can be generated by shuffling questions randomly with the provided criteria.

## Core Technologies Used
- BackEnd  : Java, Servlet, JSP, JSTL, Tomcat.
- FrontEnd : HTML, CSS, Bootstrap, Javascript
- Database : Mysql

## Features

- User Interface : 

	+ User can View Questions
	+ Sort Questions by category,
	+ Sort Quetions by complexity.
	+ User can add, update and delete question.
	+ User can generate question set from set of differnet Questions.


## Pre-requisites
* Eclipse
* Java 8
* Tomcat 9+

## How to Run on local

* Download and install eclipse : Quickly and easily develop desktop, mobile and web applications
with Java,JavaScript, HTML5, PHP, C/C++ and more.ecipseIDE is FREE, open source, and has a worldwide community of users and developers. 

* Select tomcat server 
- Install MySQL (On Ubuntu)

   ```
   sudo apt-get install mysql-server
   ```

+ Start/Stop Mysql server 
	
  ```
  sudo service mysql start
  sudo service mysql stop
  ```

+ To log in to MySQL as the root user:
	
  ```
  mysql -u root -p
  ```

  + Create a New MySQL User and Database
  + Create database by executing [questionPaperGenerator.sql](./questionPaperGenerator.sql) 
    
+ In the code configuration adjust the below propetries variable 
    ```
     String url = "jdbc:mysql://localhost:3306/questionPaperGeneratorDb";
     String user = "root";
     String pass = "root";
    ```

- In eclipse Right click on Project Question Paper Generator System & select deploy to run the project
