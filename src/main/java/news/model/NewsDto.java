package news.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Lenovo on 8/26/2021.
 */
public class NewsDto implements Serializable {
    private int priority;
    private List<String> headline;

    public List<String> getHeadline() {
        return headline;
    }

    public NewsDto setHeadline(List<String> headline) {
        this.headline = headline;
        return this;
    }

    public int getPriority() {
        return priority;
    }

    public NewsDto setPriority(int priority) {
        this.priority = priority;
        return this;
    }


    public NewsDto(int priority, List<String> headline) {
        this.priority = priority;
        this.headline = headline;
    }

    public NewsDto() {
    }
}
