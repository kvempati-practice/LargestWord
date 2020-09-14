# Find Largest word and its transpose from a file

## Task
 - Read input from a file of words
 - Find the largest word in the file
 - Transpose the letters in the largest word
 - Show the largest word and the largest word transposed
 - Demonstrate positive and negative test cases

## File Organization

#### LargestWord.java
This file will have implimentation of finding largest word and it's transposed words from a file
Assumptions:
- Each word is separated by space or newline
- Only keeps the first occurance of the largest word
- Returns null if the file does not have any word
- Expect caller to catch the exceptions

#### LargetWordTestCases.java
This file will have all the positive and negative test cases

#### TestRunner.java
This file will have nesssary support to run the testcases from the above file using junit test framewordk

#### test-data
This folder consists of test data files. **Please do not modify**

## Test Cases
Here is the summary of the test cases. You can find the implimetantion of all these test cases in LargetWordTestCases.java

- **_01_emptyFileTest:** Test case to validate handling of null as file name
- **_02_fileNotFoundTest:** Test case to validate handling of non existing file
- **_03_fileIsADirectoryTest:** Test case to validate handling directory as a file
- **_04_emptyContentFileTest:**  Test case to validate handling of empty file content. Expect null as a largest word
- **_05_largestWordSuccesTest:** Test case to validate the positive scenario to find the largest word with its first occurance
- **_06_largestWortLastOccranceTest:** Test case to validate the negative scenario to find the largest word with its last occurance
- **_07_largestWordAndTransposeSuccessTest:** Test case to validate the positive scenario for finding the largest word and the transpose of that largest word
- **_08_transposeLargestWordSuccessTest:** Test case to validate the positive scenario for finding the largest word and the transpose of that largest word
- **_09_transposeOfTransposeTest:** Test case to validate the transpose of the transpose word
- **_10_largestWordAndTransposeEmptyTest:** Test case to validate the negative scenario to find the largest word and its transpose using an empty file
- **_11_binaryDataTest:** est case to validate the negative scenario if the given input file is binary file

## Build and Run test cases
Please follow the below instructions to build and run testcases
- Getup your java environment
- Download junit and hamcrest jar files
- Set ClassPath
- Build
- Run

### Setup java environment
Please setup java environment

#### My example setup
```
C:\Users\veniv\secureworks\CodeChallenge>java -version
java version "14.0.1" 2020-04-14
Java(TM) SE Runtime Environment (build 14.0.1+7)
Java HotSpot(TM) 64-Bit Server VM (build 14.0.1+7, mixed mode, sharing)

C:\Users\veniv\secureworks\CodeChallenge>javac -version
javac 14.0.1

C:\Users\veniv\secureworks\CodeChallenge>java -XshowSettings:properties -version
Property settings:
    file.encoding = Cp1252
    file.separator = \
    java.class.path = %CLASSPATH%
        C:\JUNIT\hamcrest-core-1.3.jar
        C:\JUNIT\junit-4.13.jar
        .
    java.class.version = 58.0
    java.home = C:\Program Files\Java\jdk-14.0.1
    java.io.tmpdir = C:\Users\veniv\AppData\Local\Temp\
    java.library.path = C:\Program Files\Java\jdk-14.0.1\bin
```

### Download jar files
To build this module, please download junit.jar and hamcrest-core.jar from the below link
https://github.com/junit-team/junit4/wiki/Download-and-Install
https://search.maven.org/search?q=g:junit%20AND%20a:junit
https://search.maven.org/artifact/org.hamcrest/hamcrest-core/1.3/jar

And place these files to some specified location like C:\JUNIT folder

### Add to Class Path
Add these jar files to CLASSPATH.
Here is the example from my windows-10
```
%CLASSPATH%;C:\JUNIT\hamcrest-core-1.3.jar;C:\JUNIT\junit-4.13.jar;.
```

## Build
1. Go to the toplevel directory
2. Issue the following command

```
javac LargestWord.java LargestWordTestCases.java TestRunner.java
```
Note: You can ignore warnings

## Run tests
Issue the followin command to run tests
```
java TestRunner
```

## My example
### Build
```
C:\Users\veniv\secureworks\CodeChallenge>javac LargestWord.java LargestWordTestCases.java TestRunner.java
Note: LargestWordTestCases.java uses or overrides a deprecated API.
Note: Recompile with -Xlint:deprecation for details.
```
### Run
```
C:\Users\veniv\secureworks\CodeChallenge>javac LargestWord.java LargestWordTestCases.java TestRunner.java

C:\Users\veniv\secureworks\CodeChallenge>java TestRunner
Running Junit Test Suite to validate LagestWord module.
Number of tests to execute: 11

Starting >>> : **_03_fileIsADirectoryTest
Finished <<< : **_03_fileIsADirectoryTest
Starting >>> : **_04_emptyContentFileTest
Finished <<< : **_04_emptyContentFileTest
Starting >>> : _10_largestWordAndTransposeEmptyTest
Finished <<< : _10_largestWordAndTransposeEmptyTest
Starting >>> : **_02_fileNotFoundTest
Finished <<< : **_02_fileNotFoundTest
Starting >>> : **_07_largestWordAndTransposeSuccessTest
Finished <<< : **_07_largestWordAndTransposeSuccessTest
Starting >>> : _11_binaryDataTest
Finished <<< : _11_binaryDataTest
Starting >>> : **_09_transposeOfTransposeTest
Finished <<< : **_09_transposeOfTransposeTest
Starting >>> : **_06_largestWortLastOccranceTest
Finished <<< : **_06_largestWortLastOccranceTest
Starting >>> : **_05_largestWordSuccesTest
Finished <<< : **_05_largestWordSuccesTest
Starting >>> : **_08_transposeLargestWordSuccessTest
Finished <<< : **_08_transposeLargestWordSuccessTest
Starting >>> : **_01_emptyFileTest
Finished <<< : **_01_emptyFileTest

Number of tests executed: 11

Final Test Result:true

C:\Users\veniv\secureworks\CodeChallenge>
```
