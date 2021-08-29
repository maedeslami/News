package news.controller;

import news.model.News;
import news.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
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
    public ResponseEntity<String> send() throws InterruptedException {
        return newsService.sendmockNews();

    }
}
