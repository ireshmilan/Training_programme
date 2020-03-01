INSERT INTO oauth_client_details (client_id, client_secret, web_server_redirect_uri, scope, access_token_validity, refresh_token_validity, resource_ids, authorized_grant_types, additional_information) VALUES ('mobile', '{bcrypt}$2a$10$gPhlXZfms0EpNHX0.HHptOhoFD1AoxSr/yUIdTqA8vtjeP4zi0DDu', 'http://localhost:8080/code', 'READ,WRITE', '3600', '10000', 'inventory,payment', 'authorization_code,password,refresh_token,implicit', '{}');

 INSERT INTO PERMISSION (NAME) VALUES
 ('create_profile'),
 ('read_profile'),
 ('update_profile'),
 ('delete_profile');

 INSERT INTO role (NAME) VALUES
		('ROLE_admin'),('ROLE_operator');

 INSERT INTO PERMISSION_ROLE (PERMISSION_ID, ROLE_ID) VALUES
     (1,1), /*create-> admin */
     (2,1), /* read admin */
     (3,1), /* update admin */
     (4,1), /* delete admin */
     (2,2),  /* read employee */
     (3,2);  /* update employee */
insert into user (id, username,password, email, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked) VALUES ('1', 'admin','{bcrypt}$2a$10$sfLHm13xOIK9CgibptisR.1ZWVavE6nABpdilhwtpttk2TfPGBpMK', 'admin@gmail.com', '1', '1', '1', '1');
 insert into  user (id, username,password, email, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked) VALUES ('2', 'employee', '{bcrypt}$2a$10$r8XspgC5ViSk3o8V8c5UeefqnNvSmvnjwLy.sqhxuLdhiYq1lhF9C','employee@gmail.com', '1', '1', '1', '1');

INSERT INTO ROLE_USER (ROLE_ID, USER_ID)
    VALUES
    (1, 1) /* admin */,
    (2, 2) /* employee */ ;

    //if you run your application 2nd time ,you need to change data.sql to data.txt//