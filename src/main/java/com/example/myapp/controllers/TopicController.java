package com.example.myapp.controllers;

import com.example.myapp.models.Topic;
import com.example.myapp.models.Widget;
import com.example.myapp.services.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class TopicController {
    @Autowired
    TopicService topicService;

    @GetMapping("api/topics")
    public List<Topic> findAllTopics(){
        return topicService.findAllTopics();
    }

    @GetMapping("/api/lessons/{lid}/topics")
    public List<Topic> findTopicsForLesson(@PathVariable("lid") String lid) {
        return topicService.findTopicsForLesson(lid);
    }


    @DeleteMapping("api/topics/{topicId}")
    public int deleteTopic(
            @PathVariable("topicId") Integer tid) {
        return topicService.deleteTopic(tid);
    }

    @PostMapping("/api/lessons/{lid}/topics")
    public Topic createTopic(
            @PathVariable("lid") String lid,
            @RequestBody Topic newTopic) {
        return topicService.createTopic(lid, newTopic);
    }
}
