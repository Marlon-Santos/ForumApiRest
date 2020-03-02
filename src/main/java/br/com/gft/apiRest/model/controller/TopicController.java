package br.com.gft.apiRest.model.controller;

import br.com.gft.apiRest.model.Topic;
import br.com.gft.apiRest.model.controller.dto.TopicDto;
import br.com.gft.apiRest.model.controller.form.TopicForm;
import br.com.gft.apiRest.model.repository.CourseRepository;
import br.com.gft.apiRest.model.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/topic")
public class TopicController {
    @Autowired
    private TopicRepository topicRepository;
    @Autowired
    private CourseRepository courseRepository;

    @GetMapping
    public List<TopicDto> topicView(){
        List<Topic> topics = topicRepository.findAll();
        return TopicDto.converter(topics);
    }
    @PostMapping
    public ResponseEntity<TopicDto> save(@RequestBody @Valid TopicForm topicForm, UriComponentsBuilder uriBuilder){
        Topic topic = topicForm.converter(courseRepository);
        topicRepository.save(topic);
        URI uri = uriBuilder.path("/topic/{id}").buildAndExpand(topic.getId()).toUri();
        return ResponseEntity.created(uri).body(new TopicDto(topic));
    }
}
