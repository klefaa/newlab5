package task3;

import java.util.ArrayList;
import java.util.List;

public class MergeSortedLists {
    public static List<Integer> mergeLists(List<Integer> L1, List<Integer> L2) {
        List<Integer> result = new ArrayList<>();
        int i = 0, j = 0;

        // смотрим на два списка, пока в них в обоих есть элементы
        while (i < L1.size() && j < L2.size()) {
            // меньший из рассматриваемых элементов добавляем в результирующий список
            if (L1.get(i) <= L2.get(j)) {
                result.add(L1.get(i));
                i++;
            } else {
                result.add(L2.get(j));
                j++;
            }
        }
        // если какой-то список кончился добавляем в список все оставшиеся элементы из непустого списка

        // добавление оставшихся элементов из L1
        while (i < L1.size()) {
            result.add(L1.get(i));
            i++;
        }

        // добавление оставшихся элементов из L2
        while (j < L2.size()) {
            result.add(L2.get(j));
            j++;
        }
        return result;
    }
}