package curegateway_challenge.example.com.curegateway_challenge.model.pojo;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Map;

public class Hospital {

    @SerializedName("application") private String application;
    @SerializedName("entities") private List<Map<String , String>> entities;
    @SerializedName("duration") private int duration;
    @SerializedName("count") private int count;

    /**
     *
     * @return
     *
     * The application
     */
    public String getApplication() {
        return application;
    }

    /**
     *
     * @param application
     * The status
     */
    public void setStatus(String application) {
        this.application = application;
    }

    /**
     *
     * @return
     * The durartion
     */
    public int getDuration() {
        return duration;
    }

    /**
     *
     * @param duration
     * The du
     */
    public void setStatus(int duration) {
        this.duration = duration;
    }


    /**
     *
     * @return
     * The count
     */
    public int getCount() {
        return count;
    }

    /**
     *
     * @param count
     * The du
     */
    public void setCount(int count) {
        this.count = count;
    }

    /**
     *
     * @return
     * The durartion
     */
    public List<Map<String , String>> getEntities() {
        return entities;
    }

    /**
     *
     * @param entities
     * The du
     */
    public void setEntities(List<Map<String , String>> entities) {
        this.entities = entities;
    }
}
