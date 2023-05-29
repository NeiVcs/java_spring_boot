create table pokemon(

    id bigint not null auto_increment,
    race varchar(10) not null,
    type1 varchar(10) not null,
    type2 varchar(10),
    level int,
    move1 varchar(10) not null,
    move2 varchar(10),
    move3 varchar(10),
    move4 varchar(10),

    primary key (id)

);