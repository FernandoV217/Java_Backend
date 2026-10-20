# Etapa 1: Construcción
FROM eclipse-temurin:25 AS build
WORKDIR /app
COPY . .
RUN chmod +x mvnw
# Compila omitiendo los tests porque el pipeline de CI ya los habrá ejecutado
RUN ./mvnw clean package -DskipTests

# Etapa 2: Ejecución
FROM eclipse-temurin:25-jre
WORKDIR /app
# Cambia 'app.jar' por el nombre real de tu archivo generado si no usas el genérico
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]