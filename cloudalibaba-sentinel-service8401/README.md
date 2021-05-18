### sentinel熔断降级的使用
主要是sentinel的使用
sentinel是懒加载的，需要发送http请求给微服务，随便发一个http就可以注册到sentinel
sentinel的jar包运行后，直接访问http://localhost:8080就可以进入sentinel的控制台
若要进行持久化，需要配置完application.yml后在nacos中配置管理中注册：
DataID：cloudalibaba-sentinel-service
为json格式
```json
[{
    "resource": "/rateLimit/byUrl",
    "IimitApp": "default",
    "grade": 1,
    "count": 1,
    "strategy": 0,
    "controlBehavior": 0,
    "clusterMode": false
}]
```
> resource：资源名称；
> limitApp：来源应用；
> grade：阈值类型，0表示线程数, 1表示QPS；
> count：单机阈值；
> strategy：流控模式，0表示直接，1表示关联，2表示链路；
> controlBehavior：流控效果，0表示快速失败，1表示Warm Up，2表示排队等待；
> clusterMode：是否集群。
看到了p121之后直接跳到了p137