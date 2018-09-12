## spring-boot-magneto
coding with spring boot
<!-- > dependency `gradle`: >2.12 -->
| magneto | spring-boot | gradle |
| ------- | ----------- | ------ |
| 1.x     | 1.x         | 2.x, 3.x |
| 2.x     | 2.x         | >4.0   |


### how to run: 
- 1.x `gradle build && gradle bootRun`
- 2.x `gradle bootJar && java -jar build/libs/${app}.jar`
- docker `docker/Dockerfile`

`data.sql` for init user db with `admin/admin`; just for demo
### 1.x TODO

- [x] spring security login
- [x] spring security oauth2 github login
- [x] spring security oauth2 server
- [ ] custom oauth2 server
- [ ] RESTFULL?
- [ ] kill thymleaf and use vuejs?
- [ ] chat room for WebSocket support
### 2.x update
- upgrade spring-boot to 2.x
- remove frontend and to be restfull
- add Docker support
- use jetty instead of tomcat

### 2.x TODO
spring-cloud...