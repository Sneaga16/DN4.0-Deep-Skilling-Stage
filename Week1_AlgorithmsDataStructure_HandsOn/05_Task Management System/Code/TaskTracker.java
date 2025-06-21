import java.util.Scanner;

class TaskNode {
    int taskId;
    String taskName;
    String status;
    TaskNode next;

    TaskNode(int id, String name, String stat) {
        taskId = id;
        taskName = name;
        status = stat;
        next = null;
    }
}

public class TaskTracker {

    private TaskNode head = null;

    
    public void appendTask(int id, String name, String stat) {
        TaskNode newNode = new TaskNode(id, name, stat);
        if (head == null) {
            head = newNode;
        } else {
            TaskNode walk = head;
            while (walk.next != null) {
                walk = walk.next;
            }
            walk.next = newNode;
        }
        System.out.println("Task added.");
    }

    
    public void listTasks() {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }
        TaskNode current = head;
        while (current != null) {
            System.out.println("[#" + current.taskId + "] " + current.taskName + " (" + current.status + ")");
            current = current.next;
        }
    }

    
    public void findTask(int searchId) {
        TaskNode ptr = head;
        boolean found = false;
        while (ptr != null) {
            if (ptr.taskId == searchId) {
                System.out.println("Found: " + ptr.taskName + " [" + ptr.status + "]");
                found = true;
                break;
            }
            ptr = ptr.next;
        }
        if (!found) {
            System.out.println("Task ID not found.");
        }
    }

    
    public void deleteTask(int delId) {
        if (head == null) {
            System.out.println("Nothing to delete.");
            return;
        }

        if (head.taskId == delId) {
            head = head.next;
            System.out.println("Task removed.");
            return;
        }

        TaskNode prev = head;
        TaskNode curr = head.next;

        while (curr != null) {
            if (curr.taskId == delId) {
                prev.next = curr.next;
                System.out.println("Task removed.");
                return;
            }
            prev = curr;
            curr = curr.next;
        }

        System.out.println("Task ID not found.");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TaskTracker manager = new TaskTracker();
        int option;

        do {
            System.out.println("\n--- TASK TRACKER ---");
            System.out.println("1) Add Task");
            System.out.println("2) Show All Tasks");
            System.out.println("3) Search Task by ID");
            System.out.println("4) Delete Task");
            System.out.println("5) Exit");
            System.out.print("Pick an option: ");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Task ID: ");
                    int tid = sc.nextInt(); sc.nextLine();
                    System.out.print("Task Name: ");
                    String tname = sc.nextLine();
                    System.out.print("Status: ");
                    String tstatus = sc.nextLine();
                    manager.appendTask(tid, tname, tstatus);
                    break;
                case 2:
                    manager.listTasks();
                    break;
                case 3:
                    System.out.print("Enter ID to search: ");
                    int search = sc.nextInt();
                    manager.findTask(search);
                    break;
                case 4:
                    System.out.print("Enter ID to delete: ");
                    int del = sc.nextInt();
                    manager.deleteTask(del);
                    break;
                case 5:
                    System.out.println("Exiting system...");
                    break;
                default:
                    System.out.println("Invalid option.");
            }

        } while (option != 5);
        sc.close();
    }
}