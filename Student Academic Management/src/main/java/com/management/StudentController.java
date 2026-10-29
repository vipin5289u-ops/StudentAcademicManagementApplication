package com.management;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final List<Student> students = new CopyOnWriteArrayList<>();
    private final AtomicInteger idCounter = new AtomicInteger(0);

    // 1. Get all students
    @GetMapping
    public List<Student> getStudents() {
        return students;
    }

    // 2. Add a new student
    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        student.setId(idCounter.incrementAndGet());
        students.add(student);
        return student;
    }

    // 3. Get student by ID
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable int id) {
        return students.stream()
                .filter(s -> s.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // 4. Update student
    @PutMapping("/{id}")
    public String updateStudent(
            @PathVariable int id,
            @RequestBody Student updatedStudent) {

        for (Student student : students) {
            if (student.getId() == id) {
                student.setName(updatedStudent.getName());
                student.setCourse(updatedStudent.getCourse());
                return "Student updated successfully!";
            }
        }

        return "Student not found!";
    }

    // 5. Delete student
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable int id) {
        boolean removed = students.removeIf(s -> s.getId() == id);

        return removed
                ? "Student with ID " + id + " deleted successfully"
                : "Student with ID " + id + " not found";
    }
}