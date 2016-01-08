package college.edu.tomer.servicesandbroadcasts;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ParseMessage {

    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("title")
    @Expose
    private String title;

    /**
     * @return The message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message The message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return The title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

}