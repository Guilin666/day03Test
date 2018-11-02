package bwie.example.com.day03test.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class ItemBean {
    @Id(autoincrement = true)
    private Long id;
    private String desc;
    private String image;
    private String title;
    private String data;
    @Generated(hash = 1145199584)
    public ItemBean(Long id, String desc, String image, String title, String data) {
        this.id = id;
        this.desc = desc;
        this.image = image;
        this.title = title;
        this.data = data;
    }
    @Generated(hash = 95333960)
    public ItemBean() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getDesc() {
        return this.desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }
    public String getImage() {
        return this.image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getData() {
        return this.data;
    }
    public void setData(String data) {
        this.data = data;
    }


}
