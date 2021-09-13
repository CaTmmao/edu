create
database if not exists edu
char
set utf8mb4;
use edu;

drop table if exists `edu_teacher`;

create table `edu_teacher`
(
    `id`          char(19)    not null comment '讲师id',
    `name`        varchar(20) not null comment '讲师姓名',
    `intro`       varchar(500) comment '讲师简介',
    `career`      varchar(500)         default null comment '讲师资历,一句话说明讲师',
    `level`       int(10) unsigned not null default 1 comment '头衔 1高级讲师 2首席讲师',
    `avatar`      varchar(255)         default 'https://edu-site.oss-cn-beijing.aliyuncs.com/20212201335364831.jpg' comment '讲师头像',
    `sort`        int(10) unsigned not null default '0' comment '排序',
    `is_deleted`  tinyint(1) unsigned not null default '0' comment '逻辑删除 1（true）已删除， 0（false）未删除',
    `create_time` datetime    not null default now() comment '创建时间',
    `update_time` datetime on update now() comment '更新时间',
    primary key (`id`),
    unique key `uk_name` (`name`)
) engine=innodb default charset=utf8mb4 comment='讲师';

insert into `edu_teacher`(`id`, `name`, `intro`, `career`, `level`, `sort`)
values ('1', '张三',
        '近年主持国家自然科学基金（6项）、江苏省重大科技成果转化项目（5项）、江苏省产学研前瞻性联合研究项目（3项）、省工业科技支撑、省高技术、省自然科学基金等省部级及其企业的主要科研项目40多个，多个项目在企业成功转化，产生了较好的经济、社会和环境效益。积极开展产学研科技合作，并与省内16家企业建立了江苏省研究生工作站，其中6家为江苏省优秀研究生工作站',
        '高级', 1, 0),
       ('1189389726308478977', '晴天', '高级讲师简介', '高级讲师资历', 2, 1),
       ('1189390295668469762', '李刚', '高级讲师简介', '高级讲师', 2, 2),
       ('1189426437876985857', '王二', '高级讲师简介', '高级讲师', 1, 0),
       ('1189426464967995393', '王五', '高级讲师简介', '高级讲师', 1, 0),
       ('1192249914833055746', '李四', '高级讲师简介', '高级讲师', 1, 0),
       ('1192327476087115778', '1222-12-12', '1111', '11', 1, 0),
       ('1195337453429129218', 'test', 'sdfsdf', 'sdfdf', 1, 0);