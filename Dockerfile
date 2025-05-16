# Usa una imagen oficial válida de Tomcat con JDK 17
FROM tomcat:9.0-jdk17

# Elimina aplicaciones por defecto
RUN rm -rf /usr/local/tomcat/webapps/*

# Copia el WAR generado (ajusta esta ruta si tu .war está en otra carpeta)
COPY dist/PruebaCuatroJSF-1.war /usr/local/tomcat/webapps/ROOT.war

# Expone el puerto 8080
EXPOSE 8080

CMD ["catalina.sh", "run"]
