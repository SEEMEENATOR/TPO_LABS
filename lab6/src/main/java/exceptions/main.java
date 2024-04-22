package exceptions;

public class main {
    public static void main(String[] args) {
        Student student1 = new Student("Alice");
        try {
            double averageMark = student1.calculateAverageMark();
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        Group group1 = new Group("Group1");
        try {
            double averageMark = group1.calculateAverageMarkForSubject("Math");
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        Faculty faculty1 = new Faculty("Faculty1");
        try {
            double averageMark = faculty1.calculateAverageMarkForSubject("Math");
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        University university1 = new University("University1");
        try {
            double averageMark = university1.calculateAverageMarkForSubject("Math");
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            Subject subject = new Subject("Physics", 11);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}
