package task5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UniqueSogl {
    public static void findUniqueSogl(Path path) {

        Set<Character> sogl = Set.of(
                'б', 'в', 'г', 'д', 'ж', 'з', 'й', 'к', 'л', 'м', 'н', 'п', 'р', 'с', 'т', 'ф', 'х', 'ц', 'ч', 'ш', 'щ'
        );

        // множества: для уникальных и повторяющихся согласных
        Set<Character> uniqueSogl = new HashSet<>();
        Set<Character> repeatedSogl = new HashSet<>();

        try {
            // Читаем весь текст из файла построчно
            List<String> lines = Files.readAllLines(path);

            // если символа нет в повторяющихся и уникальных, то добавляем к уникальным
            // если символ есть в уникальных, но снова появился, то удаляем из уникальных и кладем в повторяющиеся
            for (String line : lines) {
                // разбиваем строку на слова
                String[] words = line.split("\\s+");
                for (String word : words) {
                    // пробегаемся по символам в слове
                    for (char ch : word.toLowerCase().toCharArray()) {
                        if (sogl.contains(ch)) {
                            if (!uniqueSogl.contains(ch) && !repeatedSogl.contains(ch)) {
                                uniqueSogl.add(ch); // добавляем в уникальные
                            } else if (uniqueSogl.contains(ch)) {
                                uniqueSogl.remove(ch); // удаляем из уникальных
                                repeatedSogl.add(ch); // добавляем в повторяющиеся
                            }
                        }
                    }
                }
            }

            // сортируем оставшиеся уникальные согласные
            List<Character> result = new ArrayList<>(uniqueSogl);
            result.sort(Comparator.naturalOrder());

            // выводим результат
            System.out.println("Согласные, входящие ровно в одно слово:");
            for (Character ch : result) {
                System.out.print(ch + " ");
            }
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла: " + e.getMessage());
        }
    }
}