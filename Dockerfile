FROM tomcat
COPY web.xml /usr/local/tomcat/conf/
COPY build/HW3.war /usr/local/tomcat/webapps/HW.war