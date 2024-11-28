create table good_message (
        id bigint not null,
        text varchar(255)  not null,
        author_id bigint,
        primary key (id)
) engine=InnoDB;
create table hibernate_sequence (next_val bigint
) engine=InnoDB;

insert into hibernate_sequence values ( 1 );
create table received (user_id bigint not null, message_id bigint not null) engine=InnoDB;
create table user_role (user_id bigint not null, roles varchar(255)) engine=InnoDB;

create table usr (id bigint not null,
active bit not null, password varchar(255)  not null,
username varchar(255)  not null,
primary key (id)
) engine=InnoDB;

alter table good_message add constraint message_user_fk foreign key (author_id) references usr (id);
alter table received add constraint received_message_user_fk foreign key (message_id) references good_message (id);
alter table received add constraint received_user_user_fk  foreign key (user_id) references usr (id);
alter table user_role add constraint user_role_user_fk foreign key (user_id) references usr (id);
