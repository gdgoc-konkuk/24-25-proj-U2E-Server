package Konkuk.U2E.domain.news.repository;

import Konkuk.U2E.domain.news.domain.Climate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClimateRepository extends JpaRepository<Climate, Long> {
}
