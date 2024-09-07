create table user (
    birth_date datetime(6), 
    contact_info_id bigint, 
    created datetime(6), 
    emergency_contact_info_id bigint, 
    id bigint not null, 
    job_info_id bigint, 
    permanent_address_id bigint, 
    present_address_id bigint, 
    updated datetime(6), 
    user_document_id bigint, 
    first_name varchar(255) not null, 
    last_name varchar(255) not null, 
    password varchar(255), 
    username varchar(255) not null, 
    category enum ('CONTRACTUAL','DIRECTOR','EMPLOYEE','INTERN','INVENTORY_MANAGER','SYSTEM_ADMIN'), 
    gender enum ('FEMALE','MALE','Other'), 
    religion enum ('BUDDHISM','CHRISTIANITY','HINDUISM','ISLAM'), 
    primary key (id));

create table task 
(
    task_allowance float(53) not null, 
    task_allowance_currency varchar(3), 
    completed_on datetime(6), 
    created datetime(6), 
    eta datetime(6), 
    id bigint not null, 
    reported_by_id bigint, 
    updated datetime(6), 
    description varchar(255), 
    title varchar(255), 
    primary key (id)
);

create table activity_log (
    created datetime(6), 
    id bigint not null, 
    action varchar(255), 
    description varchar(255), 
    page_name varchar(255), 
    primary key (id)
);

create table address (
    id bigint not null, 
    city varchar(255), 
    district varchar(255), 
    postal_code varchar(255), 
    road varchar(255), 
    thana varchar(255), 
    primary key (id)
);

create table contact_info (
    id bigint not null, 
    permanent_address_id bigint, 
    present_address_id bigint, 
    email varchar(255), 
    mobile_number varchar(255), 
    phone varchar(255), 
    primary key (id)
);

create table designation (
    id bigint not null, 
    title varchar(50) not null, 
    job_description TEXT not null, 
    salary_range varchar(255), 
    primary key (id)
);

create table emergency_contact_info (
    id bigint not null, 
    mobile_number varchar(255), 
    name varchar(255), 
    phone varchar(255), 
    relation enum ('CHILDREN','OTHER','PARENTS','SPOUSE'), 
    primary key (id)
);

create table job_information (
    basic float(53) not null, 
    conveyance_allowance float(53) not null, 
    house_rent float(53) not null, 
    medical_reimbursement float(53) not null, 
    designation_id bigint not null, 
    id bigint not null, 
    joining_date datetime(6) not null, 
    user_id bigint, 
    currency enum ('BDT','US_DOLLAR') not null, 
    primary key (id)
);

create table leave_info (
    from_date datetime(6) not null, 
    id bigint not null, 
    leave_info_id bigint, 
    to_date datetime(6) not null, 
    user_id bigint, 
    description varchar(255), 
    leave_type enum ('CASUAL','SICK') not null, 
    primary key (id)
);

create table product (
    price float(53) not null, 
    quantity integer not null, 
    category_id bigint not null, 
    created datetime(6), 
    id bigint not null, 
    image_id bigint, 
    updated datetime(6), 
    code varchar(255) not null, 
    description TEXT, 
    title varchar(255) not null, 
    currency enum ('BDT','US_DOLLAR') not null, 
    primary key (id));

create table product_category (
    id bigint not null, 
    description varchar(255), 
    title varchar(255) not null, 
    primary key (id));

create table product_category_product (
    product_category_id bigint not null,
    product_id bigint not null, 
    primary key (product_category_id, product_id));

create table product_image (
    id bigint not null, 
    file_name varchar(255), 
    document mediumblob, 
    primary key (id));

create table salary (
    basic float(53) not null, 
    conveyance_allowance float(53) not null, 
    currency tinyint check (currency between 0 and 1), 
    house_rent float(53) not null, 
    medical_reimbursement float(53) not null, 
    id bigint not null, 
    primary key (id));

create table task (
    task_allowance float(53) not null, 
    task_allowance_currency varchar(3), 
    completed_on datetime(6), 
    created datetime(6), 
    eta datetime(6), 
    id bigint not null, 
    reported_by_id bigint, 
    updated datetime(6), 
    description varchar(255), 
    title varchar(255), 
    primary key (id));

create table task_assignee_list (
    assignee_list_id bigint not null, 
    task_id bigint not null);

