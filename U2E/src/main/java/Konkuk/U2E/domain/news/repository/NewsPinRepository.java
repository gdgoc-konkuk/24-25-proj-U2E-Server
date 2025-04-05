package Konkuk.U2E.domain.news.repository;

import Konkuk.U2E.domain.news.domain.NewsPin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsPinRepository extends JpaRepository<NewsPin, Long> {
}
