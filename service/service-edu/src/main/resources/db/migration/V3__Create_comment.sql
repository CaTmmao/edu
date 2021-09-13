create database if not exists edu
char set utf8mb4;
use edu;

drop table if exists `edu_comment`;

create table `edu_comment`
(
    `id`          char(19)    not null comment '讲师id',
    `course_id`   varchar(19) not null default '' comment '课程id',
    `teacher_id`  char(19)    not null default '' comment '讲师id',
    `member_id`   varchar(19) not null default '' comment '会员id',
    `nickname`    varchar(50)          default null comment '会员昵称',
    `avatar`      varchar(255)         default null comment '会员头像',
    `content`     varchar(500)         default null comment '评论内容',
    `is_deleted`  tinyint(1) unsigned not null default '0' comment '逻辑删除 1（true）已删除， 0（false）未删除',
    `create_time` datetime    not null default now() comment '创建时间',
    `update_time` datetime on update now() comment '更新时间',
    primary key (`id`),
    key           `course_id` (`course_id`),
    key           `teacher_id` (`teacher_id`),
    key           `member_id` (`member_id`)
) engine=innodb default charset=utf8mb4 comment='评论';

insert into `edu_comment`
values ('1194499162790211585', '1192252213659774977', '1189389726308478977', '1', '小三123',
        'http://thirdwx.qlogo.cn/mmopen/vi_32/dyaiogq83eoj0hhxhgjnotsofss4uzs8x1conecavob8eil115xmjzct4ocicvia7wmeufibkttlqiajeanu2lpg3w/132',
        '课程很好', 0, '2019-11-13 14:16:08', '2019-11-13 14:16:08'),
       ('1194898406466420738', '1192252213659774977', '1189389726308478977', '1', '小三123',
        'http://thirdwx.qlogo.cn/mmopen/vi_32/dyaiogq83eoj0hhxhgjnotsofss4uzs8x1conecavob8eil115xmjzct4ocicvia7wmeufibkttlqiajeanu2lpg3w/132',
        '11', 0, '2019-11-14 16:42:35', '2019-11-14 16:42:35'),
       ('1194898484388200450', '1192252213659774977', '1189389726308478977', '1', '小三123',
        'http://thirdwx.qlogo.cn/mmopen/vi_32/dyaiogq83eoj0hhxhgjnotsofss4uzs8x1conecavob8eil115xmjzct4ocicvia7wmeufibkttlqiajeanu2lpg3w/132',
        '111', 0, '2019-11-14 16:42:53', '2019-11-14 16:42:53'),
       ('1195251020861317122', '1192252213659774977', '1189389726308478977', '1', null, null, '2233', 0,
        '2019-11-15 16:03:45', '2019-11-15 16:03:45'),
       ('1195251382720700418', '1192252213659774977', '1189389726308478977', '1', null, null, '4455', 0,
        '2019-11-15 16:05:11', '2019-11-15 16:05:11'),
       ('1195252819177570306', '1192252213659774977', '1189389726308478977', '1', '小三1231',
        'http://thirdwx.qlogo.cn/mmopen/vi_32/dyaiogq83eoj0hhxhgjnotsofss4uzs8x1conecavob8eil115xmjzct4ocicvia7wmeufibkttlqiajeanu2lpg3w/132',
        '55', 0, '2019-11-15 16:10:53', '2019-11-15 16:10:53'),
       ('1195252899448160258', '1192252213659774977', '1189389726308478977', '1', '小三1231',
        'http://thirdwx.qlogo.cn/mmopen/vi_32/dyaiogq83eoj0hhxhgjnotsofss4uzs8x1conecavob8eil115xmjzct4ocicvia7wmeufibkttlqiajeanu2lpg3w/132',
        '55', 0, '2019-11-15 16:11:13', '2019-11-15 16:11:13'),
       ('1195252920587452417', '1192252213659774977', '1189389726308478977', '1', '小三1231',
        'http://thirdwx.qlogo.cn/mmopen/vi_32/dyaiogq83eoj0hhxhgjnotsofss4uzs8x1conecavob8eil115xmjzct4ocicvia7wmeufibkttlqiajeanu2lpg3w/132',
        '223344', 0, '2019-11-15 16:11:18', '2019-11-15 16:11:18'),
       ('1195262128095559681', '14', '1189389726308478977', '1', '小三1231',
        'http://thirdwx.qlogo.cn/mmopen/vi_32/dyaiogq83eoj0hhxhgjnotsofss4uzs8x1conecavob8eil115xmjzct4ocicvia7wmeufibkttlqiajeanu2lpg3w/132',
        '11', 0, '2019-11-15 16:47:53', '2019-11-15 16:47:53'),
       ('1196264505170767874', '1192252213659774977', '1189389726308478977', '1', '小三1231',
        'http://thirdwx.qlogo.cn/mmopen/vi_32/dyaiogq83eoj0hhxhgjnotsofss4uzs8x1conecavob8eil115xmjzct4ocicvia7wmeufibkttlqiajeanu2lpg3w/132',
        '666666', 0, '2019-11-18 11:10:58', '2019-11-18 11:10:58');
