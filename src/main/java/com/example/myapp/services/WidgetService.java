package com.example.myapp.services;

import com.example.myapp.models.Widget;
import com.example.myapp.repositories.WidgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WidgetService {
    List<Widget> widgetList = new ArrayList<Widget>();

    @Autowired
    WidgetRepository widgetRepository;


    public Widget createWidget(Widget newWidget) {
        return widgetRepository.save(newWidget);
    }

    public Widget findWidgetById(Integer wid) {
        return widgetRepository.findWidgetById(wid);
    }

    public List<Widget> findAllWidgets() {
        return widgetRepository.findAllWidgets();
    }

    public List<Widget> findWidgetsForTopic(Integer topicId) {
        return widgetRepository.findWidgetsForTopic(topicId);
    }

    public int deleteWidget(Integer wid) {
        widgetRepository.deleteById(wid);
        return 1;
    }

    public int updateWidget(Integer wid, Widget Widget) {
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