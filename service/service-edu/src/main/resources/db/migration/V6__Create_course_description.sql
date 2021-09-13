-- 课程简介从课程信息里分离出来的原因可参考阿里的java开发手册：
-- 【强制】varchar 是可变长字符串，不预先分配存储空间，长度不要超过 5000，如果存储长度
-- 大于此值，定义字段类型为 text，独立出来一张表，用主键来对应，避免影响其它字段索引效率。

create
database if not exists edu
char
set utf8mb4;
use edu;

drop table if exists `edu_course_description`;

create table `edu_course_description`
(
    `id`          char(19) not null comment '课程id',
    `description` text comment '课程简介',
    `create_time` datetime not null default now() comment '创建时间',
    `update_time` datetime on update now() comment '更新时间',
    primary key (`id`)
) engine=innodb default charset=utf8mb4 comment='课程简介';

insert into `edu_course_description`
values ('1192252213659774977', '测试', '2019-11-07 09:27:33', '2019-11-13 16:21:28'),
       ('14', '这是很好的课程', '2019-03-13 06:04:43', '2019-03-13 06:05:33'),
       ('15', '介绍', '2019-03-13 06:03:33', '2019-03-13 06:04:22'),
       ('18', '简介', '2019-03-06 18:06:36', '2019-10-30 19:58:36');
