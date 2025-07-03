package org.example.course_manager.req;

public class CourseReq {
    private String id;
    private String[] courseroom;
    private String[] date1;
    private String[] date2;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String[] getCourseroom() {
        return courseroom;
    }

    public void setCourseroom(String[] courseroom) {
        this.courseroom = courseroom;
    }

    public String[] getDate1() {
        return date1;
    }

    public void setDate1(String[] date1) {
        this.date1 = date1;
    }

    public String[] getDate2() {
        return date2;
    }

    public void setDate2(String[] date2) {
        this.date2 = date2;
    }
}
