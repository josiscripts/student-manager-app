package com.studentmanager;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager {

    private static ArrayList<Student> students;

    public static void main(String[] args) {

        students = JsonStorage.loadStudents();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nstudent manager app");
            System.out.println("1. add student");
            System.out.println("2. list students");
            System.out.println("3. update student");
            System.out.println("4. delete student");
            System.out.println("5. exit");
            System.out.print("choose option: ");

            int option = scanner.nextInt();
            scanner.nextLine();

            if (option == 1) {
                System.out.print("id: ");
                int id = scanner.nextInt();
                scanner.nextLine();

                System.out.print("name: ");
                String name = scanner.nextLine();

                System.out.print("course: ");
                String course = scanner.nextLine();

                students.add(new Student(id, name, course));
                JsonStorage.saveStudents(students);

            } else if (option == 2) {
                for (Student s : students) {
                    System.out.println(
                            s.getId() + " - " + s.getName() + " - " + s.getCourse()
                    );
                }

            } else if (option == 3) {
                System.out.print("id to update: ");
                int id = scanner.nextInt();
                scanner.nextLine();

                for (Student s : students) {
                    if (s.getId() == id) {
                        System.out.print("new name: ");
                        s.setName(scanner.nextLine());

                        System.out.print("new course: ");
                        s.setCourse(scanner.nextLine());

                        JsonStorage.saveStudents(students);
                        break;
                    }
                }

            } else if (option == 4) {
                System.out.print("id to delete: ");
                int id = scanner.nextInt();
                scanner.nextLine();

                students.removeIf(s -> s.getId() == id);
                JsonStorage.saveStudents(students);

            } else if (option == 5) {
                break;
            }
        }

        scanner.close();
    }
}
