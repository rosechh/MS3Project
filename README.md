# MS3Project
TO RUN THIS PROJECT: 
We need  to add SQLite-JDBC jar file -

You will need a SQLite-JDBC jar file which can be found from below link. To add this JAR file in your project follow below steps :

https://bitbucket.org/xerial/sqlite-jdbc/downloads/

Right Click on your project
Go to 'Build Path'
Go to 'Configure Build Path'
Go to 'Libraries' tab
Click on 'Add External JARs'
Select JAR file you downloaded and click apply.

PROJECT DESCRIPTION: 
A customer needs a JAVA Application to churn out a small application. For that we need the following things:
- Consume a CSV file, parse data and insert valid records into a SQLDatabase.
- Each record needs to be verified to contain the right number of data elements to match the columns
- Records that do not match the column count must be written to the bad-data-.CSV file
- Elements with commas will be double quoted

At the end of the process write statistics to a log file:
a. # of records received

b. # of records successful

c. # of records failed

Rules and guidelines:

Feel free to use any online resources

Utilizing existing tools like Maven and open source libraries is encouraged.

A finished solution is great but if you do not get it all completed, that is ok - we will evaluate based on the approach

It is required that you provide a README detailing the challenge
