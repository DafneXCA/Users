-----table rol------
create table rol(
                    id integer not null primary key ,
                    name varchar(100) not null
);

create sequence rol_seq as integer increment 1;

------table user-----
create table "user"(
                       id bigint not null primary key ,
                       username varchar(150) not null,
                       password varchar(150) not null,
                       email varchar(150) not null,
                       created_at timestamp
);

create sequence user_seq as integer increment 1;

------table user_rol-----
create table user_rol(
                         id integer not null primary key,
                         active boolean not null,
                         created_at timestamp not null,
                         user_id bigint,
                         rol_id integer
);

create sequence user_rol_seq as integer increment 1;

------table user_detail-----
create table user_detail(
                            id bigint not null primary key ,
                            first_name varchar(100) not null,
                            last_name varchar(100) not null,
                            age integer,
                            birth_day Date,
                            user_id bigint
);

create sequence user_detail_seq as integer increment 1;

alter table user_rol add constraint fk_user_rol_RefUser
    foreign key (user_id) references "user"
        on delete restrict on update restrict ;

alter table user_rol add constraint fk_user_rol_RefRol
    foreign key (rol_id) references rol
        on delete restrict on update restrict ;

alter table user_detail add constraint fk_user_RefUser
    foreign key (user_id) references "user"
        on delete restrict on update restrict ;
