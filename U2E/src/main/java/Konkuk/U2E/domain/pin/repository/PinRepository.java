package Konkuk.U2E.domain.pin.repository;

import Konkuk.U2E.domain.pin.domain.Pin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PinRepository extends JpaRepository<Pin, Long> {
}
