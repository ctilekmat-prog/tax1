Tax Filing System
Project Title

Tax Filing System

Student

Group:COMFCI25

Name: Chekirov Tilekmat

Description

The Tax Filing System is a Java application that allows users to manage tax records for individuals and businesses.
The system supports tax calculation, record management, and file-based data storage.

It includes both a console-based interface and a graphical user interface (GUI) built with Swing.

Objectives
Develop a tax management system using Java
Apply Object-Oriented Programming (OOP) concepts
Implement CRUD operations (Create, Read, Update, Delete)
Calculate taxes based on taxpayer type
Store and load data from files
Build a user-friendly GUI using Swing
Features
Add a new tax record
View all tax records
Update record status (e.g., Pending → Paid)
Delete records by ID
Automatic tax calculation:
Individual → 10%
Business → 20%
Save records to file (data.txt)
Load records from file
GUI interface (Swing)
Console version (for testing and backup)
Project Structure
Main.java – Console-based entry point
TaxGUI.java – Graphical user interface (Swing)
TaxPayer.java – Abstract class for taxpayers
IndividualTaxPayer.java – Individual tax calculation
BusinessTaxPayer.java – Business tax calculation
TaxRecord.java – Model class (represents a tax record)
TaxManager.java – Handles business logic (CRUD)
FileManager.java – Manages file operations
OOP Principles Used
Encapsulation

Fields in TaxRecord are private and accessed via methods.

Inheritance

IndividualTaxPayer and BusinessTaxPayer extend TaxPayer.

Polymorphism

The calculateTax() method is overridden for different taxpayer types.

Abstraction

TaxPayer is an abstract class defining tax calculation behavior.

Data Persistence

All records are stored in a file:

data.txt

Data is saved manually or automatically
Data is loaded when requested
Format:
id,name,income,tax,status
How to Run
Open the project in IntelliJ IDEA
Make sure JDK 17 or higher is installed
Run one of the following:
Main.java for console version
TaxGUI.java for GUI version
Use the menu or buttons to manage records
Test Cases
Add Record

Input:

Name: John Doe
Income: 5000
Type: Individual

Expected result:

Tax = 500 (10%)
Record added successfully
Invalid Input

Input:

Income: text instead of number

Expected result:

Error handled
Program does not crash
Delete Record

Input:

ID: 1

Expected result:

Record is removed from system
Update Status

Input:

ID: 1
Status: Paid

Expected result:

Status updated successfully
Notes
Uses Java Swing for GUI
Data is stored locally (no database required)
Designed for learning OOP and Java fundamentals
Supports both GUI and console interaction
