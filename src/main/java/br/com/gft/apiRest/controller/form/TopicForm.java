package br.com.gft.apiRest.controller.form;

import br.com.gft.apiRest.model.Topic;
import br.com.gft.apiRest.repository.CourseRepository;

import java.util.Objects;

public class TopicForm {
    private String title;
    private String message;
    private String course;


    public Topic converter(CourseRepository courseRepository){
        return new Topic(title,message,courseRepository.findByName(course));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TopicForm topicForm = (TopicForm) o;
        return Objects.equals(title, topicForm.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
