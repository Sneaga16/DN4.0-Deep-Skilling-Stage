import java.util.Scanner;

class Staff {
    int id;
    String fullName;
    String jobTitle;
    double monthlySalary;

    Staff(int id, String fullName, String jobTitle, double monthlySalary) {
        this.id = id;
        this.fullName = fullName;
        this.jobTitle = jobTitle;
        this.monthlySalary = monthlySalary;
    }

    public String info() {
        return "[#" + id + "] " + fullName + " - " + jobTitle + " | ₹" + monthlySalary;
    }
}

public class StaffRegistrySystem {
    static final int LIMIT = 50;
    static Staff[] records = new Staff[LIMIT];
    static int size = 0;

    static void insertStaff(int id, String name, String title, double salary) {
        if (size >= LIMIT) {
            System.out.println("Storage Full. Cannot add more staff.");
            return;
        }
        records[size++] = new Staff(id, name, title, salary);
        System.out.println("Staff registered.");
    }

    static void showAll() {
        if (size == 0) {
            System.out.println("No staff data available.");
            return;
        }
        for (int i = 0; i < size; i++) {
            System.out.println(records[i].info());
        }
    }

    static void findById(int searchId) {
        boolean found = false;
        for (int i = 0; i < size; i++) {
            if (records[i].id == searchId) {
                System.out.println("Match: " + records[i].info());
                found = true;
                break;
            }
        }
        if (!found) System.out.println("No staff with ID " + searchId + " found.");
    }

    static void removeStaff(int removeId) {
        for (int i = 0; i < size; i++) {
            if (records[i].id == removeId) {
                for (int j = i; j < size - 1; j++) {
                    records[j] = records[j + 1];
                }
                records[--size] = null;
                System.out.println("Staff removed.");
                return;
            }
        }
        System.out.println("ID not located.");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- STAFF REGISTRY PANEL ---");
            System.out.println("1 → Add Staff");
            System.out.println("2 → Search Staff by ID");
            System.out.println("3 → View All Staff");
            System.out.println("4 → Delete Staff by ID");
            System.out.println("5 → Close");
            System.out.print("Option: ");
            choice = in.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Staff ID: ");
                    int sid = in.nextInt(); in.nextLine();
                    System.out.print("Full Name: ");
                    String sname = in.nextLine();
                    System.out.print("Job Title: ");
                    String stitle = in.nextLine();
                    System.out.print("Monthly Salary: ");
                    double sal = in.nextDouble();
                    insertStaff(sid, sname, stitle, sal);
                    break;
                case 2:
                    System.out.print("Enter ID to search: ");
                    int search = in.nextInt();
                    findById(search);
                    break;
                case 3:
                    showAll();
                    break;
                case 4:
                    System.out.print("Enter ID to delete: ");
                    int delId = in.nextInt();
                    removeStaff(delId);
                    break;
                case 5:
                    System.out.println("Shutting down registry...");
                    break;
                default:
                    System.out.println("Invalid input.");
            }

        } while (choice != 5);

        in.close();
    }
}j