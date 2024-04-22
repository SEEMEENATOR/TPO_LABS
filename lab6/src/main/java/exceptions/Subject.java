package exceptions;

import java.util.ArrayList;
import java.util.List;
class Subject {
    private String name;
    private int mark;

    public Subject(String name, int mark) {
        this.name = name;
        if (mark < 0 || mark > 10) {
            throw new IllegalArgumentException("Mark should be between 0 and 10");
        }
        this.mark = mark;
    }

    public String getName() {
        return name;
    }

    public int getMark() {
        return mark;
    }
}
class Student {
    private String name;
    private List<Subject> subjects;

    public Student(String name) {
        this.name = name;
        this.subjects = new ArrayList<>();
    }
    public List<Subject> getSubjects (){
        return subjects;
    }

    public void addSubject(Subject subject) {
        subjects.add(subject);
    }

    public double calculateAverageMark() {
        if (subjects.isEmpty()) {
            throw new IllegalArgumentException("Student should have at least one subject");
        }
        int sum = 0;
        for (Subject subject : subjects) {
            sum += subject.getMark();
        }
        return (double) sum / subjects.size();
    }
}

class Group {
    private String name;
    private List<Student> students;

    public Group(String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public double calculateAverageMarkForSubject(String subjectName) {
        if (students.isEmpty()) {
            throw new IllegalArgumentException("Group should have at least one student");
        }
        int sum = 0;
        int count = 0;
        for (Student student : students) {
            for (Subject subject : student.getSubjects()) {
                if (subject.getName().equals(subjectName)) {
                    sum += subject.getMark();
                    count++;
                }
            }
        }
        if (count == 0) {
            throw new IllegalArgumentException("Subject not found in the group");
        }
        return (double) sum / count;
    }
}

class Faculty {
    private String name;
    private List<Group> groups;

    public Faculty(String name) {
        this.name = name;
        this.groups = new ArrayList<>();
    }

    public void addGroup(Group group) {
        groups.add(group);
    }

    public double calculateAverageMarkForSubject(String subjectName) {
        if (groups.isEmpty()) {
            throw new IllegalArgumentException("Faculty should have at least one group");
        }
        int sum = 0;
        int count = 0;
        for (Group group : groups) {
            try {
                sum += group.calculateAverageMarkForSubject(subjectName);
                count++;
            } catch (IllegalArgumentException e) {
                // Subject not found in the group
            }
        }
        if (count == 0) {
            throw new IllegalArgumentException("Subject not found in any group of the faculty");
        }
        return (double) sum / count;
    }
}

class University {
    private String name;
    private List<Faculty> faculties;

    public University(String name) {
        this.name = name;
        this.faculties = new ArrayList<>();
    }

    public void addFaculty(Faculty faculty) {
        faculties.add(faculty);
    }

    public double calculateAverageMarkForSubject(String subjectName) {
        if (faculties.isEmpty()) {
            throw new IllegalArgumentException("University should have at least one faculty");
        }
        int sum = 0;
        int count = 0;
        for (Faculty faculty : faculties) {
            try {
                sum += faculty.calculateAverageMarkForSubject(subjectName);
                count++;
            } catch (IllegalArgumentException e) {
            }
        }
        if (count == 0) {
            throw new IllegalArgumentException("Subject not found in any group of any faculty of the university");
        }
        return (double) sum / count;
    }
}
