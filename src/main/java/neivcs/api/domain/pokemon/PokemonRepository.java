package neivcs.api.domain.pokemon;

import neivcs.api.domain.pokemon.enums.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.time.LocalDateTime;

public interface PokemonRepository extends JpaRepository<Pokemon, Long> {

//    @Query("""
//            select m from Pokemon m
//            where
//            m.type = :type
//            and
//            m.id not in(
//                select c.pokemon.id from catch c
//                where
//                c.catch_date = :catchDate
//            )
//            order by rand()
//            limit 1
//            """)
//    Pokemon choseRandomPokemon(Type type, LocalDateTime catchDate);
}
