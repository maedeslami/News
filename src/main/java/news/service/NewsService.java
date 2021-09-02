package news.service;

import news.model.NewsDto;

import java.util.function.Consumer;

/**
 * Created by Lenovo on 8/25/2021.
 */
public interface NewsService {
    public void executeParallelNews(NewsDto newsDto, Consumer<String> response);

    public void sendMockNews(NewsDto newsDto, Consumer<String> response);

}
