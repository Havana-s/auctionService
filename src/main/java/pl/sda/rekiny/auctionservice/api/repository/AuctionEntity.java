package pl.sda.rekiny.auctionservice.api.repository;

import lombok.*;

import javax.persistence.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@Builder
//@Table(name = "auctions")
public class AuctionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Double price;
    //todo add auctionOwner and date of adding
}
