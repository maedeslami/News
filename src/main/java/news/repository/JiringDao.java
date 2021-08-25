package news.repository;

/**
 * Created by Lenovo on 8/15/2021.
 */


import news.model.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JiringDao extends JpaRepository<News, Long> {

}
