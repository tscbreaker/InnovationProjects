create table student
(	stu_id int primary key,
     password varchar(20) not null,
     name varchar(20) not null,
     sex varchar(5) default '男' check (sex='男' or sex = '女'),
     stu_mail varchar(20) not null,
     academy varchar(20) not null,
);
create table teacher
(	tea_id int primary key,
     password varchar(20) not null,
     name varchar(20) not null,
     sex varchar(5) default '男' check (sex='男' or sex = '女'),
     tea_mail varchar(20) not null,
     academy varchar(20) not null,
);
create table project
(	p_id int primary key,
     p_name varchar(50) not null,
     p_type varchar(20) not null,
     subjecttype varchar(20) not null,
     beaintime datetime,
     endtime datetime,
     p_info varchar(1000),
     header_info varchar(1000),
     member_info varchar(1000),
     meaning varchar(1000),
     method varchar(1000),
     creative varchar(1000),
     pre_result varchar(1000),
     money int,
     material_m int,
     print_m int,
     vehicle_m int,
     publish_m int,
     express_m int,
     p_period varchar(20),
     midtime_info varchar(1000),
     result varchar(1000),
);
create table academyad
(	aca_id int primary key,
     password varchar(20) not null,
     name varchar(20) not null,
     academy varchar(20) not null,
);
create table schoolad
(	sch_id int primary key,
     password varchar(20) not null,
     name varchar(20) not null,
);
create table expert
(	ex_id int primary key,
     password varchar(20) not null,
     name varchar(20) not null,
);
create table stu_project
(	stu_id int not null,
     p_id int not null,
     is_header bit default 0,
     is_confirm bit default 0,
     foreign key(stu_id) references student(stu_id),
     foreign key(p_id) references project(p_id),
);
alter table stu_project add primary key(stu_id,p_id);
create table tea_project
(	tea_id int not null,
     p_id int not null,
     is_header bit default 0,
     is_confirm bit default 0,
     is_mid_confirm bit default 0,
     suggestion varchar(1000),
     is_res_confirm bit default 0,
     res_suggestion varchar(1000),
     suggestion varchar(1000),
     foreign key(tea_id) references teacher(tea_id),
     foreign key(p_id) references project(p_id),
);
alter table tea_project add primary key(tea_id,p_id);
create table ex_project
(	ex_id int not null,
     p_id int not null,
     is_score bit default 0,
     suggestion varchar(1000),
     score int,
     foreign key(ex_id) references expert(ex_id),
     foreign key(p_id) references project(p_id),
);
alter table ex_project add primary key(ex_id,p_id);
create table notice
(
    notice_id int not null,
    special_notice varchar(1000),
    content varchar(1000)
)
