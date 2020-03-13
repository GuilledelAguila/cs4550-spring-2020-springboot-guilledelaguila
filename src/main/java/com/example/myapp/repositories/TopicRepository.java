package com.example.myapp.repositories;

import com.example.myapp.models.Topic;
import com.example.myapp.models.Widget;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TopicRepository extends CrudRepository <Topic, Integer> {

    @Query("SELECT topic from Topic topic WHERE topic.lessonId=:lid")
    public List<Topic> findTopicsForLesson(@Param("lid") String lid);
}
