# Use official Tomcat image
FROM tomcat:9.0-jdk17-temporal

# Remove default webapps
RUN rm -rf /usr/local/tomcat/webapps/*

# Copy your WAR file to ROOT.war (auto-deploys as root)
COPY dist/PruebaCuatroJSF-1.war /usr/local/tomcat/webapps/ROOT.war

# Expose port
EXPOSE 8080

CMD ["catalina.sh", "run"]
