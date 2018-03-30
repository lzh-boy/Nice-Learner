### Nice-Learner
基于SpringBoot2的个性化推荐教育学习网站。
#### 基本需求分析
* 最高层管理员
> 对其他信息的查看以及管理
* 审核员
> 对教师的审核以及教师注册资料的审核
* 教师
> 注册，上传视频，查看家长评论，个人资料页
* 用户(家长或学生)
> 注册，选择自己感兴趣的类别，查看推荐视频，评论，收藏。
* 其他用户(未注册)
> 没有权限查看视频
#### 数据库设计
* 用户表
* 角色表
* 教师上传视频表
* 学生或家长评论表
* 课程表  
* 收藏表
* 学生或家长选择感兴趣的类别表
* 分类表
* 用户登陆记录表
* ....
#### 遇见的一些问题以及解决办法
* “swagger2.6.0 and 2.7.0 can not work well with springmvc,
> a work around is to rollback to springfox-swagger2 2.5.0 .
* Invalid character found in method name. HTTP method names must be tokens
> 修改Https为Http
* 1022 can't write duplicate key in table #‘sql_XXXXX’
> 外键重名导致，另起一个名字即可解决。（mysql）
* 1215 - Cannot add foreign key constraint
> （1）外键对应的字段数据类型不一致,（2）设置外键时“删除时”设置为“SET NULL”,（3）两张表的存储引擎不一致
#### 项目目标
* 3/27---3/30 数据库设计，以及对应实体类，数据库映射表完成
* 3/31---4/10 逻辑处理的实现
* 4/11---4/20 前端页面的完善
* 4/21---4/30 前后端进行整合
* 5/01---5/10 项目部署以及发布
#### 项目进度
* 3/27 项目基本架构已实现，Springboot已与Shiro,Swagger2.进行整合.
    
