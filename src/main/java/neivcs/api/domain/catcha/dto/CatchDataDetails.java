package neivcs.api.domain.catcha.dto;

import neivcs.api.domain.catcha.Catch;

import java.time.LocalDateTime;

public record CatchDataDetails(Long id,  Long userId, Long pokemonId, LocalDateTime catchDate) {

}
