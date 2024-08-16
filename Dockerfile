# 使用 Tomcat 基礎映像
FROM tomcat:9.0-jdk11

# 移除 Tomcat 的預設應用（可選）
RUN rm -rf /usr/local/tomcat/webapps/*

# 將 Maven/Gradle 构建后的 Jar 文件复制到容器中
COPY target/GoodByeLetter-1.0.0.war /usr/local/tomcat/webapps/
# 暴露應用程式的埠號（假設應用程式運行在 8080 埠）
EXPOSE 8080

# 設置容器啟動時執行的命令
CMD ["catalina.sh", "run"]
