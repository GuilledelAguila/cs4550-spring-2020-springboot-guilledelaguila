package com.example.myapp.repositories;

import com.example.myapp.models.Widget;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WidgetRepository extends CrudRepository<Widget, Integer> {

    @Query("SELECT widget FROM Widget widget WHERE widget.id=:wid")
    public Widget findWidgetById(
            @Param("wid") Integer wid);

    @Query("SELECT widget FROM Widget widget")
    public List<Widget> findAllWidgets();

    //@Query(nativeQuery = true, value = "SELECT * FROM widgets WHERE topic_id=:tid")
    @Query("SELECT widget from Widget widget WHERE widget.topic=:tid")
    public List<Widget> findWidgetsForTopic(@Param("tid") Integer topicId);
}
