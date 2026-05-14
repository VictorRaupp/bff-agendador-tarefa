FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY  target/bff-agendador-tarefa-0.0.1-SNAPSHOT.jar  /app/bff-agendador-tarefa.jar


EXPOSE 8084

CMD ["java", "-jar", "/app/bff-agendador-tarefa.jar"]
