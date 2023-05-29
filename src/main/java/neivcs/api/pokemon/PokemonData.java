package neivcs.api.pokemon;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PokemonData(

        @NotBlank
        String race,
        @NotNull
        Type type1,
        Type type2,
        @NotNull
        int level,
        @NotNull @Valid
        MovesData moves) {
}
