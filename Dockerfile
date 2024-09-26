FROM openjdk

WORKDIR /src

COPY . /src

RUN /src/main/java/org.example/Main.java

CMD ["java", "Main"]