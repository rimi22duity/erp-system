
insert into user (id, username, first_name, last_name, password) values ((select next_val from user_seq), 'rimi45', 'Rimi', 'Reza',
                                                                         '$2a$12$TMGmtfDansHZEtuYxamWjuhKCVxxg85pUSeeA7VB5mIzMFrcnzU46');
update user_seq set next_val=2;

insert into designation (id, title, job_description) values((select next_val from designation_seq), 'Software Engineer', 'Develops Software');
update designation_seq set next_val=2;

insert into product_category (id, title) values((select next_val from category_seq), "Scientific Instruments");
update category_seq set next_val=2;
insert into product_category (id, title) values((select next_val from category_seq), "Laboratory Chemicals");
update category_seq set next_val=3;
insert into product_category (id, title) values((select next_val from category_seq), "Production R&D Machine");
update category_seq set next_val=4;
insert into product_category (id, title) values((select next_val from category_seq), "Laboratory Equipment");
update category_seq set next_val=5;
insert into product_category (id, title) values((select next_val from category_seq), "Medical Equipment");
update category_seq set next_val=6;
insert into product_category (id, title) values((select next_val from category_seq), "Gas Equipment");
update category_seq set next_val=7;
insert into product_category (id, title) values((select next_val from category_seq), "Reagents");
update category_seq set next_val=8;
insert into product_category (id, title) values((select next_val from category_seq), "Glassware");
update category_seq set next_val=9;
insert into product_category (id, title) values((select next_val from category_seq), "ETP Plant Lab Equipment");
update category_seq set next_val=10;