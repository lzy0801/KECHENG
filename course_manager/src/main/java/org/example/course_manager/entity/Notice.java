package org.example.course_manager.entity;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author lzy
 * @since 2024-11-24
 */
public class Notice implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String creatdate;

    private String content;

    private String userid;

    private String title;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getCreatdate() {
        return creatdate;
    }

    public void setCreatdate(String creatdate) {
        this.creatdate = creatdate;
    }
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Notice{" +
            "id=" + id +
            ", creatdate=" + creatdate +
            ", content=" + content +
            ", userid=" + userid +
            ", title=" + title +
        "}";
    }
}
