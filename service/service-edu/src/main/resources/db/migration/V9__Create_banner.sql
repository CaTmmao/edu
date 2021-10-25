create
database if not exists edu char
set utf8mb4;
use edu;

drop table if exists `crm_banner`;
create table `crm_banner`
(
    `id`          char(19) character set utf8mb4 collate utf8mb4_0900_ai_ci not null default '' comment 'id',
    `title`       varchar(20) character set utf8mb4 collate utf8mb4_0900_ai_ci null default '' comment '标题',
    `image_url`   varchar(500) character set utf8mb4 collate utf8mb4_0900_ai_ci not null default '' comment '图片地址',
    `link_url`    varchar(500) character set utf8mb4 collate utf8mb4_0900_ai_ci null default '' comment '链接地址',
    `sort`        int(0) unsigned not null default 0 comment '排序',
    `is_deleted`  tinyint(0) unsigned not null default 0 comment '逻辑删除 1（true）已删除， 0（false）未删除',
    `create_time` datetime not null default now() comment '创建时间',
    `update_time` datetime on update now() comment '更新时间',
    primary key (`id`) using btree,
    unique index `uk_name`(`title`) using btree
) engine = innodb character set = utf8mb4 collate = utf8mb4_0900_ai_ci comment = '首页banner' row_format = dynamic;

insert into `crm_banner`
values ('1194556896025845762', 'test1',
        'https://edu-site.oss-cn-beijing.aliyuncs.com/%E8%BD%AE%E6%92%AD%E5%9B%BE2.jpg', '/course', 1, 0,
        '2019-11-13 18:05:32', '2019-11-18 10:28:22');
insert into `crm_banner`
values ('1194607458461216769', 'test2',
        'https://edu-site.oss-cn-beijing.aliyuncs.com/%E8%BD%AE%E6%92%AD%E5%9B%BE1.jpg', '/teacher', 2, 0,
        '2019-11-13 21:26:27', '2019-11-14 09:12:15');
