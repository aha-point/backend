## 베이스 이미지 명시 - 이미지 생성시 기반이 되는 이미지 레이어
#FROM bkielczewski/java17

## 추가적으로 필요한 파일들을 다운로드 받는다.
#COPY build/libs/*.jar ahaproject.jar
#COPY ./my.cnf /etc/mysql/my.cnf
#
#RUN mv ahaproject.jar app.jar
#
## 컨테이너 시작시 실행될 명령어를 명시해준다.
#ENTRYPOINT ["java","-jar","app.jar"]

FROM openjdk:17

# Install OpenJDK 17
#RUN apt-get update && apt-get install -y openjdk-17-jdk

# Set the working directory
WORKDIR /app

# Copy the application jar file
COPY build/libs/*.jar app.jar

# Copy the MySQL configuration file
COPY db_mysql/my.cnf /etc/mysql/my.cnf

# Expose port 8080 for the application
EXPOSE 8080

# Start the application
CMD ["java", "-jar", "app.jar"]
