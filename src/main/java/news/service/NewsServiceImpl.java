package news.service;

import news.config.NewsDiscovery;
import news.model.NewsDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * Created by Lenovo on 8/25/2021.
 */
@Service
public class NewsServiceImpl implements NewsService {

    private int numberOfThread = 25 ;
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

    @Override
    public void executeParallelNews(NewsDto newsDto, Consumer<String> response) {
        for (int counter = 0; counter <= numberOfThread; counter++) {
            Thread thread = new Thread(() -> this.sendMockNews(newsDto, response));
            thread.start();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void sendMockNews(NewsDto newsDto, Consumer<String> response) {
        //headLine
        List<String> headline = new ArrayList();
        headline.add("up");
        headline.add("down");
        headline.add("failure");
        headline.add("success");
        headline.add("good");
        headline.add("bad");
        headline.add("über");
        headline.add("unter");
        headline.add("high");
        headline.add("low");
        headline.add("rise");
        headline.add("fall");
        Random random = ThreadLocalRandom.current();

        shuffleArray(priority);
        for (int i = 0; i < priority.length; i++) {
            newsDto.setPriority(priority[i]);

        }
        //combination
        List<String> combination = random
                .ints(3 + random.nextInt(3), 0, headline.size())
                .mapToObj(headline::get)
                .collect(Collectors.toList());

        newsDto.setHeadline(combination);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(NewsDiscovery.EXECUTE, newsDto, String.class);
        response.accept(responseEntity.getBody());
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
