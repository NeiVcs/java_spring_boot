package neivcs.api.domain.catcha.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import neivcs.api.domain.catcha.Catch;
import neivcs.api.domain.pokemon.enums.Type;

import java.time.LocalDateTime;

public record CatchData(
        Long id,
        Long userId,

        @NotNull
        Long pokemonId,

        @NotNull
        @Future
        LocalDateTime catchDate
        ){

}
