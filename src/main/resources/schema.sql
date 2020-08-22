--
-- 文本编码：UTF-8
--
pragma foreign_keys = off;
begin transaction;

-- 表：t_attach
drop table if exists t_attach;
create table t_attach
(
    id      integer primary key autoincrement not null,
    name    varchar(100)                      not null,
    type    varchar(50),
    key     varchar(100)                      not null,
    created integer(10)                       not null
);

-- 表：t_comment
drop table if exists t_comment;
create table t_comment
(
    cid     integer primary key autoincrement not null,
    aid     integer     default (0) not null,
    parent  integer(10) default (0),
    author  varchar(200)                      not null,
    mail    varchar(200)                      not null,
    url     varchar(200),
    ip      varchar(64),
    agent   varchar(200),
    content text                              not null,
    type    varchar(16),
    status  varchar(16),
    created integer(10)                       not null
);

-- 表：t_content
drop table if exists t_article;
create table t_article
(
    aid           integer primary key autoincrement not null unique,
    title         varchar(200)                      not null,
    slug          varchar(100)
        constraint idx_u_slug unique,
    content       text,
    author_id     integer(10)                       not null,
    type          varchar(10)                       not null,
    fmt_type      varchar(16)  default ('markdown'),
    category      varchar(200) default (''),
    tag           varchar(200) default (''),
    hits          integer(10)  default (0),
    comment_count integer(10)  default (0),
    allow_comment integer(1)   default (1),
    created       integer(10)                       not null,
    modified      integer(10),
    status        varchar(16)                       not null
);
insert into t_article (aid, title, slug, content, author_id, type, format, tag, category, hits, comment_count, allow_comment, created, modified, status)
values (1, '关于', 'about', '<p style="text-align:center;border:none;margin:0;padding:0;"><img src="/templates/themes/default/static/img/head.png" alt=""></p>
<h1 style="text-align:center;border:none;margin:0;padding:0;">ZAOANGOD</h1>
<h3 style="text-align:center;border:none;margin:0;padding:0;">subtitle</h3>
<h5>这个是我的个人网站，如果你喜欢，那就点赞，给我动力继续写吧</h5>

# 个人信息:
---
* 姓名：zaoangod
* 网名：zaoangod
* 年龄：24
* 生日：1900-7-30
* 居住地：兰州

# 个人信息:
---
* EMAIL: **********@qq.com
* WEIBO: **********
* ZHIHU: **********
* JIANSHU: **********
* QQ: **********
* GITHUB: **********

# 掌握的技能：
---
* 代码
* 做饭

# 其他兴趣:
---
* 语言：英语，日语
* 历史迷，特别二战史，欧洲史，罗马史，日本战国史
* 对社会科学也有些想象

# 格言：
---
```
携来百侣曾游，忆往昔峥嵘岁月稠。
恰同学少年，风华正茂；
书生意气，挥斥方遒。
指点江山，激扬文字，粪土当年万户侯。
曾记否，到中流击水，浪遏飞舟？
```
再一次感谢您花费时间阅读这份 about', 1, 'page', 'markdown', '', '', 0, 0, 1, 1487853610, 1487853610, 'publish');
insert into t_article (aid, title, slug, content, author_id, type, format, tag, category, hits, comment_count, allow_comment, created, modified, status)
values (2, '友情链接', 'links', '## 友情链接

- :lock: [王爵的技术博客]()
- :lock: [cyang.tech]()
- :lock: [Bakumon''s Blog]()

## 链接须知

> 请确定贵站可以稳定运营
> 原创博客优先，技术类博客优先，设计、视觉类博客优先
> 经常过来访问和评论，眼熟的

备注：默认申请友情链接均为内页（当前页面）

## 基本信息

        网站名称：Tale博客
        网站地址：https://tale.biezhi.me

请在当页通过评论来申请友链，其他地方不予回复

暂时先这样，同时欢迎互换友链，这个页面留言即可。 ^_^

还有，我会不定时对无法访问的网址进行清理，请保证自己的链接长期有效。', 1, 'page', 'markdown', '', '', 0, 0, 1, 1487855610, 1487855610, 'publish');
insert into t_article (aid, title, slug, content, author_id, type, format, tag, category, hits, comment_count, allow_comment, created, modified, status)
values (3, '第一篇文章', null, '## Hello  World.

> 第一篇文章总得写点儿什么?...

----------

<!--more-->

```java
public static void main(String[] args){
    System.out.println(\"Hello World.\");
}
```', 1, 'post', 'markdown', '', '默认分类', 0, 0, 1, 1546272000, 1546272000, 'publish');

-- 表：t_log
drop table if exists t_log;
create table t_log
(
    id        integer primary key autoincrement unique not null,
    title     varchar(100)                             not null,
    data      text,
    author_id integer(10)                              not null,
    ip        varchar(20),
    created   integer(10)                              not null
);

-- 表：t_meta
drop table if exists t_meta;
create table t_meta
(
    mid         integer primary key autoincrement unique not null,
    name        varchar(200)                             not null,
    slug        varchar(200),
    type        varchar(32)                              not null,
    description varchar(255),
    sort        integer(20) default (0),
    count       integer(4)  default (0)
);

insert into t_meta (mid, name, type, description)
values (1, '默认分类', 'category', null);

-- 表：t_option
drop table if exists t_option;
create table t_option
(
    name  varchar(100) primary key unique not null,
    value text
);

insert into t_option (name, value)
values ('site_title', '博客');

insert into t_option (name, value)
values ('site_subtitle', '网站子标题');

insert into t_option (name, value)
values ('site_url', '');

insert into t_option (name, value)
values ('site_keyword', '博客系统,SparkJava,开发');

insert into t_option (name, value)
values ('site_description', '博客系统,SparkJava,开发');

insert into t_option (name, value)
values ('site_theme', 'default');

insert into t_option (name, value)
values ('site_page_limit', 10);

insert into t_option (name, value)
values ('site_install', 'true');

insert into t_option (name, value)
values ('site_comment_audit', 'true');

-- 表：t_relationship
drop table if exists t_relationship;
create table t_relationship
(
    aid integer(10) not null,
    mid integer(10) not null
);

insert into t_relationship (aid, mid)
values (2, 1);

-- 表：t_user
drop table if exists t_user;
create table t_user
(
    uid         integer primary key unique not null,
    username    varchar(64) unique         not null,
    password    varchar(64)                not null,
    screen_name varchar(100),
    email       varchar(100),
    created     integer(10)                not null,
    logged      integer(10)
);

commit transaction;
pragma foreign_keys = on;