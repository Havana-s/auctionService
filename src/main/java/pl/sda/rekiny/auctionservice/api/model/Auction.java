package pl.sda.rekiny.auctionservice.api.model;

import lombok.*;

import javax.validation.constraints.NotBlank;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Auction {
    private Long id;
    @NotBlank(message = "Proszę podać tytuł aucji")
    private String title;
    @NotBlank(message = "Proszę podać cenę")
    private Double price;

}
