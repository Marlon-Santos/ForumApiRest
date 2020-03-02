package br.com.gft.apiRest.model.controller.form;

import br.com.gft.apiRest.model.Course;
import br.com.gft.apiRest.model.Topic;
import br.com.gft.apiRest.model.repository.CourseRepository;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Objects;

public class TopicForm {
    @NotNull
    @NotEmpty
    @Length(min = 6)
    private String title;
    @NotNull
    @NotEmpty
    @Length(min = 10)
    private String message;
    @NotNull
    @NotEmpty
    @Length(min = 4)
    private String course;

    public Topic converter(CourseRepository courseRepository){
        return new Topic(title,message,courseRepository.findByName(course));
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TopicForm topicForm = (TopicForm) o;
        return Objects.equals(message, topicForm.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message);
    }
}
