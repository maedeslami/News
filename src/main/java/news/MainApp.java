package news;

import news.model.NewsDto;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

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
    }
}

//        int[] priority = new int[]{
//                0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
//                1, 1, 1, 1, 1, 1, 1, 1, 1,
//                2, 2, 2, 2, 2, 2, 2, 2,
//                3, 3, 3, 3, 3, 3, 3,
//                4, 4, 4, 4, 4, 4,
//                5, 5, 5, 5, 5,
//                6, 6, 6, 6,
//                7, 7, 7,
//                8, 8,
//                9
//        };
//        List<String> headline = new ArrayList();
//        headline.add("up");
//        headline.add("down");
//        headline.add("failure");
//        headline.add("success");
//        headline.add("good");
//        headline.add("bad");
//        headline.add("über");
//        headline.add("unter");
//        headline.add("high");
//        headline.add("low");
//        headline.add("rise");
//        headline.add("fall");
//
//        List<String> positive = new ArrayList<>();
//        positive.add("up");
//        positive.add("good");
//        positive.add("rise");
//        positive.add("success");
//        positive.add("high");
//        positive.add("über");
//
//        Random random = ThreadLocalRandom.current();
//
//       for (int n=0;n<5;n++)
//        {
//            NewsDto dto = new NewsDto();
//            shuffleArray(priority);
//            for (int i = 0; i < priority.length; i++) {
//                dto.setPriority(priority[i]);
//
//            }
////combination
//            List<String> combination = random
//                    .ints(3 + random.nextInt(3), 0, headline.size())
//                    .mapToObj(headline::get)
//                    .collect(Collectors.toList());
//
//            dto.setHeadline(String.valueOf(combination));
////            Thread thread = new Thread(dto);
////            thread.start();
//           Thread.sleep(5000);
//            System.out.println("this news has priority :" + dto.getPriority() + "  and this news has this headline value: " + dto.getHeadline());
//
//            //check positive or not
//            double percent = 100.0 * combination.stream().filter(positive::contains).count() / combination.size();

//            if (percent > 50) {
//                System.out.println("its positive");
//            }
//            if (dto.getPriority() == 9 && percent > 50) {
//                System.out.println("This message is more than 50% about a positive Things and contains this headline :" + combination + " and has prioity :" + dto.getPriority());
//            }
//            String url = "http://localhost:8086";
//            RestTemplate restTemplate = new RestTemplate();
//            NewsDto dto1 = restTemplate.postForObject(url, dto, NewsDto.class);
//        }
//    }
//
//    static void shuffleArray(int[] ar) {
//        Random rnd = ThreadLocalRandom.current();
//        for (int i = ar.length - 1; i > 0; i--) {
//            int index = rnd.nextInt(i + 1);
//            //swap
//            int a = ar[index];
//            ar[index] = ar[i];
//            ar[i] = a;
//        }
