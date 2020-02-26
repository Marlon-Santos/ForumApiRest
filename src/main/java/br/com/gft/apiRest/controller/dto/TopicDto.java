package br.com.gft.apiRest.controller.dto;

import br.com.gft.apiRest.model.Topic;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class TopicDto {
    private Long id;
    private String title;
    private String message;
    private LocalDateTime createDate;
    public TopicDto(Topic topic){
        this.id = topic.getId();
        this.title = topic.getTitle();
        this.createDate = topic.getCreateDate();
        this.message = topic.getMessage();
    }

   public static List<TopicDto> converter (List<Topic> topics) {
        return topics.stream().map(TopicDto::new).collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TopicDto topicDTO = (TopicDto) o;
        return Objects.equals(id, topicDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
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

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }


}
