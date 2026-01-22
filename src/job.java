public class job {

    private int job_id;
    private String company;
    private String job_role;
    private String job_status;

    public job(int job_id, String company, String job_role, String job_status) {
        this.job_id = job_id;
        this.company = company;
        this.job_role = job_role;
        this.job_status = job_status;
    }

    //getters used to get values
    public int getJob_id() {
        return job_id;
    }

    public String getcompany() {
        return company;
    }

    public String getJob_role() {
        return job_role;
    }

    public String getJob_status() {
        return job_status;
    }

    //setters to set values
    public void setJob_status(String status) {
        this.job_status = status;
    }

    @Override
    public String toString() {
        return "job_id: " + job_id +
                "\ncompany: " + company +
                "\njob_role: " + job_role +
                "\njob_status: " + job_status;
    }
}
