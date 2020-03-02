package br.com.gft.apiRest.model.controller.dto;

import br.com.gft.apiRest.model.Topic;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class TopicDto {
    private Long id;
    private String title;
    private String message;
    private LocalDateTime localDateTime;

    public TopicDto(Topic topic) {
        this.id = topic.getId();
        this.title = topic.getTitle();
        this.message = topic.getMessage();
        this.localDateTime = topic.getCreateDate();
    }

    public static List<TopicDto> converter(List<Topic> topics){
        return topics.stream().map(TopicDto::new).collect(Collectors.toList());
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

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TopicDto topicDto = (TopicDto) o;
        return Objects.equals(id, topicDto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
