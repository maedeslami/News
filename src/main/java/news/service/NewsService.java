package news.service;

import news.model.News;
import org.springframework.http.ResponseEntity;

/**
 * Created by Lenovo on 8/25/2021.
 */
public interface NewsService {
        ResponseEntity<String> sendmockNews() throws InterruptedException;
}
