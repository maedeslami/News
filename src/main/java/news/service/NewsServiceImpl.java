package news.service;

import news.model.News;
import news.repository.JiringDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Random;

/**
 * Created by Lenovo on 8/25/2021.
 */
@Component
public class NewsServiceImpl implements NewsService {
    @Autowired
    JiringDao jiringDao;
    @Override
    public News sendmockNews() throws InterruptedException {
        while (true)

        {
            News news=new News();
            news.setPriority(1);
            news.setHeadline("upGood");
            Thread thread = new Thread(news);
            thread.start();
            //ToDo rest template to analyser
            String url = "http://localhost:8085";
            RestTemplate restTemplate = new RestTemplate();
            News object = restTemplate.postForObject(url, news, News.class);
            System.out.println(news.getHeadline() +  "       " + "this is a headline");
            return jiringDao.save(object);
        }

    }
}
