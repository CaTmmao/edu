create database if not exists edu
char set utf8mb4;
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
values ('1104870479077879809', '<p>11</p>', '2019-03-11 06:23:44', '2019-03-11 06:23:44'),
       ('1192252213659774977', '<p>测试</p>', '2019-11-07 09:27:33', '2019-11-13 16:21:28'),
       ('14', '', '2019-03-13 06:04:43', '2019-03-13 06:05:33'),
       ('15', '', '2019-03-13 06:03:33', '2019-03-13 06:04:22'),
       ('18',
        '<p>本套java视频完全针对零基础学员，课堂实录，自发布以来，好评如潮！java视频中注重与学生互动，讲授幽默诙谐、细致入微，覆盖java基础所有核心知识点，同类java视频中也是代码量大、案例多、实战性强的。同时，本java视频教程注重技术原理剖析，深入jdk源码，辅以代码实战贯穿始终，用实践驱动理论，并辅以必要的代码练习。</p>\n<p>------------------------------------</p>\n<p>视频特点：</p>\n<p>通过学习本java视频教程，大家能够真正将java基础知识学以致用、活学活用，构架java编程思想，牢牢掌握\"源码级\"的javase核心技术，并为后续javaweb等技术的学习奠定扎实基础。<br /><br />1.通俗易懂，细致入微：每个知识点高屋建瓴，深入浅出，简洁明了的说明问题<br />2.具实战性：全程真正代码实战，涵盖上百个企业应用案例及练习<br />3.深入：源码分析，更有 java 反射、动态代理的实际应用等<br />4.登录尚硅谷官网，技术讲师免费在线答疑</p>',
        '2019-03-06 18:06:36', '2019-10-30 19:58:36');
