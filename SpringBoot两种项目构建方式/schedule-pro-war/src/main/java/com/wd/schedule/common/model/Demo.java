package com.wd.schedule.common.model;

public class Demo {

    private Integer id;

    private String title;

    private String name;

    private String weChat;

    /**
     * 构造方法
     * @param id
     * @param title
     * @param name
     * @param weChat
     */
    public Demo(Integer id, String title, String name, String weChat) {
        this.id = id;
        this.title = title;
        this.name = name;
        this.weChat = weChat;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeChat() {
        return weChat;
    }

    public void setWeChat(String weChat) {
        this.weChat = weChat;
    }

    @Override
    public String toString() {
        return "Demo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", name='" + name + '\'' +
                ", weChat='" + weChat + '\'' +
                '}';
    }
}
