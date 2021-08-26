package news.model;

/**
 * Created by Lenovo on 8/26/2021.
 */
public class NewsDto implements Runnable {
    private int priority;
    private String headline;

    public int getPriority() {
        return priority;
    }

    public NewsDto setPriority(int priority) {
        this.priority = priority;
        return this;
    }

    public String getHeadline() {
        return headline;
    }

    public NewsDto setHeadline(String headline) {
        this.headline = headline;
        return this;
    }

    @Override
    public void run() {
        //ToDo priority and headline inja begu
        System.out.println("thread run shod");
    }
}
