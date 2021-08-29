package news.service;

import news.model.NewsDto;
import news.repository.JiringDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

/**
 * Created by Lenovo on 8/25/2021.
 */
@Component
public class NewsServiceImpl implements NewsService {
    @Autowired
    JiringDao jiringDao;

    @Override
    public ResponseEntity<String> sendmockNews() throws InterruptedException {

        NewsDto dto = new NewsDto();
       // dto.setPriority(pr);
        dto.setHeadline("Good");
        // template to analyser
        String url = "http://localhost:8085";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> json = restTemplate.postForEntity(url, dto, String.class);
        System.out.println(dto.getHeadline() + "       " + "this is a headline");
        return json;

    }
}
