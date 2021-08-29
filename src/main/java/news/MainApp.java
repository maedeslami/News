package news;

import news.model.NewsDto;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

/**
 * Created by Lenovo on 8/24/2021.
 */

@SpringBootApplication
public class MainApp {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(MainApp.class, args);

        int[] priority = new int[]{
                0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                1, 1, 1, 1, 1, 1, 1, 1, 1,
                2, 2, 2, 2, 2, 2, 2, 2,
                3, 3, 3, 3, 3, 3, 3,
                4, 4, 4, 4, 4, 4,
                5, 5, 5, 5, 5,
                6, 6, 6, 6,
                7, 7, 7,
                8, 8,
                9
        };
        List<String> headline = new ArrayList();
        headline.add("up");
        headline.add("down");
        headline.add("fail");
        headline.add("success");
        headline.add("good");
        headline.add("bad");
        headline.add("upper");
        headline.add("uber");


        String[] database = {"up", "down", "fail", "success", "good", "bad", "upper", "uber"};
        Random random = ThreadLocalRandom.current();

        while (true)

        {


            NewsDto dto = new NewsDto();
            shuffleArray(priority);
            for (int i = 0; i < priority.length; i++) {
                dto.setPriority(priority[i]);

            }
            List<String> positive=new ArrayList<>();
            positive.add("up");
            positive.add("good");
            positive.add("rise");
            positive.add("success");
            positive.add("high");
            positive.add("uber");

            List<String> combination = random
                    .ints(0, headline.size()) // IntStream random indexes
                    .distinct()
                    .limit(3 + random.nextInt(3))
                    .mapToObj(headline::get)
                    .collect(Collectors.toList());

            dto.setHeadline(String.valueOf(combination));
            Thread thread = new Thread(dto);
            thread.start();
            Thread.sleep(5000);
            System.out.println("this news has priority :" + dto.getPriority() + "  and this news has this headline value: " + dto.getHeadline());

            //check positive or not
            if (combination.containsAll(positive)){
                System.out.println("its positive");
            }

        }

    }

    static void shuffleArray(int[] ar) {
        Random rnd = ThreadLocalRandom.current();
        for (int i = ar.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            //swap
            int a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }
}
