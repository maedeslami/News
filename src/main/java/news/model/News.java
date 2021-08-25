package news.model;

import javax.persistence.*;

/**
 * Created by Lenovo on 8/24/2021.
 */
@Entity
public class News implements Runnable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(columnDefinition ="NUMBER")
    private int priority;
    @Column(columnDefinition = "VARCHAR2(20)")
    private String headline;

    public String getHeadline() {
        return headline;
    }

    public News setHeadline(String headline) {
        this.headline = headline;
        return this;
    }

    public int getPriority() {
        return priority;
    }

    public News setPriority(int priority) {
        this.priority = priority;
        return this;
    }


    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //ToDo priority and headline inja begu
        System.out.println("thread run shod");
    }
}
