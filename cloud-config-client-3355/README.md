### 配置中心客户端
若github上配置更变，服务端配置会随之更变，但是客户端除非重启或者发送
`curl -X POST "http://localhost:3355/actuator/refresh"` POST请求手动刷新
或者配置MQ或者kafka总线(Bus)