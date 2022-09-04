create table event
(
    id            int auto_increment
        primary key,
    removed       date         null,
    description   varchar(255) null,
    enable        bit          null,
    end_date      date         null,
    general_title varchar(255) not null,
    image         longblob     null,
    start_date    date         not null,
    title         varchar(255) null,
    user_creator  int          not null
);

create table event_contacts
(
    id           int auto_increment
        primary key,
    email        varchar(255) null,
    name         varchar(255) not null,
    phone_number varchar(255) null
);

create table event_contacts_connection
(
    id         int not null,
    contact_id int not null,
    primary key (id, contact_id),
    constraint FK7oxlakdklbke20rjw70rgb1ab
        foreign key (contact_id) references event_contacts (id),
    constraint FKshbw7atqsiv3ysvf4tb4gyifh
        foreign key (id) references event (id)
);

create table student_info
(
    id         int auto_increment
        primary key,
    student_id varchar(255) not null,
    constraint UK_2gxpbce50q0gyfo4bcnf1be6m
        unique (student_id)
);

create table telegram_states
(
    id           int auto_increment
        primary key,
    event_status varchar(255) null
);

create table user
(
    id           int auto_increment
        primary key,
    birthday     date         null,
    name         varchar(255) not null,
    patronymic   varchar(255) null,
    surname      varchar(255) null,
    student_info int          null,
    constraint FKimxf8xx2s2q7tjgppbvv40ort
        foreign key (student_info) references student_info (id)
);

create table account
(
    id       int auto_increment
        primary key,
    enable   bit          null,
    password varchar(255) null,
    rule     int          null,
    username varchar(15)  null,
    user_id  int          null,
    constraint UK_csqiqkrbqxe20l8ku84bxoxla
        unique (username),
    constraint UK_gex1lmaqpg0ir5g1f5eftyaa1
        unique (username),
    constraint FK7m8ru44m93ukyb61dfxw0apf6
        foreign key (user_id) references user (id)
);

create table telegram_user
(
    id         int auto_increment
        primary key,
    removed    date         null,
    chat_id    int          not null,
    first_name varchar(255) null,
    last_name  varchar(255) null,
    t_state_id int          not null,
    user_id    int          null,
    constraint UK_8fjrx8y7kifvm13xif72sy5bf
        unique (chat_id),
    constraint UK_9kmkumu0niq0rr3i1mocw9coc
        unique (t_state_id),
    constraint UK_m570n4451q46bis9vgm1iyepr
        unique (chat_id),
    constraint FK8opawg8eftx39oqt77mhww8nv
        foreign key (t_state_id) references telegram_states (id),
    constraint FKfelasxqbpekowffsct1no4qmr
        foreign key (user_id) references user (id)
);

