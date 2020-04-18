# java知识总结

- 多线程
- netty
- jvm
- 数据结构与算法
- 分布式组件
- 项目
    - 后台管理系统
    - 商城
    - 支付
    - [秒杀项目](https://gitee.com/52itstyle/spring-boot-seckill/wikis/%E7%A7%92%E6%9D%80)小柒2012 
        - 单机秒杀
            - 秒杀一(最low实现) 		错误 超卖 事务提交冲突（记录Id重复）
            - 秒杀二(程序锁)  		错误 超卖1件商品，幻读问题（Lcok锁与事物冲突的问题）
            - 秒杀三(AOP程序锁) 		正常 AOP对整个秒杀方法加锁
            - 秒杀四(数据库悲观锁) 	正常 FOR UPDATE
            - 秒杀五(数据库悲观锁)    正常 UPDATE锁表 UPDATE seckill  SET number=number-1 WHERE seckill_id=? AND number>0
            - 秒杀六(数据库乐观锁)	正常 数据库锁最优实现+版本号version（没用到?）
            - 秒杀柒(进程内队列)      错误 超卖 队列添加正常，提交事务和秒杀一同样问题
            - 秒杀柒(Disruptor队列)   错误 超卖 disruptor使用有问题
        - 分布式秒杀
            - 秒杀一(Rediss分布式锁) 错误 超卖1件商品，幻读问题（Lcok锁与事物冲突的问题）
            - 秒杀二(zookeeper分布式锁) 未成功测试，zookeeper连接问题
            - 秒杀三(Redis分布式队列-订阅监听) 正常
            - 秒杀四(Kafka分布式队列) 正常（类似秒杀三）未成功测试，kafka连接问题

## Commit图例

| 序号 |       emoji        |                           在本项目中的含义                            |       简写标记        |
| ---- | ------------------ | ------------------------------------------------------------------- | -------------------- |
| (0) | :tada:             | 初始化项目                                                           | `:tada:`             |
| (1) | :memo:             | 更新文档，包括但不限于README                                           | `:memo:`             |
| (2) | :bulb:             | 发布新的阅读笔记 <sub>**(注1)**</sub>                                 | `:bulb:`             |
| (3) | :sparkles:         | 增量更新阅读笔记                                                      | `:sparkles:`         |
| (4) | :recycle:          | 重构，主要指修改已有的阅读笔记，极少情形下会修改源码 <sub>**(注2)**</sub> | `:recycle:`          |
| (5) | :pencil2:          | 校对，主要指更正错别字、调整源码分组、修改源码排版等                      | `:pencil2:`          |
| (6) | :white_check_mark: | 发布测试文件                                                         | `:white_check_mark:` |
 
## 脚注
    
Commit信息中的`emoji`参考来源：
    
* [Full Emoji List](https://unicode.org/emoji/charts/full-emoji-list.html)   
   
* [gitmoji](https://gitmoji.carloscuesta.me/)   
     
## 相关链接
    
[Oracle JDK](https://www.oracle.com/technetwork/java/javase/archive-139210.html)    
    
[Open JDK](http://jdk.java.net/archive)    

[LearningJDK](https://github.com/kangjianwei/LearningJDK)
    
  