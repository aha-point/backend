FROM mysql:8

ENV MYSQL_ROOT_PASSWORD uiop9900
ENV MYSQL_ROOT_USER root
ENV MYSQL_DATABASE aha_point

COPY my.cnf /etc/mysql/conf.d/
COPY init.sql /docker-entrypoint-initdb.d/