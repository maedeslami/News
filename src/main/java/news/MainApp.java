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
