# 基础 docker 镜像 
FROM java:8
# 维护者信息
MAINTAINER Pan
# 挂载目录
VOLUME /tmp
# 添加 Jar 到容器并更名为 app.jar,如果jar与Dockerfile同级则直接写jar名字
ADD target/pan-0.0.1-SNAPSHOT.jar pan.jar
# 启动参数配置
# 在启动应用配置时配置 -Djara.security.egd=file:/dev/./urandom 
# 可以一定程度是哪个加快应用启动速度
ENTRYPOINT ["java","-jar","/pan.jar"]
# 镜像暴露端口
EXPOSE 9991
EXPOSE 9999