package com.example.myapp.services;

import com.example.myapp.models.Topic;
import com.example.myapp.models.Widget;
import com.example.myapp.repositories.TopicRepository;
import com.example.myapp.repositories.WidgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class WidgetService {
    List<Widget> widgetList = new ArrayList<Widget>();

    @Autowired
    WidgetRepository widgetRepository;

    public Widget createWidget(Integer topicId, Widget newWidget) {
        Topic temp = new Topic();
        temp.setId(topicId);
        newWidget.setTopic(temp);
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

    public int updateWidget(Integer wid, Widget newWidget) {
        Widget currentWidget = widgetRepository.findWidgetById(wid);
        newWidget.setTopic(currentWidget.getTopic());
        int i = currentWidget.getWidgetOrder();
        int maxOrder = widgetRepository.findMaxOrder();


        if(currentWidget.getWidgetOrder() == newWidget.getWidgetOrder()){
            if(newWidget.getStyle() == null){
                newWidget.setStyle("UNORDERED");
                widgetRepository.save(newWidget);
                return 1;
            } else {
                widgetRepository.save(newWidget);
                return 1;
            }

        } else {
            if(currentWidget.getWidgetOrder() > newWidget.getWidgetOrder() && currentWidget.getWidgetOrder() > 0){
                Widget tempWidget = widgetRepository.findWidgetByOrder(i-1);
                tempWidget.setWidgetOrder(i);
                widgetRepository.save(tempWidget);
                widgetRepository.save(newWidget);
                return 1;
            } else if (currentWidget.getWidgetOrder() < newWidget.getWidgetOrder() && currentWidget.getWidgetOrder() < maxOrder){
                Widget tempWidget = widgetRepository.findWidgetByOrder(i+1);
                tempWidget.setWidgetOrder(i);
                widgetRepository.save(tempWidget);
                widgetRepository.save(newWidget);
                return 1;
            } else {
                return 0;
            }
        }
    }
}