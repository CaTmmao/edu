create
database if not exists edu
char
set utf8mb4;
use edu;

drop table if exists `edu_course`;

create table `edu_course`
(
    `id`          char(19)    not null comment '课程id',
    `teacher_id`  char(19)    not null comment '课程讲师id',
    `category_id` char(19)    not null comment '课程分类id',
    `title`       varchar(50) not null comment '课程标题',
    `price`       decimal(10, 2) unsigned not null default '0.00' comment '课程销售价格，设置为0则可免费观看',
    `lesson_num`  int(10) unsigned not null default '0' comment '总课时',
    `cover`       varchar(255) character set utf8 not null comment '课程封面图片路径',
    `buy_count`   bigint(10) unsigned not null default '0' comment '销售数量',
    `view_count`  bigint(10) unsigned not null default '0' comment '浏览数量',
    `version`     bigint(20) unsigned not null default '1' comment '乐观锁',
    `status`      tinyint(1)  not null default 0 comment '课程状态 1（true）已发布， 0（false）未发布 ',
    `is_deleted`  tinyint(1)           default 0 comment '逻辑删除 1（true）已删除， 0（false）未删除',
    `create_time` datetime    not null default now() comment '创建时间',
    `update_time` datetime on update now() comment '更新时间',
    primary key (`id`),
    key           `idx_title` (`title`),
    key           `idx_category_id` (`category_id`),
    key           `idx_teacher_id` (`teacher_id`)
) engine=innodb default charset=utf8mb4 row_format=compact comment='课程基本信息';

insert into `edu_course` (`id`, `teacher_id`, `category_id`, `title`, `price`, `lesson_num`, `cover`,
                          `buy_count`, `view_count`)
values ('1192252213659774977', '1189389726308478977', '1178214681139539969', 'java基础课程：test',
        0.01, 2, 'https://edu-site.oss-cn-beijing.aliyuncs.com/0.jpeg', 4, 387),
       ('14', '1189389726308478977', '1178214681139539969', 'xhtml css2 js整站制作教程课程学习', 0.00, 3,
        'https://edu-site.oss-cn-beijing.aliyuncs.com/0.jpeg', 3,
        44),
       ('15', '1189389726308478977', '1178214681139539969', 'html5入门课程学习', 0.00, 23,
        'https://edu-site.oss-cn-beijing.aliyuncs.com/0.jpeg', 0,
        51),
       ('18', '1189389726308478977', '1178214681139539969', 'java精品课程', 0.01, 20,
        'https://edu-site.oss-cn-beijing.aliyuncs.com/0.jpeg', 151,
        737);
