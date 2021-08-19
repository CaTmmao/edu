create database if not exists edu
char set utf8mb4;
use edu;

drop table if exists `edu_video`;

create table `edu_video`
(
    `id`                  char(19)    not null comment '视频id',
    `course_id`           char(19)    not null comment '课程id',
    `chapter_id`          char(19)    not null comment '章节id',
    `title`               varchar(50) not null comment '视频名称',
    `video_source_id`     varchar(100)         default null comment '云端视频资源',
    `video_original_name` varchar(100)         default null comment '原始文件名称',
    `sort`                int(10) unsigned not null default '0' comment '排序字段',
    `play_count`          bigint(20) unsigned not null default '0' comment '播放次数',
    `is_free`             tinyint(1) unsigned not null default '0' comment '是否可以试听：0收费 1免费',
    `duration`            float       not null default '0' comment '视频时长（秒）',
    `status`              varchar(20) not null default 'empty' comment 'empty未上传 transcoding转码中  normal正常',
    `size`                bigint(20) unsigned not null default '0' comment '视频源文件大小（字节）',
    `version`             bigint(20) unsigned not null default '1' comment '乐观锁',
    `create_time`         datetime    not null default now() comment '创建时间',
    `update_time`         datetime on update now() comment '更新时间',
    primary key (`id`),
    key                   `idx_course_id` (`course_id`),
    key                   `idx_chapter_id` (`chapter_id`)
) engine=innodb default charset=utf8mb4 row_format=compact comment='课程视频';

insert into `edu_video`
values ('1182499307429339137', '18', '32', '第一节', '', '', 0, 0, 0, 0, '', 0, 1, '2019-10-11 11:32:59',
        '2019-10-11 11:57:38'),
       ('1185312444399071234', '14', '1', '12', '', '', 0, 0, 0, 0, 'empty', 0, 1, '2019-10-19 05:51:23',
        '2019-10-19 05:51:33'),
       ('1189434737808990210', '18', '44', '测试', '', '', 1, 0, 0, 0, 'empty', 0, 1, '2019-10-30 14:51:55',
        '2019-10-30 14:51:55'),
       ('1189471423678939138', '18', '1181729226915577857', 'test', '2b887dc9584d4dc68908780ec57cd3b9', '视频', 1, 0, 0,
        0, 'empty', 0, 1, '2019-10-30 17:17:41', '2019-10-30 17:17:41'),
       ('1189476403626409986', '18', '1181729226915577857', '22', '5155c73dc112475cbbddccf4723f7cef', '视频.mp4', 0, 0, 0,
        0, 'empty', 0, 1, '2019-10-30 17:37:29', '2019-10-30 17:37:29'),
       ('1192252824606289921', '1192252213659774977', '1192252428399751169', '第一课时', '756cf06db9cb4f30be85a9758b19c645',
        'eae2b847ef8503b81f5d5593d769dde2.mp4', 0, 0, 0, 0, 'empty', 0, 1, '2019-11-07 09:29:59',
        '2019-11-07 09:29:59'),
       ('1192628092797730818', '1192252213659774977', '1192252428399751169', '第二课时', '2a02d726622f4c7089d44cb993c531e1',
        'eae2b847ef8503b81f5d5593d769dde2.mp4', 0, 0, 1, 0, 'empty', 0, 1, '2019-11-08 10:21:10',
        '2019-11-08 10:21:22'),
       ('1192632495013380097', '1192252213659774977', '1192252428399751169', '第三课时', '4e560c892fdf4fa2b42e0671aa42fa9d',
        'eae2b847ef8503b81f5d5593d769dde2.mp4', 0, 0, 1, 0, 'empty', 0, 1, '2019-11-08 10:38:40',
        '2019-11-08 10:38:40'),
       ('1194117638832111617', '1192252213659774977', '1192252428399751169', '第四课时', '4e560c892fdf4fa2b42e0671aa42fa9d',
        'eae2b847ef8503b81f5d5593d769dde2.mp4', 0, 0, 0, 0, 'empty', 0, 1, '2019-11-12 13:00:05',
        '2019-11-12 13:00:05'),
       ('1196263770832023554', '1192252213659774977', '1192252428399751169', '第五课时', '27d21158b0834cb5a8d50710937de330',
        'eae2b847ef8503b81f5d5593d769dde2.mp4', 5, 0, 0, 0, 'empty', 0, 1, '2019-11-18 11:08:03',
        '2019-11-18 11:08:03'),
       ('17', '18', '15', '第一节：java简介', '196116a6fee742e1ba9f6c18f65bd8c1', '1', 1, 1000, 1, 100, 'draft', 0, 1,
        '2019-01-01 13:08:57', '2019-10-11 11:26:39'),
       ('18', '18', '15', '第二节：表达式和赋值语句', '2d99b08ca0214909899910c9ba042d47', '7 - how do i find time for my ', 2, 999,
        1, 100, 'draft', 0, 1, '2019-01-01 13:09:02', '2019-03-08 03:30:27'),
       ('19', '18', '15', '第三节：string类', '51120d59ddfd424cb5ab08b44fc8b23a', 'eae2b847ef8503b81f5d5593d769dde2.mp4', 3,
        888, 0, 100, 'draft', 0, 1, '2019-01-01 13:09:05', '2019-11-12 12:50:45'),
       ('20', '18', '15', '第四节：程序风格', '2a38988892d84df598752226c50f3fa3', '00-day10总结.avi', 4, 666, 0, 100, 'draft', 0,
        1, '2019-01-01 13:09:05', '2019-10-11 09:20:09');
