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
        return topicRepository.findAllTopics();
    }

    public List<Topic> findTopicsForLesson(String lid){
        return topicRepository.findTopicsForLesson(lid);
    }

    public int deleteTopic(Integer tid) {
        try {
            topicRepository.deleteById(tid);
            return 1;
        } catch (RuntimeException a){
            return 0;
        }
    }

    public Topic updateTopic(Integer tid, Topic updatedTopic){
        return topicRepository.save(updatedTopic);
    }

    public Topic createTopic(String lid, Topic topic){
        return topicRepository.save(topic);
    }

    public Topic findTopicById(Integer tid){
        return topicRepository.findTopicById(tid);
    }

}
