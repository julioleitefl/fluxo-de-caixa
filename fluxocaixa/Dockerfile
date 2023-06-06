# Use o Java 11 como base
FROM openjdk:11

# Defina a variável de ambiente que aponta para a pasta do aplicativo
ENV APP_HOME=/usr/app/

# Copie o arquivo jar para a pasta do aplicativo
COPY target/fluxocaixa-0.0.1-SNAPSHOT.jar $APP_HOME

# Mude para a pasta do aplicativo
WORKDIR $APP_HOME

# Defina a porta que a aplicação vai escutar
EXPOSE 8080

# Execute o aplicativo
CMD ["java", "-jar", "fluxocaixa-0.0.1-SNAPSHOT.jar"]
