package news.service;

import news.model.News;
import news.repository.JiringDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

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
            Thread.sleep(5000);
            System.out.println(news.getHeadline() +  "       " + "this is a headline");
            return jiringDao.save(news);
        }

    }
}
