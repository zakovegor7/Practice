import java.util.*;

public class StudentManagement {

    // Класс Student
    static class Student {
        private String name;
        private String group;
        private int course;
        private List<Integer> grades;

        public Student(String name, String group, int course, List<Integer> grades) {
            this.name = name;
            this.group = group;
            this.course = course;
            this.grades = grades;
        }

        public String getName() {
            return name;
        }

        public String getGroup() {
            return group;
        }

        public int getCourse() {
            return course;
        }

        public void setCourse(int course) {
            this.course = course;
        }

        public List<Integer> getGrades() {
            return grades;
        }

        // Вычисление среднего балла
        public double getAverageGrade() {
            if (grades == null || grades.isEmpty()) {
                return 0.0;
            }
            double sum = 0;
            for (int g : grades) {
                sum += g;
            }
            return sum / grades.size();
        }

        @Override
        public String toString() {
            return String.format("%s (группа %s, курс %d, средний балл %.2f)",
                    name, group, course, getAverageGrade());
        }
    }

    public static void removeStudentsWithLowAverage(Set<Student> students) {
        students.removeIf(s -> s.getAverageGrade() < 3);
    }

    public static void promoteStudent(Student student) {
        if (student.getAverageGrade() >= 3) {
            student.setCourse(student.getCourse() + 1);
        }
    }

    public static void promoteStudents(Set<Student> students) {
        for (Student s : students) {
            promoteStudent(s);
        }
    }

    public static void printStudents(Set<Student> students, int course) {
        for (Student s : students) {
            if (s.getCourse() == course) {
                System.out.println(s.getName());
            }
        }
    }
    public static void main(String[] args) {
        Set<Student> students = new HashSet<>();

        students.add(new Student("Иванов Иван", "ИТ-101", 1, Arrays.asList(4, 5, 3, 4)));
        students.add(new Student("Петров Пётр", "ИТ-101", 1, Arrays.asList(2, 3, 2, 3)));
        students.add(new Student("Сидорова Анна", "ИТ-102", 2, Arrays.asList(5, 5, 4, 5)));
        students.add(new Student("Кузнецов Олег", "ИТ-102", 2, Arrays.asList(2, 2, 3, 2)));
        students.add(new Student("Смирнова Мария", "ИТ-103", 1, Arrays.asList(4, 3, 4, 3)));

        System.out.println("Все студенты:");
        students.forEach(System.out::println);


        Set<Student> notPromoted = new HashSet<>();
        Set<Student> promoted = new HashSet<>();

        for (Student s : students) {
            if (s.getAverageGrade() >= 3) {
                promoted.add(s);
            } else {
                notPromoted.add(s);
            }
        }

        promoteStudents(promoted);


        removeStudentsWithLowAverage(students);

        System.out.println("\nСтуденты, которые НЕ перешли на следующий курс (и были удалены):");
        if (notPromoted.isEmpty()) {
            System.out.println("(таких студентов нет)");
        } else {
            notPromoted.forEach(System.out::println);
        }

        System.out.println("\nСтуденты, которые перешли на следующий курс:");
        if (promoted.isEmpty()) {
            System.out.println("(таких студентов нет)");
        } else {
            promoted.forEach(System.out::println);
        }

        System.out.println("\nИмена студентов, обучающихся на 2 курсе:");
        printStudents(students, 2);

        System.out.println("\nИмена студентов, обучающихся на 1 курсе:");
        printStudents(students, 1);
    }
}
