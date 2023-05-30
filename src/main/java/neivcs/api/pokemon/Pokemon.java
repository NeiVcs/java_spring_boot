package neivcs.api.pokemon;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import neivcs.api.pokemon.dto.PokemonData;
import neivcs.api.pokemon.dto.PokemonUpdateData;
import neivcs.api.pokemon.enums.Type;

@Table(name = "pokemon")
@Entity(name = "Pokemon")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Pokemon {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String race;
    @Enumerated(EnumType.STRING)
    private Type type1;
    @Enumerated(EnumType.STRING)
    private Type type2;
    private int level;

    @Embedded
    private Moves moves;

    public Pokemon(PokemonData data) {
        this.race = data.race();
        this.type1 = data.type1();
        this.type2 = data.type2();
        this.level = data.level();
        this.moves = new Moves(data.moves());
    }

    public void updateData(PokemonUpdateData data) {
        if (data.race() != null) {
            this.race = data.race();
        }
        if (data.type1() != null) {
            this.type1 = data.type1();
        }
        if (data.type2() != null) {
            this.type2 = data.type2();
        }
        if (data.level() != 0) {
            this.level = data.level();
        }
        if (data.moves() != null) {
            this.moves.updateMoves(data.moves());
        }
    }
}
