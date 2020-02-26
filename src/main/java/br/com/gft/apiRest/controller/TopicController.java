package br.com.gft.apiRest.controller;

import br.com.gft.apiRest.controller.dto.TopicDto;
import br.com.gft.apiRest.controller.form.TopicForm;
import br.com.gft.apiRest.model.Topic;
import br.com.gft.apiRest.repository.CourseRepository;
import br.com.gft.apiRest.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class TopicController {
    @Autowired
    private TopicRepository topicRepository;
    @Autowired
    private CourseRepository courseRepository;

    @GetMapping("/topic")
    public List<TopicDto> home(@Param("name") String courseName) {
        if (courseName == null) {
            return TopicDto.converter(topicRepository.findAll());
        } else {
            return TopicDto.converter(topicRepository.findByCourseName(courseName));
        }
    }

    @GetMapping("/topicc")
    public List<Topic> topic(String courseName) {
        if (courseName == null) {
            return topicRepository.findAll();
        } else {
            return topicRepository.findByCourseName(courseName);
        }
    }
    @PostMapping("/topic")
    public ResponseEntity<TopicDto> save(@RequestBody TopicForm topicForm, UriComponentsBuilder uriBuilder){
        Topic topic = topicForm.converter(courseRepository);
        URI uri = uriBuilder.path("/topic/{id}").buildAndExpand(topic.getId()).toUri();
        topicRepository.save(topic);
        return ResponseEntity.created(uri).body(new TopicDto(topic));
    }

}
