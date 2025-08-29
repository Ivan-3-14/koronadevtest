Java:
Java version: 11 

Build system:
Apache Maven
Maven version: 3.10.1

External libraries:
Lombok
Group: org.projectlombok
Artifact: lombok
Version: 1.18.10

Instructions for launching the project: 
1. Install Java
 Make sure Java 11 is installed on your computer or install it. You can check the installed version by running the command: 
 "java -version"

2. Install Maven
 Make sure Maven is installed or install it. You can check this with the command:
 "mvn -v"
  
3. Building the project
 Go to the root directory of the project and run the command to build:
 "mvn clean package"
 This command will create an executable JAR file with dependencies.
  
4. Running the application
 Once the build is successful, you can run the application using the following command:
 "java -jar target/sigmabank-1.0-SNAPSHOT-jar-with-dependencies.jar"
 
5. Checking the correct operation of the application
 To check whether the application's operation complies with the technical specifications, use the following commands:   
  - "java -jar target/sigmabank-1.0-SNAPSHOT-jar-with-dependencies.jar --sort=name --order=asc -–stat" 
  - "java -jar target/sigmabank-1.0-SNAPSHOT-jar-with-dependencies.jar -s=salary --order=desc --stat -o=file - -path=output/statistics.txt"
  - "java -jar target/sigmabank-1.0-SNAPSHOT-jar-with-dependencies.jar --stat"
 And compare the results with the expected values. 


