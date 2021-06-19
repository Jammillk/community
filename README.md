## 开源社区项目的学习

## 可能用到的资料
[spring guide](https://spring.io/guides)
[thymeleaf](https://spring.io/guides/gs/serving-web-content/)
[中文社区](https://elasticsearch.cn/explore)
[bootstrap文档](https://v3.bootcss.com/)
[git oauth](https://docs.github.com/en/developers/apps/building-oauth-apps/creating-an-oauth-app)
[mybatis-springboot-starter](https://mybatis.org/spring-boot-starter/mybatis-spring-boot-autoconfigure/)

## 工具
[git](https://git-scm.com/) 
[flyway](https://flywaydb.org/)


## 脚本
```sql
create table USER
(
    ID           INT auto_increment,
    ACCOUNT_ID   VARCHAR(100),
    NAME         VARCHAR(50),
    TOKEN        CHAR(36),
    GMT_CREATE   BIGINT,
    GMT_MODIFIED BIGINT,
    constraint USER_PK
        primary key (ID)
);
```

`mvn -Dmybatis.generator.overwrite=true mybatis-generator:generate`