# Text search engine

## Introduction 
Command line driven text search engine project to read all the text files in the given directory. The search take the words given on the command prompt and return a list of the top 10 (max) matching filenames in rank order, giving the rank score against each match.
The rank score is 100% if a file contains all the words, 0% if it contains none of the words and between 0% and 100% if it contains only some of the words. 

## Getting Started
The solution is a single-thread Java application that consists of the following elements. Main class serves as entry point to the application and checks that the input parameter (folder with text files) is given and is not empty.

## Build and run the project

### Generate jar from the command console: 
Open a command console and navigate to the location of the pom.xml file and execute the command:
```
mvn install
```
The jar file will be generated at the "target" folder.

### Run the program from the command console:
To launch the jar from the command console, it is assumed that Java is installed and the JAVA_HOME environment variable is defined. To run the program, you need to open a console and navigate to the folder where the jar file is located and write the following command:
```
java -jar  searcher-1.0.jar <files path>
```
Where <files path> is the parameter indicating the directory with the text files.  

## Tests
There is a folder with 15 files with Lorem Ipsum (filler text) to run tests. To use this folder navigate with a console to the folder containing the jar and write the command:
```
java -jar searcher-1.0.jar ../src/main/resources
```
To run the 3 unitary tests available with Eclipse, navigate to the /src/test/java/search folder with the Package Explorer and right-click on the MainTest.java file. After select the "Run As" option and "JUnit Test".

## Author
* **Juan Salichs San José**