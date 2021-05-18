### Nacos配置中心配置的使用
注意，需要创建bootstrap.yml和application.yml
在nacos配置中心创建配置文件名为：
${spring.application.name}-${spring.profile.active}.${spring.cloud.nacos.config.file-extension}
比如本案例nacos-config-client-dev.yaml