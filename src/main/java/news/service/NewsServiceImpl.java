package news.service;

import news.model.News;
import news.model.NewsDto;
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
            NewsDto dto=new NewsDto();
            dto.setPriority(1);
            dto.setHeadline("upGood");
            Thread thread = new Thread(dto);
            thread.start();
            //ToDo rest template to analyser
            String url = "http://localhost:8085";
            RestTemplate restTemplate = new RestTemplate();
            News object = restTemplate.postForObject(url, dto, News.class);
            System.out.println(dto.getHeadline() +  "       " + "this is a headline");
            return jiringDao.save(object);
        }

    }
}
