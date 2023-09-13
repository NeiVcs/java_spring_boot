create table catch(

    id bigint not null auto_increment,
    user_id bigint not null,
    pokemon_id bigint not null,
    catch_date datetime not null,

    primary key(id),
    constraint fk_catch_user_id foreign key(user_id) references users(id),
    constraint fk_catch_pokemon_id foreign key(pokemon_id) references pokemon(id)

);
