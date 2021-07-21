## Тестовое задание "Мимимиметр"
Это должно быть Spring Boot web приложение. Оно должно собираться с помощью Maven или Gradle. Использование БД для хранения кандидатов и результатов голосования приветствуется, но не обязательно. Полное описание с требованиями на [GitHub](https://github.com/i-novus-llc/job-test/tree/master/mimimimetr)

## Технологии и фреймворки

* Spring 2.5.2 (Boot, MVC, Data, Sercurity, Validation)
* H2 Database (Embedded)
* Thymeleaf
* HTML5, CSS, JavaScript

# Требования для запуска

* JDK 11 или выше
  
  Oracle Java 11 можно найти, перейдя по ссылке [Oracle Java website](http://java.oracle.com). Затем загрузить и установить на вашу систему.
  На ваше усмотрение, вы можете установить **JAVA\_HOME** переменную окружения и добавить *&lt;JDK installation dir>/bin* в ваш **PATH**.
  
* Apache Maven 3.6.3

  Загрузить последнюю версию Apache Maven с [http://maven.apache.org](http://maven.apache.org), и распаковать в мекущую систему.
  На ваше усмотрение, вы можете установить **M2\_HOME** переменную окружения и добавить *&lt;Maven Installation dir>/bin* в ваш **PATH**.

## Запуск приложения 

1. Запустите внутренний API-сервер через Spring Boot.  ```mvn spring-boot:run```
1. Перейти по [http://localhost:8080](http://localhost:8080) для проверки работоспособности. 
