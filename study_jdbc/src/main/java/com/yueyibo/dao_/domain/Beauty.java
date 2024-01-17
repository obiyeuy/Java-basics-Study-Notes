package com.yueyibo.dao_.domain;

/**
 * Beauty对象与beauty表对应
 */
public class Beauty {
    private Integer id;
    private String name;
    private String sex;
    private String borndate;
    private String phone;
    private String photo;
    private Integer boyfrieng_id;

    public Beauty(Integer id, String name, String sex, String borndate, String phone, String photo, Integer boyfrieng_id) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.borndate = borndate;
        this.phone = phone;
        this.photo = photo;
        this.boyfrieng_id = boyfrieng_id;
    }

    public Beauty() {  //一定要有无参构造器，反射需要
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBorndate() {
        return borndate;
    }

    public void setBorndate(String borndate) {
        this.borndate = borndate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Integer getBoyfrieng_id() {
        return boyfrieng_id;
    }

    public void setBoyfrieng_id(Integer boyfrieng_id) {
        this.boyfrieng_id = boyfrieng_id;
    }

    @Override
    public String toString() {
        return "Beauty{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", borndate='" + borndate + '\'' +
                ", phone='" + phone + '\'' +
                ", photo='" + photo + '\'' +
                ", boyfrieng_id=" + boyfrieng_id +
                '}';
    }
}
