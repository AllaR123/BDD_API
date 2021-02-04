package pojo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WebAutomation {

    private String courseTitle;
    private String price;

    public String getCourseTitle() {
        return courseTitle;
    }
    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }
    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }

}
