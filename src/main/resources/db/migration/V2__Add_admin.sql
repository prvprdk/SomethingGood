insert into usr (id, username, password, active)
    values (1, 'admin', '$2a$10$WoAXWgnpNotux3P3A0slQO.JzZAniMOJD361KGr014h1LBVnJ6lsK', true);
insert into user_role (user_id, roles)
    values (1, 'USER'), (1, 'ADMIN');