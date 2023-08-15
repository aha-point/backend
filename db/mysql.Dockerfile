FROM mysql:8

ENV MYSQL_DATABASE aha_point
ENV MYSQL_ROOT_USER admin
ENV MYSQL_ROOT_PASSWORD uiop9900
ENV MYSQL_HOST_NAME database-1.cx7pm8zlmjuv.ap-northeast-2.rds.amazonaws.com

EXPOSE 13306

COPY ./my.cnf /etc/mysql/conf.d/
COPY ./init.sql /docker-entrypoint-initdb.d/