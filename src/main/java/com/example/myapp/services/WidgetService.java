package com.example.myapp.services;

import com.example.myapp.models.Widget;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class WidgetService {
    List<Widget> widgetList = new ArrayList<Widget>();


    public Widget createWidget(String tid, Widget newWidget) {
        newWidget.setId((new Date()).getTime()+"");
        newWidget.setTopicId(tid);
        newWidget.setOrder(this.widgetList.size());
        widgetList.add(newWidget);
        return newWidget;
    }

    public Widget findWidgetById(String wid) {
        for(Widget w: widgetList) {
            if(w.getId().equals(wid)) {
                return w;
            }
        }
        return null;
    }

    public List<Widget> findAllWidgets() {
        return widgetList;
    }

    public List<Widget> findWidgetsForTopic(String topicId) {
        List<Widget> results = new ArrayList<Widget>();
        for(Widget w: widgetList) {
            if(w.getTopicId().equals(topicId)) {
                results.add(w);
            }
        }
        return results;
    }

    public int deleteWidget(String wid) {
        widgetList = widgetList.stream()
                .filter(w -> !w.getId().equals(wid)).collect(Collectors.toList());
        return 1;
    }

    public int updateWidget(String wid, Widget Widget) {
        for(int i=0; i<widgetList.size(); i++) {
            if(widgetList.get(i).getId().equals(wid)) {
                if(widgetList.get(i).getOrder() == Widget.getOrder()){
                    widgetList.set(i, Widget);
                    return 1;
                } else {
                    if(widgetList.get(i).getOrder() > Widget.getOrder() && widgetList.get(i).getOrder() > 0){
                        Widget tempWidget = widgetList.get(i-1);
                        widgetList.set(i-1, Widget);
                        tempWidget.setOrder(tempWidget.getOrder()+1);
                        widgetList.set(i, tempWidget);
                        return 1;
                    } else if (widgetList.get(i).getOrder() < Widget.getOrder() && widgetList.get(i).getOrder() < widgetList.size()) {
                        Widget tempWidget = widgetList.get(i+1);
                        widgetList.set(i+1, Widget);
                        tempWidget.setOrder(tempWidget.getOrder()-1);
                        widgetList.set(i, tempWidget);
                        return 1;
                    } else {
                        return 0;
                    }

                }

            }
        }
        return 0;
    }
}