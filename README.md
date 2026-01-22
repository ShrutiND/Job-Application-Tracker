# Job-Application-Tracker

This is a console-based Job Application Tracker built using Core Java and MySQL.
The main goal of this project is not just functionality, but to understand how application design and performance improve as requirements evolve.

* Features :
1.Add a job application
2.View all job applications
3.Update job status
4.Delete a job application
5.Search jobs by company name

* Tech Stack Used:
1.Core Java
2.JDBC
3.MySQL
4.Java Collections Framework

* Design and Optimization Journey:
                                 This project was developed step by step to understand how and why different data structures and storage mechanisms are used in real-world applications.

** Version 1: Using ArrayList (Basic In-Memory Storage)
           Initially, job applications were stored in an ArrayList. This approach was simple and easy to implement, which made it suitable for understanding the basic flow of the application.
           However, this approach had limitations:
                                                 Duplicate job IDs could be added. Searching, updating, or deleting a job required iterating through the entire list.
                                                 Time complexity for most operations was O(n).
Learning:
ArrayList is good for small data sets but does not scale well and does not prevent duplication.

** Version 2: Using Set (Avoiding Duplicate Entries)
              To avoid duplicate job entries, the data structure was changed from ArrayList to Set. This ensured that duplicate job IDs were not allowed.
              However, some issues still remained:
                                                 Although duplicates were prevented, searching and updating still required iteration. Direct access to a job by ID was not efficient.

Learning: 
Set helps maintain uniqueness but does not significantly improve search performance.

** Version 3: Using HashMap (Optimized In-Memory Access)
              To improve performance, the design was further optimized using a HashMap.
              The job ID was used as the key and the Job object as the value.

Advantages of this approach:
                            Search, update, and delete operations worked in O(1) time.
                            Code became cleaner and more efficient.
                            Direct access to job details using job ID.
Learning:
HashMap is ideal when fast access by a unique identifier is required.

** Version 4: Using JDBC with MySQL (Persistent Storage)
              Finally, in-memory storage was replaced with MySQL using JDBC.
              This allowed job data to be stored permanently in a database.

Benefits of this approach:
                          Data persists even after application restart.
                          Real-world database interaction using SQL.
                          Better scalability and reliability.
Learning:
Databases are essential for real applications where persistence and data integrity are required.

** Database Schema :  Table Name: job
                      Columns: job_id (INT, Auto Increment, Primary Key)
                               company (VARCHAR)
                               job_role (VARCHAR)
                               job_status (VARCHAR)

* How to Run the Project ?
-> Clone the repository
-> Create the MySQL database and job table
-> Update database credentials in DBConnection.java
-> Run Main.java
