create database if not exists edu
char set utf8mb4;
use edu;

drop table if exists `edu_course`;

create table `edu_course`
(
    `id`          char(19)    not null comment '课程id',
    `teacher_id`  char(19)    not null comment '课程讲师id',
    `subject_id`  char(19)    not null comment '课程分类id',
    `title`       varchar(50) not null comment '课程标题',
    `price`       decimal(10, 2) unsigned not null default '0.00' comment '课程销售价格，设置为0则可免费观看',
    `lesson_num`  int(10) unsigned not null default '0' comment '总课时',
    `cover`       varchar(255) character set utf8 not null comment '课程封面图片路径',
    `buy_count`   bigint(10) unsigned not null default '0' comment '销售数量',
    `view_count`  bigint(10) unsigned not null default '0' comment '浏览数量',
    `version`     bigint(20) unsigned not null default '1' comment '乐观锁',
    `status`      varchar(10) not null default 'draft' comment '课程状态 draft未发布  normal已发布',
    `is_deleted`  tinyint(3)           default null comment '逻辑删除 1（true）已删除， 0（false）未删除',
    `create_time` datetime    not null default now() comment '创建时间',
    `update_time` datetime on update now() comment '更新时间',
    primary key (`id`),
    key           `idx_title` (`title`),
    key           `idx_subject_id` (`subject_id`),
    key           `idx_teacher_id` (`teacher_id`)
) engine=innodb default charset=utf8mb4 row_format=compact comment='课程基本信息';

insert into `edu_course`
values ('1192252213659774977', '1189389726308478977', '1178214681139539969', 'java基础课程：test',
        0.01, 2, 'https://guli-file-190513.oss-cn-beijing.aliyuncs.com/cover/default.gif', 4, 387, 1, 'normal', 0,
        '2019-11-07 09:27:33', '2019-11-18 13:35:03'),
       ('14', '1189389726308478977', '1101348944971091969', 'xhtml css2 js整站制作教程课程学习', 0.00, 3,
        'http://guli-file.oss-cn-beijing.aliyuncs.com/cover/2019/03/13/d0086eb0-f2dc-45f7-bba1-744d95e5be0f.jpg', 3, 44,
        15, 'normal', 0, '2018-04-02 18:33:34', '2019-11-16 21:21:45'),
       ('15', '1189389726308478977', '1101348944971091969', 'html5入门课程学习', 0.00, 23,
        'http://guli-file.oss-cn-beijing.aliyuncs.com/cover/2019/03/13/22997b8e-3606-4d2e-9b4f-09f48418b6e4.jpg', 0, 51,
        17, 'normal', 0, '2018-04-02 18:34:32', '2019-11-12 10:19:20'),
       ('18', '1189389726308478977', '1178214681139539969', 'java精品课程', 0.01, 20,
        'http://guli-file.oss-cn-beijing.aliyuncs.com/cover/2019/03/06/866e9aca-b530-4f71-a690-72d4a4bfd1e7.jpg', 151,
        737, 6, 'normal', 0, '2018-04-02 21:28:46', '2019-11-18 11:14:52');
