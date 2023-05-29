package neivcs.api.pokemon;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Moves {

    @Enumerated(EnumType.STRING)
    private Move move1;
    @Enumerated(EnumType.STRING)
    private Move move2;
    @Enumerated(EnumType.STRING)
    private Move move3;
    @Enumerated(EnumType.STRING)
    private Move move4;

    public Moves(MovesData data) {
        this.move1 = data.move1();
        this.move2 = data.move2();
        this.move3 = data.move3();
        this.move4 = data.move4();
    }

    public void updateMoves(MovesData data) {
        if (data.move1() != null) {
            this.move1 = data.move1();
        }
        if (data.move2() != null) {
            this.move2 = data.move2();
        }
        if (data.move3() != null) {
            this.move3 = data.move3();
        }
        if (data.move4() != null) {
            this.move4 = data.move4();
        }
    }
}
