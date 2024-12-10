package task4;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SchoolCompetition {
    public static void process(List<Participant> participants) {
        // сортируем участников по убыванию
        participants.sort((a, b) -> b.totalScore - a.totalScore);

        // среди баллов берем первые три, если столько нету, то меньше трех максимальных баллов
        // записываем значения в set (множество без повторов элементов)
        Set<Integer> topScores = new HashSet<>();
        for (int i = 0; i < Math.min(3, participants.size()); i++) {
            topScores.add(participants.get(i).totalScore);
        }

        // ищем участников, баллы которых есть в максимальных баллах
        for (Participant participant : participants) {
            if (topScores.contains(participant.totalScore)) {
                System.out.println(participant.lastname + " " + participant.name);
            }
        }
    }
}
