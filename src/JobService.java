import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class JobService {

    /*import java.util.ArrayList;

public class JobService {

    private ArrayList<job> jobs = new ArrayList<>();
    private int nextJobId = 1;   // auto-increment job_id

    // ADD JOB
    public void addJob(String company, String role, String status) {
        job newJob = new job(nextJobId, company, role, status);
        jobs.add(newJob);
        nextJobId++;
        System.out.println("Job added successfully!");
    }

    // VIEW ALL JOBS
    public void viewJobs() {
        if (jobs.isEmpty()) {
            System.out.println("No jobs found.");
            return;
        }

        for (job j : jobs) {
            System.out.println(j);
            System.out.println("---------------------");
        }
    }

    // UPDATE JOB STATUS
    public void updateJobStatus(int jobId, String newStatus) {
        for (job j : jobs) {
            if (j.getJob_id() == jobId) {
                j.setJob_status(newStatus);
                System.out.println("Status updated!");
                return;
            }
        }
        System.out.println("Job not found.");
    }

    // DELETE JOB
    public void deleteJob(int jobId) {
        for (job j : jobs) {
            if (j.getJob_id() == jobId) {
                jobs.remove(j);
                System.out.println("Job deleted!");
                return;
            }
        }
        System.out.println("Job not found.");
    }

    // SEARCH BY COMPANY
    public void searchByCompany(String companyName) {
        boolean found = false;

        for (job j : jobs) {
            if (j.getcompany().equalsIgnoreCase(companyName)) {
                System.out.println(j);
                System.out.println("-----------------");
                found = true;
            }
        }

        if (!found) {
            System.out.println("No jobs found for this company.");
        }
    }
}

     */

    /*
    used set to avoid duplication , hashset used

       private Set<job> jobs = new HashSet<>();
    private int nextJobId = 1;

    // ADD JOB (no duplicates allowed)
    public void addJob(String company, String role, String status) {

        job newJob = new job(nextJobId, company, role, status);

        if (jobs.add(newJob)) {   // add() returns false if duplicate
            System.out.println("Job added successfully!");
            nextJobId++;
        } else {
            System.out.println("Duplicate job_id detected. Job not added.");
        }
    }

    // VIEW JOBS
    public void viewJobs() {
        if (jobs.isEmpty()) {
            System.out.println("No jobs found.");
            return;
        }
        for (job j : jobs) {
            System.out.println(j);
            System.out.println("------------------");
        }
    }

    // UPDATE JOB STATUS
    public void updateJobStatus(int jobId, String newStatus) {
        for (job j : jobs) {
            if (j.getJob_id() == jobId) {
                j.setJob_status(newStatus);
                System.out.println("Status updated!");
                return;
            }
        }
        System.out.println("Job not found.");
    }

    // DELETE JOB
    public void deleteJob(int jobId) {
        job toRemove = null;

        for (job j : jobs) {
            if (j.getJob_id() == jobId) {
                toRemove = j;
                break;
            }
        }

        if (toRemove != null) {
            jobs.remove(toRemove);
            System.out.println("Job deleted!");
        } else {
            System.out.println("Job not found.");
        }
    }

    // SEARCH BY COMPANY
    public void searchByCompany(String companyName) {
        boolean found = false;

        for (job j : jobs) {
            if (j.getcompany().equalsIgnoreCase(companyName)) {
                System.out.println(j);
                System.out.println("------------------");
                found = true;
            }
        }

        if (!found) {
            System.out.println("No jobs found for this company.");
        }
    }
}
     */

    // later used Hashmap to optimise the solution in o(1) complexity.
    // job_id → job
    private Map<Integer, job> jobs = new HashMap<>();
    private int nextJobId = 1;

    public void addJob(String company, String role, String status) {

        String sql = "INSERT INTO job (company, job_role, job_status) VALUES (?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            // DEBUG LINES
            System.out.println("Connected DB URL: " + con.getMetaData().getURL());
            System.out.println("Connected User: " + con.getMetaData().getUserName());

            ps.setString(1, company);
            ps.setString(2, role);
            ps.setString(3, status);

            ps.executeUpdate();
            System.out.println("Job added successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    // VIEW ALL JOBS
    public void viewJobs() {

        String sql = "SELECT * FROM job";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            boolean found = false;

            while (rs.next()) {
                found = true;
                System.out.println(
                        "job_id: " + rs.getInt("job_id") +
                                "\ncompany: " + rs.getString("company") +
                                "\njob_role: " + rs.getString("job_role") +
                                "\njob_status: " + rs.getString("job_status")
                );
                System.out.println("------------------");
            }

            if (!found) {
                System.out.println("No jobs found.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    // UPDATE JOB STATUS
    public void updateJobStatus(int jobId, String newStatus) {

        String sql = "UPDATE job SET job_status = ? WHERE job_id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, newStatus);
            ps.setInt(2, jobId);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Status updated successfully!");
            } else {
                System.out.println("Job not found.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    // DELETE JOB
    public void deleteJob(int jobId) {

        String sql = "DELETE FROM job WHERE job_id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, jobId);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Job deleted successfully!");
            } else {
                System.out.println("Job not found.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    // SEARCH BY COMPANY
    public void searchByCompany(String companyName) {

        String sql = "SELECT * FROM job WHERE company = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, companyName);
            ResultSet rs = ps.executeQuery();

            boolean found = false;

            while (rs.next()) {
                found = true;
                System.out.println(
                        "job_id: " + rs.getInt("job_id") +
                                "\ncompany: " + rs.getString("company") +
                                "\njob_role: " + rs.getString("job_role") +
                                "\njob_status: " + rs.getString("job_status")
                );
                System.out.println("------------------");
            }

            if (!found) {
                System.out.println("No jobs found for this company.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

