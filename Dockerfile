# Используем официальный образ OpenJDK (Java 21)
FROM openjdk:21-jdk

# Аргумент для указания JAR-файла (используется, например, Maven-плагином)
ARG JAR_FILE=build/libs/*.jar

COPY ${JAR_FILE} app.jar


# Открываем порт 8080
EXPOSE 8080

# Запускаем приложение
ENTRYPOINT ["java", "-jar", "/app.jar"]
