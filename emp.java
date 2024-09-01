import java.util.Scanner;

public class emp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] E_name = new String[100];
        int[] E_id = new int[100];
        char[] E_designation = new char[100];
        double[] basic = new double[100];
        double[] hra = new double[100];
        double[] it = new double[100];
        int employees = 0;
        while (true) {
            System.out.println("Employee Management System");
            System.out.println("1. Add Employee: ");
            System.out.println("2. Calculate Salary: ");
            System.out.println("3. Print Employee Details: ");
            System.out.println("4. Exit");
            System.out.println("Enter your choice: ");
            if (input.hasNextInt()) {
                int choice = input.nextInt();
                switch (choice) {
                    case 1:
                        if (employees < 10) {
                            System.out.println("Enter Employee Name: ");
                            E_name[employees] = input.next();
                            System.out.println("Enter Employee ID: ");
                            if (input.hasNextInt()) {
                                E_id[employees] = input.nextInt();
                                System.out.println("Enter Employee Designation (e/c/k/r/m): ");
                                E_designation[employees] = input.next().charAt(0);
                                System.out.println("Enter Basic Salary: ");
                                basic[employees] = input.nextDouble();
                                System.out.println("Enter HRA: ");
                                hra[employees] = input.nextDouble();
                                System.out.println("Enter IT: ");
                                it[employees] = input.nextDouble();
                                employees++;
                                System.out.println("Employee Added Successfully");
                            }
                        } else {
                            System.out.println("Employee limit reached");
                        }
                        break;
                    case 2:
                        System.out.println("Enter Employee ID: ");
                        int search = input.nextInt();
                        int index = -1;
                        for (int i = 0; i < employees; i++) {
                            if (E_id[i] == search) {
                                index = i;
                                break;
                            }
                        }
                        if (index != -1) {
                            double da = 0;
                            String da_table = "";
                            switch (E_designation[index]) {
                                case 'e':
                                    da_table = "Engineer";
                                    da = 20000;
                                    break;
                                case 'c':
                                    da_table = "Consultant";
                                    da = 32000;
                                    break;
                                case 'k':
                                    da_table = "Clerk";
                                    da = 12000;
                                    break;
                                case 'r':
                                    da_table = "Receptionist";
                                    da = 15000;
                                    break;
                                case 'm':
                                    da_table = "Manager";
                                    da = 40000;
                                    break;
                                default:
                                    da_table = "Invalid";
                                    break;
                            }
                            double salary = basic[index] + hra[index] + da - it[index];
                            System.out.println("Employee Name: " + E_name[index]);
                            System.out.println("Designation: " + E_designation[index] + "");
                            System.out.println("Salary: " + salary);
                        } else {
                            System.out.println("Emplyee not found!");
                        }
                        break;
                    case 3:
                        System.out.println("Employee Details: ");
                        for (int i = 0; i < employees; i++) {
                            System.out.println("Employee " + (i + 1) + ":");
                            System.out.println("Name: " + E_name[i]);
                            System.out.println("Employee ID: " + E_id[i]);
                            System.out.println("Designation: " + E_designation[i]);
                            System.out.println("Basic Salary: " + basic[i]);
                            System.out.println("HRA: " + hra[i]);
                            System.out.println("IT: " + it[i]);
                        }
                        break;
                    case 4:
                        System.out.println("Exit");
                        input.close();
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid choice (1-4).");
                input.next();
            }
        }
    }
}
