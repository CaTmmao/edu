## 项目介绍

在线教育全栈项目（前后端分离），使用 Spring Boot + Spring Cloud Alibaba 进行微服务架构，一共有三个代码仓库
- 前台页面（前端）
- [后台管理系统（前端）](https://github.com/CaTmmao/edu-front-admin)
- 后端（也就是该仓库）
<br>

#### maven模块说明
```
├─ common 公共模块
│    ├─ common-database 数据库相关依赖
│    ├─ common-utils 公共类
└─ service
       ├─ service-edu  该项目其余接口
       ├─ service-oss  阿里云对象存储oss服务
       ├─ service-sms  邮箱验证码发送服务
       ├─ service-user 用户登录注册服务
       └─ service-vod  阿里云视频点播服务
```

<br>

#### 使用技术栈
|    框架    |       使用内容          |          官网                  |       备注        |  版本  |
| :-----------: | :----------------------: | :------------------: | :----------: | :----: |
|         java          |             |      https://docs.oracle.com/javase/8/index.html      |             |  8   |
|       Nacos   |  服务注册、发现     |     https://nacos.io/zh-cn/index.html         |           | 2.0.3  |
|       OpenFeign  |   负责微服务之间的调用    |    https://spring.io/projects/spring-cloud-openfeign       |    |  3.0.3 |
|         MySQL         |        数据库       |         https://www.mysql.com/       |  | 8.0.22 |
|         Redis         | 搭配 spring-boot-starter-cache 将数据缓存到redis中  |       https://redis.io/       |  | 6.2.1  |
|      Spring Boot      |        Spring快速开发的脚手架  |     https://spring.io/projects/spring-boot/    |           |   2.4.8     |
|     Mybatis-Plus      |           简化Mybatis开发           |         https://mp.baomidou.com/        |  |      3.4.3  |
|         flyway     |      数据库数据迁移  |       https://flywaydb.org/documentation/             |            |   7.11.3   |
<br>

## 本地运行
### 1.用 docker 运行需要依赖的应用
|  容器        | 宿主端口: 容器内部端口 |  版本  |    用户名: 密码    |
| :----------------: | :--------------------: | :----: | :----------------: |
|       nacos        |       8848: 8848       | 2.0.3  |    nacos: nacos    |
|       mysql        |       3306: 3306       | 8.0.26 |     root: 123456     |
|       redis        |       6379:6379       | latest  |                    |
|       nginx        |       8080:80          | latest  |                    |

<br>

**注**：以下命令均在项目`根目录`运行

(1)启动 `ngxin`
- 第一次本地初始化步骤
```bash
# 根据 nginx 镜像创建容器并启动
# 将容器内的 nginx 配置文件映射到本地，这样即使容器删除了，配置文件也在
# 将容器内 nginx 监听的80端口映射到本地的8080端口，前端在发送请求时，发送一律请求8080端口
sudo docker run --name nginx -d -v `pwd`/nginx.conf:/etc/nginx/nginx.conf:ro -p 8080:80 nginx
```
- 后续启动容器（当容器已创建好的情况下需要启动容器时，就不用像上面一样再创建一个了，直接运行已创建好的容器）
```bash
sudo docker start nginx
```

<br>
 
(2)启动 `mysql`
- 第一次本地初始化步骤
```bash
# 根据指定版本的 mysql 镜像创建容器并启动
# 将容器内存储 mysql 数据的文件夹映射到本地，这样即使容器删除了，数据也不会丢失
sudo docker run -p 3306:3306 --name mysql -v `pwd`/mysql/data:/var/lib/mysql -e MYSQL_ROOT_PASSWORD=123456  -e MYSQL_DATABASE=edu -d mysql:8.0.26
```
- 后续启动容器（当容器已创建好的情况下需要启动容器时，就不用像上面一样再创建一个了，直接运行已创建好的容器）
```bash
sudo docker start mysql
```

<br>
 
(3)启动 `redis`
- 第一次本地初始化步骤
  - 先创建好本地空文件用来存放 redis 中的数据和配置
   ```bash
   sudo mkdir -p redis/data && \
   sudo mkdir redis/conf && \
   sudo touch redis/conf/redis.conf
   ```

  - 根据 redis 镜像创建容器并启动
   ```bash
   # 将容器内存储 redis 数据的文件夹映射到本地，这样即使容器删除了，数据也不会丢失
   # redis-server 是个命令，代表以容器里这个文件里的配置启动redis
   sudo docker run -p 6379:6379 --name redis -d -v `pwd`/redis/data:/data -v `pwd`/redis/conf/redis.conf:/etc/redis/redis.conf redis  redis-server /etc/redis/redis.conf
   ```

- 后续启动容器（当容器已创建好的情况下需要启动容器时，就不用像上面一样再创建一个了，直接运行已创建好的容器）
```bash
# 启动 redis 容器
sudo docker start redis

# 进入 redis 客户端
sudo docker exec -it redis redis-cli
```

<br>
 
(4)启动 `nacos`
- 第一次本地初始化步骤
```bash
docker run --name nacos -e MODE=standalone -p 8848:8848 -d nacos/nacos-server:2.0.3
```
- 后续启动容器（当容器已创建好的情况下需要启动容器时，就不用像上面一样再创建一个了，直接运行已创建好的容器）
```bash
sudo docker start nacos
```
浏览器访问 http://localhost:8848/nacos ，用户名和密码默认为 `nacos`

<br>

### 2.启动服务
该项目使用微服务的形式，将整个后端应用拆分为5个服务，每个服务单独运行（可在 idea 编辑器中打开各服务的入口文件并运行）
<br>
<img src="https://github.com/CaTmmao/edu-backend/blob/master/images/service.png" width="300"/>

- oss<br>
  阿里云oss相关服务（上传图片等接口）<br>
  端口号：9000
- vod<br>
  阿里云视频点播相关服务（上传课程视频等接口）<br>
  端口号：9001<br>
  <br>
  *注*：<br>
  该服务所需依赖中 `artifactId` 为 `aliyun-java-sdk-vod` 和 `aliyun-java-vod-upload` 的两个依赖未开源，该jar包我已经放入`lib`目录中，
  需要在编辑器中需要引入该jar包，如在 `IntelliJ IDEA` 编辑器中选择 `File` > `Project Structure` > `Modules`，
  单击右侧 `Dependencies`，点击 `+` ，点击 `JARs or directories` 引入该jar包，然后使用maven命令把`lib`目录中的jar包加入maven仓库中<br>
  ```bash
  mvn install:install-file -DgroupId=com.aliyun -DartifactId=aliyun-sdk-vod -Dversion=2.15.11 -Dfile=lib/aliyun-java-sdk-vod-2.15.11.jar
  mvn install:install-file -DgroupId=com.aliyun -DartifactId=aliyun-java-vod-upload -Dversion=1.4.14 -Dfile=lib/aliyun-java-vod-upload-1.4.14.jar
  ```
- user<br>
  用户相关服务（用户注册和登录相关接口）<br>
  运行端口号：9002
- sms<br>
  邮件发送服务（注册时获取邮箱验证码等接口）<br>
  端口号：9003
- service<br>
  处理该项目其他的接口<br>
  端口号：9004
  
<br>

### 3.初始化mysql数据库中的数据
```bash
mvn flyway:migrate -pl edu-service
```
