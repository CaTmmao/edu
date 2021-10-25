create database if not exists edu
char set utf8mb4;
use edu;

drop table if exists `edu_chapter`;

create table `edu_chapter`
(
    `id`          char(19)    not null comment '章节id',
    `course_id`   char(19)    not null comment '课程id',
    `title`       varchar(50) not null comment '章节名称',
    `sort`        int(10) unsigned not null default '0' comment '显示排序',
    `create_time` datetime    not null default now() comment '创建时间',
    `update_time` datetime on update now() comment '更新时间',
    primary key (`id`),
    key           `idx_course_id` (`course_id`)
) engine=innodb default charset=utf8mb4 row_format=compact comment='课程章节';

insert into `edu_chapter`
values ('1', '14', '第一章：html', 0, '2019-01-01 12:27:40', '2019-01-01 12:55:30'),
       ('1192252428399751169', '1192252213659774977', '第一章节', 0, '2019-11-07 09:28:25', '2019-11-07 09:28:25'),
       ('1450135716690796546', '15', '第一章节', 0, '2019-11-07 09:28:25', '2019-11-07 09:28:25'),
       ('15', '18', '第一章：java入门', 0, '2019-01-01 12:27:40', '2019-10-09 09:13:19')

