package neivcs.api.domain.pokemon.dto;

import jakarta.validation.constraints.NotNull;
import neivcs.api.domain.pokemon.enums.Move;

public record MovesData(
        @NotNull
        Move move1,
        Move move2,
        Move move3,
        Move move4) {
}
