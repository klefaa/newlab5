import task1.Fraction;
import task2.Cat;
import task2.MeowingCounter;
import task2.MeowingProcessor;
import task2.Lynx;
import task3.MergeSortedLists;
import task4.Participant;
import task4.SchoolCompetition;
import task5.UniqueSogl;
import task6.CircleQueue;
import task7.Point;
import task7.Polyline;
import task8.Person;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        while (choice != 0) {
            System.out.println("Выберите задачу:");
            System.out.println("1. (1.1) Кэширование");
            System.out.println("2. (2.1) Декоратор");
            System.out.println("3. (3.3) Списки (объединение упорядоченных списков)");
            System.out.println("4. (4.3) Мап (соревнование)");
            System.out.println("5. (5.3) Сет (согласные)");
            System.out.println("6. (6.3) Очередь (круг)");
            System.out.println("7. (7.1) Ломаная из набора точек");
            System.out.println("8. (7.2) Стрим для набора учеников по номерам");
            choice = scanner.nextInt();
            switch (choice) {
                case 1: {
                    Fraction fraction1 = new Fraction(1, 2);
                    Fraction fraction2 = new Fraction(2, 4);
                    Fraction fraction3 = new Fraction(1, 2);

                    System.out.println("fraction1 = " + fraction1);
                    System.out.println("fraction2 = " + fraction2);
                    System.out.println("fraction3 = " + fraction3);

                    System.out.println();

                    System.out.println(fraction1 + " == " + fraction3 + ": " + fraction1.equals(fraction3));

                    System.out.println();

                    System.out.println(fraction1 + " == " + fraction2 + ": " + fraction1.equals(fraction2));
                    System.out.println(fraction1 + " = " + fraction1.getDoubleValue());
                    System.out.println(fraction2 + " = " + fraction2.getDoubleValue());
                    System.out.println();
                    System.out.println("fraction1.setZnam(-3)");
                    System.out.println();
                    fraction1.setZnam(-3);
                    System.out.println(fraction1 + " == " + fraction2 + ":" + fraction1.equals(fraction2));
                    System.out.println(fraction1 + " = " + fraction1.getDoubleValue());
                    System.out.println(fraction2 + " = " + fraction2.getDoubleValue());
                    break;
                }
                case 2: {
                    Cat cat = new Cat("cat");
                    Lynx lynx = new Lynx("lynx");

                    MeowingCounter catCounter = new MeowingCounter(cat);
                    MeowingCounter lynxCounter = new MeowingCounter(lynx);

                    System.out.println("// task2.MeowingProcessor.processMeowing(catCounter, lynxCounter, catCounter)");
                    MeowingProcessor.processMeowing(catCounter, lynxCounter, catCounter);

                    System.out.println("Количество мяуканий кота: " + catCounter.getCount());
                    System.out.println("Количество мяуканий рыси: " + lynxCounter.getCount());
                    break;
                }
                case 3: {
                    List<Integer> L1 = new ArrayList<>();
                    List<Integer> L2 = new ArrayList<>();
                    L1.add(1);
                    L1.add(3);
                    L1.add(5);
                    L1.add(7);
                    L2.add(2);
                    L2.add(4);
                    L2.add(6);
                    L2.add(8);

                    // Слияние списков
                    List<Integer> mergedList = MergeSortedLists.mergeLists(L1, L2);

                    System.out.println("Объединённый упорядоченный список: " + mergedList);
                    break;
                }
                case 4: {
                    /* входные данные
4
Чуйко Иван 0 0 0 0
Павлова Екатерина 9 9 9 8
Иванова Мария 5 8 6 3
Петров Сергей 9 9 5 7
                     */
                    System.out.println("Введите количество участников:");
                    int n = scanner.nextInt();
                    scanner.nextLine(); // Очистка буфера после ввода числа

                    List<Participant> participants = new ArrayList<>();

                    System.out.println("Введите данные участников (формат: Фамилия Имя Баллы):");
                    // разбиваем строку по требованиям
                    for (int i = 0; i < n; i++) {
                        String input = scanner.nextLine();
                        String[] parts = input.split(" ");
                        String surname = parts[0];
                        String name = parts[1];
                        int score1 = Integer.parseInt(parts[2]);
                        int score2 = Integer.parseInt(parts[3]);
                        int score3 = Integer.parseInt(parts[4]);
                        int score4 = Integer.parseInt(parts[5]);
                        // сумма баллов
                        int totalScore = score1 + score2 + score3 + score4;
                        // создание записей о каждом участнике
                        participants.add(new Participant(surname, name, totalScore));
                    }

                    // обработка участников
                    SchoolCompetition.process(participants);
                    break;
                }
                case 5: {
                    Path filename = Paths.get("resources/text.txt");
                    UniqueSogl.findUniqueSogl(filename);
                    break;
                }
                case 6: {
                    // создаем очередь
                    Queue<Integer> queue = new LinkedList<>();
                    queue.add(1);
                    queue.add(2);
                    queue.add(3);
                    queue.add(3);


                    boolean podhodit = CircleQueue.circle(queue);
                    if (podhodit) {
                        System.out.println("В очереди есть элементы, равные следующим за ними.");
                    } else {
                        System.out.println("В очереди нет элементов, равных следующим за ними.");
                    }
                    break;
                }
                case 7: {
                    Point p1 = new Point(1, 2);
                    Point p12 = new Point(1, 2);
                    Point p13 = new Point(1, -2);
                    Point p2 = new Point(3, 4);
                    Point p3 = new Point(5, 6);
                    Point p4 = new Point(1, 2);
                    Point p5 = new Point(3, -4);
                    Point p6 = new Point(4, -4);

                    List<Point> points = Arrays.asList(p1, p12, p13, p2, p3, p4, p5, p6);

                    System.out.println("Исходный список точек: " + points);

                    List<Point> processedPoints = points.stream()
                            .map(p -> new Point(p.getX(), Math.abs(p.getY())))
                            .distinct()
                            .sorted(Comparator.comparingInt(Point::getX))
                            .collect(Collectors.toList());

                    Polyline polyline = new Polyline(processedPoints);
                    System.out.println(polyline);
                    break;
                }
                case 8: {
                    Path filename = Paths.get("resources/peoples_and_numbers.txt");

                    try {
                        Map<Integer, List<String>> names = Files.lines(filename)
                                .map(line -> {
                                    String[] parts = line.split(":");
                                    String name = parts[0].trim();
                                    String numberStr = parts.length > 1 ? parts[1].trim() : null;

                                    String formattedName = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();

                                    Integer number = numberStr != null && !numberStr.isEmpty() ? Integer.parseInt(numberStr) : null;

                                    return new Person(formattedName, number);
                                })
                                .filter(person -> person.getNumber() != null)
                                .collect(Collectors.groupingBy(Person::getNumber, Collectors.mapping(Person::getName, Collectors.toList())));
                        System.out.println(names);
                    } catch (IOException e) {
                        System.out.println("Ошибка чтения файла: " + e.getMessage());
                        System.out.println("Текущая директория: " + System.getProperty("user.dir"));
                    }
                    break;
                }
            }
        }

    }
}