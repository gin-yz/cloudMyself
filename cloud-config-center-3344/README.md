### spring配置中心服务端
可以使用很多的容器托管配置，比如redis,git,mysql
将配置存入这些容器中，给配置中心发送http链接后可以get到配置
或者直接在yml文件中配置配置中心，就和普通的配置在yml文件中的配置相关属性一样使用
```url
#访问配置的url
http://localhost:3344/main/config-dev.yml
http://localhost:3344/config/dev/main
```