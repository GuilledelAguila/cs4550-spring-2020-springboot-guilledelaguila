package com.example.myapp.models;

public class Widget {
    private String id;
    private String title;
    private String type = "HEADING";
    private String topicId;
    private String name;

    private int order;

    private String text;
    private String url;
    private int hight;
    private int weight;
    private String cssClass;
    private String style;
    private String value;
    private int size = 2;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getTopicId() {
        return topicId;
    }

    public void setTopicId(String topicId) {
        this.topicId = topicId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }


    public Widget(String id, String text, String type) {
        this.id = id;
        this.text = text;
        this.type = type;
    }

    public Widget() {
    }
}