create table user_document (
    id bigint not null, 
    file_name varchar(255), 
    document mediumblob, 
    primary key (id));

alter table contact_info add constraint UK7hw0bwhohm6whudapdgklhayj unique (permanent_address_id);
alter table contact_info add constraint UKl6rwj8dmocr1uy8jsbtwga6yu unique (present_address_id);
# alter table designation_users add constraint UK3ock3i02iofcocewil7kxxcit unique (users_id);
alter table job_information add constraint UKth9bm9739r6ynf2ttwnktjh5t unique (user_id);
alter table product add constraint UK1obwxotxqdp078249sw6gq4oj unique (image_id);
alter table product_category_product add constraint UK5vefpll86j3volja6kwk4db5y unique (product_id);
alter table task add constraint UKq96k8p89t7rhqwmt49c7tq1to unique (reported_by_id);
alter table task_assignee_list add constraint UKpjbgfu0dpfv7b2adrbgb9yxcr unique (assignee_list_id);
alter table user add constraint UKsb8bbouer5wak8vyiiy4pf2bx unique (username);
alter table user add constraint UKkhxki51ikwrri4qs5wwkg5cgi unique (contact_info_id);
alter table user add constraint UK99q6wfl6hadwal8ixoswh9jmm unique (emergency_contact_info_id);
alter table user add constraint UKkq15ac2twm2ea3x20m9dnjjcw unique (job_info_id);
alter table user add constraint UKhi0a4dh3xhg6u2w80tjaa50ib unique (permanent_address_id);
alter table user add constraint UKt55d1rjrjp439xtxb0bcfpvy8 unique (present_address_id);
alter table user add constraint UKna7bv4hq1c7suyrenin1a3780 unique (user_document_id);
alter table contact_info add constraint FK20jc59041oun6b72bnd5n3lku foreign key (permanent_address_id) references address (id);
alter table contact_info add constraint FKq8cxesgsd8dsighnelfhmcii foreign key (present_address_id) references address (id);
# alter table designation_users add constraint FK75dpg2a9aur4ahp39mcfc50j3 foreign key (users_id) references user (id);
# alter table designation_users add constraint FKtbdnjnj7dova2itpy47ce4jb5 foreign key (designation_id) references designation (id);
alter table job_information add constraint FKr8ys9ifxq41v6abt6ic2ykk62 foreign key (designation_id) references designation (id);
alter table job_information add constraint FKgjui8i4kqucwh40firwda97h0 foreign key (user_id) references user (id);
alter table leave_info add constraint FKk060vhl09mw8j498q2fb2297d foreign key (user_id) references user (id);
alter table leave_info add constraint FKft7jx3nom20qt4wiowb8u7yt1 foreign key (leave_info_id) references user (id);
alter table product add constraint FKb1j1yckp23ss995bgi0kw8xs6 foreign key (image_id) references product_image (id);
alter table product add constraint FK5cypb0k23bovo3rn1a5jqs6j4 foreign key (category_id) references product_category (id);
alter table product_category_product add constraint FKooj7nttwg6qcja3iiejtyt1k3 foreign key (product_id) references product (id);
alter table product_category_product add constraint FK66ul5lfm90ujhahulnnwmootw foreign key (product_category_id) references product_category (id);
alter table task add constraint FKcpubdh0d33t4w7d4u1cj6l0ct foreign key (reported_by_id) references user (id);
alter table task_assignee_list add constraint FKkvmdfic7py15sovdhs36h10yq foreign key (assignee_list_id) references user (id);
alter table task_assignee_list add constraint FK5m060ebq5luwo0lq2d0ah30e foreign key (task_id) references task (id);
alter table user add constraint FKnar1fux068acj0o5p9w14mtgx foreign key (contact_info_id) references contact_info (id);
alter table user add constraint FKgtk90wxhitnygh4s1vtdv5lv9 foreign key (user_document_id) references user_document (id);
alter table user add constraint FKs0e7cfvdhlry2pnec5dvtyc98 foreign key (emergency_contact_info_id) references emergency_contact_info (id);
alter table user add constraint FKf3luvrpomoqeo6kci8q8tcck4 foreign key (job_info_id) references job_information (id);
alter table user add constraint FKoqtbsev9r23hhjn877kigv5ad foreign key (permanent_address_id) references address (id);
alter table user add constraint FKibngudn6wpslds6qcvk7ovtic foreign key (present_address_id) references address (id);