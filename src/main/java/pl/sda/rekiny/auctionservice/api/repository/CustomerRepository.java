package pl.sda.rekiny.auctionservice.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long>{
    Optional<CustomerEntity> findById(Long id);
    Optional<CustomerEntity> findByLogin(String login);
}
