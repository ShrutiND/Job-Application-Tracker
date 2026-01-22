# Job Application Tracker

This is a console-based Job Application Tracker built using **Core Java** and **MySQL**.

The main goal of this project is not just functionality, but to understand how application design and performance improve as requirements evolve.

---

## Features

- Add a job application  
- View all job applications  
- Update job status  
- Delete a job application  
- Search jobs by company name  

---

## Tech Stack Used

- Core Java  
- JDBC  
- MySQL  
- Java Collections Framework  

---

## Design and Optimization Journey

This project was developed step by step to understand how and why different data structures and storage mechanisms are used in real-world applications.

---

### Version 1: Using ArrayList (Basic In-Memory Storage)

Initially, job applications were stored in an `ArrayList`.  
This approach was simple and easy to implement, making it suitable for understanding the basic flow of the application.

**Limitations:**
- Duplicate job IDs could be added  
- Searching, updating, or deleting required iterating through the entire list  
- Time complexity for most operations was **O(n)**  

**Learning:**  
ArrayList is good for small data sets but does not scale well and does not prevent duplication.

---

### Version 2: Using Set (Avoiding Duplicate Entries)

To avoid duplicate job entries, the data structure was changed from `ArrayList` to `Set`.

**Improvements:**
- Duplicate job IDs were automatically prevented  

**Remaining Issues:**
- Searching and updating still required iteration  
- Direct access to a job by ID was not efficient  

**Learning:**  
Set helps maintain uniqueness but does not significantly improve search performance.

---

### Version 3: Using HashMap (Optimized In-Memory Access)

To improve performance, the design was further optimized using a `HashMap`.

- Job ID → Key  
- Job object → Value  

**Advantages:**
- Search, update, and delete operations worked in **O(1)** time  
- Cleaner and more efficient code  
- Direct access to job details using job ID  

**Learning:**  
HashMap is ideal when fast access by a unique identifier is required.

---

### Version 4: Using JDBC with MySQL (Persistent Storage)

Finally, in-memory storage was replaced with **MySQL using JDBC**, allowing job data to be stored permanently.

**Benefits:**
- Data persists even after application restart  
- Real-world database interaction using SQL  
- Better scalability and reliability  

**Learning:**  
Databases are essential for real applications where persistence and data integrity are required.

---

## Database Schema

**Table Name:** `job`

**Columns:**
- `job_id` – INT, Auto Increment, Primary Key  
- `company` – VARCHAR  
- `job_role` – VARCHAR  
- `job_status` – VARCHAR  

---

## How to Run the Project

1. Clone the repository  
2. Create the MySQL database and `job` table  
3. Update database credentials in `DBConnection.java`  
4. Run `Main.java`  
