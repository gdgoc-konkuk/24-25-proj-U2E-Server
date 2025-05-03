package Konkuk.U2E.domain.news.repository;

import Konkuk.U2E.domain.news.domain.Climate;
import Konkuk.U2E.domain.news.domain.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClimateRepository extends JpaRepository<Climate, Long> {
    List<Climate> findClimatesByNews(News news);
}
