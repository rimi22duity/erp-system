
insert into user (id, username, first_name, last_name, password) values ((select next_val from user_seq), 'rimi45', 'Rimi', 'Reza',
                                                                         '$2a$12$TMGmtfDansHZEtuYxamWjuhKCVxxg85pUSeeA7VB5mIzMFrcnzU46');
update user_seq set next_val=2;

insert into designation (id, title, job_description) values((select next_val from designation_seq), 'Software Engineer', 'Develops Software');
update designation_seq set next_val=2;