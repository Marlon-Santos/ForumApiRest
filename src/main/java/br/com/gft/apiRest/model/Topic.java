package br.com.gft.apiRest.model;

import br.com.gft.apiRest.model.enums.TopicStatusEnum;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
public class Topic {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String message;
    private LocalDateTime createDate = LocalDateTime.now();
    @Enumerated(EnumType.STRING)
    private TopicStatusEnum topicStatus = TopicStatusEnum.NAO_RESPONDIDO;
    @ManyToOne
    private User author;
    @ManyToOne
    private Course course;
    @OneToMany(mappedBy = "topic",cascade = CascadeType.ALL)
    private List<Response> responses;

    public Topic() {
    }

    public Topic(String title, String message, Course course) {
        this.title = title;
        this.message = message;
        this.course = course;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public TopicStatusEnum getTopicStatus() {
        return topicStatus;
    }

    public void setTopicStatus(TopicStatusEnum topicStatus) {
        this.topicStatus = topicStatus;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public List<Response> getResponses() {
        return responses;
    }

    public void setResponses(List<Response> responses) {
        this.responses = responses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Topic topic = (Topic) o;
        return Objects.equals(id, topic.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
