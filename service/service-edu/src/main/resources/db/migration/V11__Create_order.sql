CREATE TABLE `edu_order`
(
    `id`           char(19)    NOT NULL DEFAULT '',
    `order_no`     varchar(20) NOT NULL DEFAULT '' COMMENT '订单号',
    `course_id`    varchar(19) NOT NULL DEFAULT '' COMMENT '课程id',
    `course_title` varchar(100)         DEFAULT NULL COMMENT '课程名称',
    `course_cover` varchar(255)         DEFAULT NULL COMMENT '课程封面',
    `teacher_name` varchar(20)          DEFAULT NULL COMMENT '讲师名称',
    `user_id`      varchar(19) NOT NULL DEFAULT '' COMMENT '用户id',
    `nickname`     varchar(50)          DEFAULT NULL COMMENT '用户昵称',
    `email`        varchar(30)          DEFAULT NULL COMMENT '用户邮箱',
    `total_fee`    decimal(10, 2)       DEFAULT '0.01' COMMENT '订单金额（分）',
    `pay_type`     tinyint(3)           DEFAULT NULL COMMENT '支付类型（1：微信 2：支付宝）',
    `status`       tinyint(3)           DEFAULT NULL COMMENT '订单状态（0：未支付 1：已支付）',
    `is_deleted`   tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '逻辑删除 1（true）已删除， 0（false）未删除',
    `create_time`  datetime    not null default now() comment '创建时间',
    `update_time`  datetime on update now() comment '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `ux_order_no` (`order_no`),
    KEY            `idx_course_id` (`course_id`),
    KEY            `idx_user_id` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='订单';