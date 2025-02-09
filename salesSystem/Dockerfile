# Use uma imagem base com o JDK do OpenJDK 11
FROM openjdk:11-jdk-slim

# Defina o diretório de trabalho dentro do contêiner
WORKDIR /app

# Copie o arquivo pom.xml e a pasta src para o diretório de trabalho
COPY pom.xml .
COPY src ./src

# Execute o Maven para compilar e empacotar o aplicativo
RUN apt-get update && apt-get install -y maven
RUN mvn clean package

# Copie o arquivo JAR gerado para o diretório de trabalho
COPY target/*.jar app.jar

# Defina o comando de inicialização do contêiner
CMD ["java", "-jar", "app.jar"]
