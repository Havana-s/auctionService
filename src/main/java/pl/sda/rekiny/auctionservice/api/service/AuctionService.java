package pl.sda.rekiny.auctionservice.api.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.sda.rekiny.auctionservice.api.model.Auction;
import pl.sda.rekiny.auctionservice.api.repository.AuctionEntity;
import pl.sda.rekiny.auctionservice.api.repository.AuctionRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuctionService {
    private final AuctionRepository repository;

    public void create(Auction auction) {
        if (auction.getTitle().isEmpty() || auction.getPrice().isNaN()) {
            throw new IllegalStateException("Nie podano tytułu lub podano niewłaściwą cenę");
        }
        repository.save(AuctionEntity.builder()
                .title(auction.getTitle())
                .price(auction.getPrice())
                .build());
    }

    //todo add updade and delete auction

    public List<Auction> getAll(){
        return repository.findAll().stream()
                .map(this::toAuction)
                .collect(Collectors
                        .toList());
    }

    public Auction getById(Long id){
        return toAuction(repository.getById(id));
    }

    private Auction toAuction(AuctionEntity entity) {
        return Auction.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .price(entity.getPrice())
                .build();
    }
}