package ar.com.problems.numbers;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Greed {

    public static int greedy(int[] dice){
        Map<Integer, Long> collect = Arrays.stream(dice)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        int score = 0;
        for (Map.Entry<Integer, Long> e : collect.entrySet()) {
            switch (e.getKey()) {
                case 1: score += ( ( e.getValue() >= 3) ? 1000 : 0) + (e.getValue() % 3) * 100; break;
                case 2: score += ( ( e.getValue() >= 3) ? 200 : 0); break;
                case 3: score += ( ( e.getValue() >= 3) ? 300 : 0); break;
                case 4: score += ( ( e.getValue() >= 3) ? 400 : 0); break;
                case 5: score += ( ( e.getValue() >= 3) ? 500 : 0) + (e.getValue() % 3) * 50; break;
                case 6: score += ( ( e.getValue() >= 3) ? 600 : 0); break;
            }
        }
        return score;
    }

    public static int greedyAnotherChance(int[] dice) {
        int n[] = new int[7];
        for (int d : dice) n[d]++;
        return n[1]/3*1000 + n[1]%3*100 + n[2]/3*200 + n[3]/3*300 + n[4]/3*400 + n[5]/3*500 + n[5]%3*50 + n[6]/3*600;
    }

}
