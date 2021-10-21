Please prepare the following files and place it on the top directory 
```
mysql-connector-java-8.0.26.jar
opentelemetry-javaagent-all.jar
otelcontribcol_linux_amd64
```
Modify the `WAVEFRONT_TOKEN` in docker-compose.yaml.  
Then run
```
docker-compose up -d
```
Access
```
http://localhost:8080/test-tomcat-1.0-SNAPSHOT/hello-servlet
```
