FROM openjdk:17
COPY "./target/EquipoFutbol-1.jar" "app.jar"
EXPOSE 8185
ENTRYPOINT [ "java", "-jar", "app.jar" ]