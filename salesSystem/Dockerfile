# Usar uma imagem base do OpenJDK
FROM openjdk:17-jdk-alpine

# Configurar o diretório de trabalho no contêiner
WORKDIR /app

# Copiar o arquivo JAR gerado pelo Maven/Gradle para o contêiner
COPY target/your-spring-boot-app.jar app.jar

# Expor a porta em que a aplicação Spring Boot irá rodar
EXPOSE 8080

# Comando para executar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
