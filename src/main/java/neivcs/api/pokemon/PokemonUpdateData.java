package neivcs.api.pokemon;

import jakarta.validation.constraints.NotNull;

public record PokemonUpdateData(

        @NotNull
        Long id,
        String race,
        Type type1,
        Type type2,
        int level,
        MovesData moves){
}
