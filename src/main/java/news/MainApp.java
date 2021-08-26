package news;

import news.model.News;
import news.model.NewsDto;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by Lenovo on 8/24/2021.
 */

@SpringBootApplication
public class MainApp {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(MainApp.class, args);
        while (true)

        {
            NewsDto dto=new NewsDto();
            dto.setPriority(1);
            dto.setHeadline("Good news");
            Thread thread = new Thread(dto);
            thread.start();
           Thread.sleep(5000);
            System.out.println(dto.getHeadline() +  "    " + "this is a headline");

        }

    }

}
