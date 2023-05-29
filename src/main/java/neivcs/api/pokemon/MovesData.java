package neivcs.api.pokemon;

import jakarta.validation.constraints.NotNull;

public record MovesData(
        @NotNull
        Move move1,
        Move move2,
        Move move3,
        Move move4) {
}
