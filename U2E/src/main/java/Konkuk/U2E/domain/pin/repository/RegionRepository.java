package Konkuk.U2E.domain.pin.repository;

import Konkuk.U2E.domain.pin.domain.Pin;
import Konkuk.U2E.domain.pin.domain.Region;
import org.apache.el.stream.Stream;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RegionRepository extends JpaRepository<Region, Long> {

    Optional<Region> findByName(String region);
}
