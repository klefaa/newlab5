package task6;

import java.util.Queue;

public class CircleQueue {

    public static boolean circle(Queue<Integer> queue) {
        // если очередь пуста или маленькая, то проверка не прошла
        if (queue.isEmpty() || queue.size() == 1) {
            return false;
        }

        // перебираем элементы в очереди
        // предыдущий элемент
        Integer previous = null;
        // первый элемент сохраняем, чтобы в конце сравнить с последним (для кругового сравнения)
        Integer first = null;

        for (Integer current : queue) {
            // сохраняем первый, если его еще не сохраняли
            if (first == null) {
                first = current;
            }
            // сравниваем текущий и предыдущий элементы
            if (previous != null && previous.equals(current)) {
                return true; // Найдено совпадение
            }
            // сдвигаемся на следующий элемент
            previous = current;
        }

        // проверяем последний элемент с первым
        return previous != null && previous.equals(first);
    }
}
