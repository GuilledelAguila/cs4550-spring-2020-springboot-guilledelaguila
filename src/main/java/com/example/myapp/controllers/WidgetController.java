package com.example.myapp.controllers;

import com.example.myapp.models.Widget;
import com.example.myapp.services.WidgetService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class WidgetController {

    WidgetService service = new WidgetService();

    @PostMapping("/api/topics/{tid}/widgets")
    public Widget createWidget(
            @PathVariable("tid") String tid,
            @RequestBody Widget newWidget) {
        return service.createWidget(tid, newWidget);
    }

    @DeleteMapping("/api/widgets/{widgetId}")
    public int deleteWidget(
            @PathVariable("widgetId") String wid) {
        return service.deleteWidget(wid);
    }

    @PutMapping("/api/widgets/{widgetId}")
    public int updateWidget(
            @PathVariable("widgetId") String wid,
            @RequestBody Widget updatedWidget) {
        return service.updateWidget(wid, updatedWidget);
    }

    @GetMapping("/api/widgets/{widgetId}")
    public Widget findWidgetById(
            @PathVariable("widgetId") String wid) {
        return service.findWidgetById(wid);
    }

    @GetMapping("/api/widgets")
    public List<Widget> findAllWidgets() {
        return service.findAllWidgets();
    }

    @GetMapping("/api/topics/{tid}/widgets")
    public List<Widget> findWidgetsForTopic(
            @PathVariable("tid") String topicId) {
        return service.findWidgetsForTopic(topicId);
    }


}