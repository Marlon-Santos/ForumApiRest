package br.com.gft.apiRest.model.repository;

import br.com.gft.apiRest.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<Topic, Long> {
}
