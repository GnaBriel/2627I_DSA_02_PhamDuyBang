import java.util.*;
import java.io.*;
class Student implements Comparable<Student> {
    private int id;
    private String name;
    private double cgpa;
    public Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }
    public int getID() {
        return id;
    }
    public String getName() {
        return name;
    }
    public double getCGPA() {
        return cgpa;
    }
    public int compareTo(Student other) {
        if (Double.compare(other.cgpa, this.cgpa) != 0) {
            return Double.compare(other.cgpa, this.cgpa); 
        }
        if (!this.name.equals(other.name)) {
            return this.name.compareTo(other.name);
        }
        return Integer.compare(this.id, other.id);
    }
}

class Priorities {
    public List<Student> getStudents(List<String> events) {
        PriorityQueue<Student> pq = new PriorityQueue<>();
        for (String event : events) {
            String[] parts = event.split(" ");
            if (parts[0].equals("ENTER")) {
                String name = parts[1];
                double cgpa = Double.parseDouble(parts[2]);
                int id = Integer.parseInt(parts[3]);
                pq.add(new Student(id, name, cgpa));
            } else if (parts[0].equals("SERVED")) {
                if (!pq.isEmpty()) {
                    pq.poll();
                }
            }
        }

        List<Student> remainingStudents = new ArrayList<>();
        while (!pq.isEmpty()) {
            remainingStudents.add(pq.poll());
        }
        return remainingStudents;
    }
}

// Change the class name to "Solution" to match the file name request when submitting to HackerRank

public class JavaPriorityQueue{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<String> events = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            try {
                events.add(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Priorities priorities = new Priorities();
        List<Student> students = priorities.getStudents(events);
        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st : students) {
                System.out.println(st.getName());
            }
        }
    }
}