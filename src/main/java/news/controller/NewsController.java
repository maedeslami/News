package news.controller;

import news.model.NewsDto;
import news.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Lenovo on 8/25/2021.
 */
@RestController
public class NewsController {
    @Autowired
    NewsService newsService;

    @RequestMapping(value = "/send", method = RequestMethod.POST)
    public String executeRoot() {
        NewsDto newsDto = new NewsDto();
        newsService.executeParallelNews(newsDto, System.out::println);
        return "SENT";
    }
}
