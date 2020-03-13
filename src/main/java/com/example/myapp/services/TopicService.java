package com.example.myapp.services;

import com.example.myapp.models.Topic;
import com.example.myapp.models.Widget;
import com.example.myapp.repositories.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicService {
    @Autowired
    TopicRepository topicRepository;

    public List<Topic> findAllTopics(){
        return (List<Topic>)topicRepository.findAll();
    }

    public List<Topic> findTopicsForLesson(String lid){
        return topicRepository.findTopicsForLesson(lid);
    }

    public int deleteTopic(Integer tid) {
        topicRepository.deleteById(tid);
        return 1;
    }

    public Topic createTopic(String lid, Topic topic){
        return topicRepository.save(topic);
    }

}
