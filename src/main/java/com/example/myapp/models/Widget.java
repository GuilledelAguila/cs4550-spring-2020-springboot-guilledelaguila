package com.example.myapp.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.Nullable;

import javax.persistence.*;

@Entity
@Table(name="widgets")
public class Widget {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;
    private String type = "HEADING";
    private String name;

    @ManyToOne
    @JsonIgnore
    private Topic topic;



    private int widgetOrder;

    private String text;
    private String url;
    //private int hight;
    //private int weight;
    private String cssClass;
    private String style;
    private String value;
    private int size;

    public int getWidgetOrder() {
        return widgetOrder;
    }

    public void setWidgetOrder(int widgetOrder) {
        this.widgetOrder = widgetOrder;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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


//    public int getHight() {
//        return hight;
//    }
//
//    public void setHight(int hight) {
//        this.hight = hight;
//    }


    public Widget(Integer id, String text, String type) {
        this.id = id;
        this.text = text;
        this.type = type;
    }

    public Widget() {
    }
}