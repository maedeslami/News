package news;

import news.model.News;
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
            News news=new News();
            news.setPriority(1);
            news.setHeadline("Good news");
            Thread thread = new Thread(news);
            thread.start();
            Thread.sleep(5000);
            System.out.println(news.getHeadline() +  "    " + "this is a headline");

        }

    }

}
