import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        JobService service = new JobService();
        int choice;

        while (true) {

            System.out.println("\n===== JOB APPLICATION TRACKER =====");
            System.out.println("1. Add Job");
            System.out.println("2. View All Jobs");
            System.out.println("3. Update Job Status");
            System.out.println("4. Delete Job");
            System.out.println("5. Search Job by Company");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {

                case 1:
                    System.out.print("Enter Company: ");
                    String company = sc.nextLine();

                    System.out.print("Enter Job Role: ");
                    String role = sc.nextLine();

                    System.out.print("Enter Job Status: ");
                    String status = sc.nextLine();

                    service.addJob(company, role, status);
                    break;

                case 2:
                    service.viewJobs();
                    break;

                case 3:
                    System.out.print("Enter Job ID to update: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter New Status: ");
                    String newStatus = sc.nextLine();

                    service.updateJobStatus(updateId, newStatus);
                    break;

                case 4:
                    System.out.print("Enter Job ID to delete: ");
                    int deleteId = sc.nextInt();
                    sc.nextLine();

                    service.deleteJob(deleteId);
                    break;

                case 5:
                    System.out.print("Enter Company Name: ");
                    String searchCompany = sc.nextLine();

                    service.searchByCompany(searchCompany);
                    break;

                case 6:
                    System.out.println("Exiting program. Goodbye!");
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
