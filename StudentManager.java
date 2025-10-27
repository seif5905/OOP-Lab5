import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentManager {
    private List<Student> students;
    private static final String FILE_NAME = "students.dat";
    
    public StudentManager() {
        students = new ArrayList<>();
        loadStudents();
    }
    
    // Add student
    public boolean addStudent(Student student) {
        // Check if ID already exists
        for (Student s : students) {
            if (s.getStudentId() == student.getStudentId()) {
                return false;
            }
        }
        students.add(student);
        saveStudents();
        return true;
    }
    
    // Get all students
    public List<Student> getAllStudents() {
        return students;
    }
    
    // Search student by ID
    public Student searchById(int id) {
        for (Student s : students) {
            if (s.getStudentId() == id) {
                return s;
            }
        }
        return null;
    }
    
    // Search students by name
    public List<Student> searchByName(String name) {
        List<Student> result = new ArrayList<>();
        for (Student s : students) {
            if (s.getFullName().toLowerCase().contains(name.toLowerCase())) {
                result.add(s);
            }
        }
        return result;
    }
    
    // Update student
    public boolean updateStudent(int id, Student updatedStudent) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getStudentId() == id) {
                students.set(i, updatedStudent);
                saveStudents();
                return true;
            }
        }
        return false;
    }
    
    // Delete student
    public boolean deleteStudent(int id) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getStudentId() == id) {
                students.remove(i);
                saveStudents();
                return true;
            }
        }
        return false;
    }
    
    // Save to file
    private void saveStudents() {
        try {
            FileOutputStream fos = new FileOutputStream(FILE_NAME);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(students);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    // Load from file
    @SuppressWarnings("unchecked")
    private void loadStudents() {
        try {
            File file = new File(FILE_NAME);
            if (file.exists()) {
                FileInputStream fis = new FileInputStream(FILE_NAME);
                ObjectInputStream ois = new ObjectInputStream(fis);
                students = (List<Student>) ois.readObject();
                ois.close();
                fis.close();
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    // Generate next ID
    public int generateNextId() {
        if (students.isEmpty()) {
            return 1000;
        }
        int maxId = 0;
        for (Student s : students) {
            if (s.getStudentId() > maxId) {
                maxId = s.getStudentId();
            }
        }
        return maxId + 1;
    }
}
