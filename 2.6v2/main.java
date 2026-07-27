public static void main(String[] args) {
    Set<Student> students = new HashSet<>();

    students.add(new Student("Иванов Иван", "ИТ-101", 1, Arrays.asList(4, 5, 3, 4)));
    students.add(new Student("Петров Пётр", "ИТ-101", 1, Arrays.asList(2, 3, 2, 3)));
    students.add(new Student("Сидорова Анна", "ИТ-102", 2, Arrays.asList(5, 5, 4, 5)));
    students.add(new Student("Кузнецов Олег", "ИТ-102", 2, Arrays.asList(2, 2, 3, 2)));
    students.add(new Student("Смирнова Мария", "ИТ-103", 1, Arrays.asList(4, 3, 4, 3)));

    System.out.println("Все студенты:");
    students.forEach(System.out::println);

    // Сначала делим студентов на группы ДО удаления, чтобы увидеть, кто не прошёл по баллу
    Set<Student> notPromoted = new HashSet<>();
    Set<Student> promoted = new HashSet<>();

    for (Student s : students) {
        if (s.getAverageGrade() >= 3) {
            promoted.add(s);
        } else {
            notPromoted.add(s); // средний балл < 3 - не переводится, будет удалён
        }
    }

    // Переводим на следующий курс тех, у кого средний балл >= 3
    promoteStudents(promoted);

    // Удаляем из основной коллекции неуспевающих студентов (средний балл < 3)
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

    // Демонстрация метода printStudents: печатает имена студентов заданного курса
    System.out.println("\nИмена студентов, обучающихся на 2 курсе (метод printStudents):");
    printStudents(students, 2);

    System.out.println("\nИмена студентов, обучающихся на 1 курсе (метод printStudents):");
    printStudents(students, 1);
}
}