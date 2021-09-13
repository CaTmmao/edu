create
database if not exists edu
char
set utf8mb4;
use edu;

CREATE TABLE `user`
(
    `id`          char(19)   NOT NULL COMMENT '用户id',
    `openid`      varchar(128)        DEFAULT NULL COMMENT '微信openid',
    `email`       varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT '' COMMENT '邮箱号',
    `password`    varchar(255)        DEFAULT NULL COMMENT '密码',
    `nickname`    varchar(50)         DEFAULT NULL COMMENT '昵称',
    `sex`         tinyint(2) unsigned DEFAULT NULL COMMENT '性别 1 女，2 男',
    `age`         tinyint(3) unsigned DEFAULT NULL COMMENT '年龄',
    `avatar`      varchar(255)        DEFAULT 'https://edu-site.oss-cn-beijing.aliyuncs.com/20212201335364831.jpg' COMMENT '用户头像',
    `sign`        varchar(100)        DEFAULT NULL COMMENT '用户签名',
    `is_disabled` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否禁用 1（true）已禁用，  0（false）未禁用',
    `is_deleted`  tinyint(1) NOT NULL DEFAULT '0' COMMENT '逻辑删除 1（true）已删除， 0（false）未删除',
    `create_time` datetime   not null default now() comment '创建时间',
    `update_time` datetime on update now() comment '更新时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户表';