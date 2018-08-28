# Text search engine

## Introduction 
Command line driven search engine project using all the text files available in a given directory.
The search takes the words given on the command prompt and returns a list of the top 10 (max) matching filenames in rank order, giving the rank score against each match.
The rank score is 100% if a file contains all the words, 0% if it contains none of the words and between 0% and 100% if it contains only some of the words. 

## Getting Started
The solution is a single-thread Java application that consists of the following elements:
The *Main* class with the *main* method serves as entry point to the application, checking that the input parameter (folder with text files) is given and is not empty.
The methods *checkFiles* and *findMatchLevel* in the *Main* class, evaluate the searched words and assign a match level percentage to each file.
The *FileMatchLevel* class with the *compareTo* method sort each file by the match in descending order. The class *MainTest* with the methods *test1*, *test2* and *test3* evaluate the performance of the project.

## Build and run the project

### Generate jar from the command console 
Open a command console, navigate to the location of the pom.xml file and execute the command:
```
mvn install
```
The jar file will be generated in the *target* folder.

### Run the program from the command console:
It is assumed that Java is installed and the JAVA_HOME environment variable is defined to launch the jar from the command console. To run the program, you need to open a console and navigate to the *target* folder where the jar file is located and write the following command:
```
java -jar  searcher-1.0.jar <files path>
```
With the parameter indicating the directory with the text files.  

## Tests
There is a folder with 15 files with Lorem Ipsum (filler text) to run tests. To use this folder navigate with a console to the *target* folder with the jar and execute the command:
```
java -jar searcher-1.0.jar ../src/main/resources
```
There are 3 tests available using the *testingFile_1.txt* file (existing text, no-existing text and percentage of coincidence). To run the tests, navigate to the root project directory and execute the command:
```
mvn test
```

## Author
* **Juan Salichs San José**