### Nice-Learner
基于SpringBoot2的个性化推荐教育学习网站。

----------


#### 环境配置
 - Java: 1.8
 - Maven: 3.5.0
 - Tomcat: 9.0.0
 - 开发工具: IntellJ IDEA



#### 技术选型
##### 后端技术

<table>
        <tr>
            <th>技术</th>
            <th>名称</th>
            <th>官网</th>
        </tr>
        <tr>
            <th>Spring Framework</th>
            <th>容器</th>
            <th>http://projects.spring.io/spring-framework/</th>
        </tr>
        <tr>
            <th>Apache Shiro</th>
            <th>安全框架</th>
            <th>http://shiro.apache.org/</th>
        </tr>
        <tr>
            <th>Redis</th>
            <th>分布式缓存数据库</th>
            <th>https://redis.io/</th>
        </tr>
        <tr>
            <th>SpringMVC</th>
            <th>MVC框架</th>
            <th>http://docs.spring.io/spring/docs/current/spring-framework-reference/htmlsingle/#mvc</th>
        </tr>
        <tr>
            <th>MyBatis</th>
            <th>ORM框架</th>
            <th>http://www.mybatis.org/mybatis-3/zh/index.html</th>
        </tr>
        <tr>
            <th>Thymeleaf</th>
            <th>模板引擎</th>
            <th>http://www.thymeleaf.org/</th>
        </tr>
        <tr>
            <th>HikariCP</th>
            <th>数据库连接池</th>
            <th>http://brettwooldridge.github.io/HikariCP/</th>       </tr>
        <tr>
            <th>validation</th>
            <th>字段校验</th>
            <th>http://jcp.org/en/jsr/detail?id=303</th>
        </tr>
        <tr>
            <th>Slf4j</th>
            <th>日志组件</th>
            <th>https://www.slf4j.org</th>
        </tr>
        <tr>
            <th>Swagger2</th>
            <th>接口测试框架</th>
            <th>http://swagger.io/</th>
        </tr>
        <tr>
            <th>maven</th>
            <th>项目管理工具</th>
            <th>https://maven.apache.org/</th>
        </tr>
    </table>


#### 遇见的一些问题以及解决办法
* “swagger2.6.0 and 2.7.0 can not work well with springmvc,
> a work around is to rollback to springfox-swagger2 2.5.0 .
* Invalid character found in method name. HTTP method names must be tokens
> 修改Https为Http
* 1022 can't write duplicate key in table #‘sql_XXXXX’
> 外键重名导致，另起一个名字即可解决。（mysql）
* 1215 - Cannot add foreign key constraint
> （1）外键对应的字段数据类型不一致,（2）设置外键时“删除时”设置为“SET NULL”,（3）两张表的存储引擎不一致
* mybatis进行批量插入时，如果数据库内存在相同的数据，则更新不插入，如果没有，则插入数据。
> 解决办法 数据库语句后面加入 ON DUPLICATE KEY UPDATE categoryId = VALUES(categoryId),同时MySQL中设置categoryId索引类型为Unique。约束唯一标识数据库表中的每一条记录，即在单表中不能用每条记录是唯一的（例如身份证就是唯一的），Unique(要求列唯一)和Primary Key(primary key = unique + not null 列唯一)约束均为列或列集合中提供了唯一性的保证，Primary Key是拥有自动定义的Unique约束，但是每个表中可以有多个Unique约束，但是只能有一个Primary Key约束。 
* SpringMVC多参数传参-未解决
#### 拓展


    mysql索引类型Normal,Unique,Full Text区别
    
    Normal:
    表示普通索引，大多数情况下都可以使用
    
    Unique:
    约束唯一标识数据库表中的每一条记录，即在单表中不能用每条记录是唯一的（例如身份证就是唯一的），Unique(要求列唯一)和Primary Key(primary key = unique + not null 列唯一)约束均为列或列集合中提供了唯一性的保证，Primary Key是拥有自动定义的Unique约束，但是每个表中可以有多个Unique约束，但是只能有一个Primary Key约束。 
    mysql中创建Unique约束
    Unique详细请参考：http://www.w3school.com.cn/sql/sql_unique.asp
    
    Full Text:
    表示全文收索，在检索长文本的时候，效果最好，短文本建议使用Index,但是在检索的时候数据量比较大的时候，现将数据放入一个没有全局索引的表中，然后在用Create Index创建的Full Text索引，要比先为一张表建立Full Text然后在写入数据要快的很多 
    详细参考见： http://blog.csdn.net/dyllove98/article/details/9631303/
    
    btree索引和hash索引的区别
    hash 索引结构的特殊性，其检索效率非常高，索引的检索可以一次定位，不像B-Tree 索引需要从根节点到枝节点，最后才能访问到页节点这样多次的IO访问，所以 Hash 索引的查询效率要远高于 B-Tree 索引。 
    可能很多人又有疑问了，既然 Hash 索引的效率要比 B-Tree 高很多，为什么大家不都用 Hash 索引而还要使用 B-Tree 索引呢？任何事物都是有两面性的，Hash 索引也一样，虽然 Hash 索引效率高，但是 Hash 索引本身由于其特殊性也带来了很多限制和弊端，主要有以下这些。
    （1）Hash 索引仅仅能满足”=”,”IN”和”<=>”查询，不能使用范围查询。
    由于 Hash 索引比较的是进行 Hash 运算之后的 Hash 值，所以它只能用于等值的过滤，不能用于基于范围的过滤，因为经过相应的 Hash 算法处理之后的 Hash 值的大小关系，并不能保证和Hash运算前完全一样。
    （2）Hash 索引无法被用来避免数据的排序操作。
    由于 Hash 索引中存放的是经过 Hash 计算之后的 Hash 值，而且Hash值的大小关系并不一定和 Hash 运算前的键值完全一样，所以数据库无法利用索引的数据来避免任何排序运算；
    （3）Hash 索引不能利用部分索引键查询。
    对于组合索引，Hash 索引在计算 Hash 值的时候是组合索引键合并后再一起计算 Hash 值，而不是单独计算 Hash 值，所以通过组合索引的前面一个或几个索引键进行查询的时候，Hash 索引也无法被利用。
    （4）Hash 索引在任何时候都不能避免表扫描。
    前面已经知道，Hash 索引是将索引键通过 Hash 运算之后，将 Hash运算结果的 Hash 值和所对应的行指针信息存放于一个 Hash 表中，由于不同索引键存在相同 Hash 值，所以即使取满足某个 Hash 键值的数据的记录条数，也无法从 Hash 索引中直接完成查询，还是要通过访问表中的实际数据进行相应的比较，并得到相应的结果。
    （5）Hash 索引遇到大量Hash值相等的情况后性能并不一定就会比B-Tree索引高。
    对于选择性比较低的索引键，如果创建 Hash 索引，那么将会存在大量记录指针信息存于同一个 Hash 值相关联。这样要定位某一条记录时就会非常麻烦，会浪费多次表数据的访问，而造成整体性能低下。    
