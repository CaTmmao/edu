create database if not exists edu
char set utf8mb4;
use edu;

drop table if exists `edu_video`;

create table `edu_video`
(
    `id`                  char(19)    not null comment '视频id',
    `course_id`           char(19)    comment '课程id',
    `chapter_id`          char(19)    not null comment '章节id',
    `title`               varchar(50) not null comment '视频名称',
    `vod_id`     varchar(100)         default null comment '云端视频资源',
    `video_original_name` varchar(100)         default null comment '原始文件名称',
    `sort`                int(10) unsigned not null default '0' comment '排序字段',
    `play_count`          bigint(20) unsigned not null default '0' comment '播放次数',
    `is_free`             tinyint(1) unsigned not null default '0' comment '是否可以试看：0收费 1免费',
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