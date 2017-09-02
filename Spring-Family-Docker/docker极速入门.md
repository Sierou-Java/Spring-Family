[toc]
# Docker主要命令
- FROM

```bash
# Usage: FROM [image name]
FROM ubuntu 
```

FROM命令可能是最重要的Dockerfile命令。改命令定义了使用哪个基础镜像启动构建流程。基础镜像可以为任意镜 像。如果基础镜像没有被发现，Docker将试图从Docker image index来查找该镜像。FROM命令必须是Dockerfile的首个命令。

- ADD
 
ADD命令有两个参数，源和目标。它的基本作用是从源系统的文件系统上复制文件到目标容器的文件系统。如果源是一个URL，那该URL的内容将被下载并复制到容器中。
```bash
# Usage: ADD [source directory or URL] [destination directory]
ADD /my_app_folder /my_app_folder 
```

- CMD

和RUN命令相似，CMD可以用于执行特定的命令。和RUN不同的是，这些命令不是在镜像构建的过程中执行的，而是在用镜像构建容器后被调用。

```bash
 Usage 1: CMD application "argument", "argument", ..
CMD "echo" "Hello docker!"
```

- ENTRYPOINT

配置容器启动后执行的命令，并且不可被 docker run 提供的参数覆盖。

每个 Dockerfile 中只能有一个 ENTRYPOINT，当指定多个时，只有最后一个起效。

ENTRYPOINT 帮助你配置一个容器使之可执行化，如果你结合CMD命令和ENTRYPOINT命令，你可以从CMD命令中移除“application”而仅仅保留参数，参数将传递给ENTRYPOINT命令。
```bash
# Usage: ENTRYPOINT application "argument", "argument", ..
# Remember: arguments are optional. They can be provided by CMD
# or during the creation of a container.
ENTRYPOINT echo
# Usage example with CMD:
# Arguments set with CMD can be overridden during *run*
CMD "Hello docker!"
ENTRYPOINT echo
```

- ENV

ENV命令用于设置环境变量。这些变量以”key=value”的形式存在，并可以在容器内被脚本或者程序调用。这个机制给在容器中运行应用带来了极大的便利。
```bash
# Usage: ENV key value
ENV SERVER_WORKS 4
 ```
 
 - EXPOSE
 
EXPOSE用来指定端口，使容器内的应用可以通过端口和外界交互。

```bash
# Usage: EXPOSE [port]
EXPOSE 8080
```

- MAINTAINER

我建议这个命令放在Dockerfile的起始部分，虽然理论上它可以放置于Dockerfile的任意位置。这个命令用于声明作者，并应该放在FROM的后面。

```bash
# Usage: MAINTAINER [name]
MAINTAINER authors_name 
```

- USER

USER命令用于设置运行容器的UID。
```bash
# Usage: USER [UID]
USER 751
```

- VOLUME

VOLUME命令用于让你的容器访问宿主机上的目录。
```bash
# Usage: VOLUME ["/dir_1", "/dir_2" ..]
VOLUME ["/my_files"]
```

- WORKDIR

WORKDIR命令用于设置CMD指明的命令的运行目录。

```bash
# Usage: WORKDIR /path
WORKDIR ~/
```

# docker运行springboot项目
## 创建springboot项目
```java
/**
 * @Author 王洪悦.{javayue@yeah.net}
 * @Create 2017-08-31 下午5:01
 */
@RestController
public class DockerController {

    @RequestMapping(value = "/docker")
    public String docker(){
        return "hello docker!";
    }
}
```
## mvn 打成jar
```maven
mvn package -Dmaven.test.skip=true
```

## 创建Dockerfile
 > jar和Dockerfile必须宰统一文件下
```bash
vim Dockerfile
   FROM java:8
   MAINTAINER sierou
   ADD Spring-Family-Docker-0.0.1-SNAPSHOT.jar app.jar
   EXPOSE 8080
   ENTRYPOINT ["java", "-jar","/app.jar"]
 ```
 
 ```bash
-rw-r--r--  1 wanghongyue  wheel       134  8 31 17:21 Dockerfile
-rw-r--r--  1 wanghongyue  wheel  14448980  8 31 17:21 Spring-Family-Docker-0.0.1-SNAPSHOT.jar
```

## 打包
> "." 为当前路径  wisely/docker为镜像名称
```bash
docker build -t wisely/docker .
```

## 运行
```bash
docker run -d -it -p 8080:8080 wisely/docker
```

ok!