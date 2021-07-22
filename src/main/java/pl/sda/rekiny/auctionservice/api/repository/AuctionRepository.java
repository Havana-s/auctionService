package pl.sda.rekiny.auctionservice.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuctionRepository extends JpaRepository<AuctionEntity,Long> {
    List<AuctionEntity> findAllByTitle(String title);
    List<AuctionEntity> findAllByPriceBetween(Double min, Double max);

}
