create database if not exists edu
char set utf8mb4;
use edu;

drop table if exists `edu_course_collect`;

create table `edu_course_collect`
(
    `id`          char(19)   not null comment '收藏id',
    `course_id`   char(19)   not null comment '课程讲师id',
    `member_id`   char(19)   not null default '' comment '课程专业id',
    `is_deleted`  tinyint(3) not null default '0' comment '逻辑删除 1（true）已删除， 0（false）未删除',
    `create_time` datetime   not null default now() comment '创建时间',
    `update_time` datetime on update now() comment '更新时间',
    primary key (`id`)
) engine=innodb default charset=utf8mb4 row_format=compact comment='课程收藏';

insert into `edu_course_collect`
values ('1196269345666019330', '1192252213659774977', '1', 1, '2019-11-18 11:30:12', '2019-11-18 11:30:12');
