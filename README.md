# T1 Homework1 by Иванов Никита Денисович

Это домашняя работа №1 в [рамках открытых школ T1](https://t1.ru/internship/item/otkrytye-shkoly-ot-holdinga-t1/)

## Как начать

### 1. Настройка базы данных
Вам необходимо проставить значение переменных окружения DATABASE_URL, DATABASE_USERNAME DATABASE_PASSWORD это можно сделать командой:
```bash
export DATABASE_URL=<your database url>
export DATABASE_USERNAME=<your database username>
export DATABASE_PASSWORD=<your database password>
```

### 2. Сборка и запуск приложения
Инструкцию по сборке и запуску приложения:
```bash
mvn clean install
java -jar target/hw1-0.0.1-SNAPSHOT.jar
```

### 3. Endpoint-ы и их описание
С дизайном endpoint-ов и их описанием вы можете перейдя по [ссылке](http://localhost:8080/swagger-ui/index.html) после запуска приложения

---
**Примечание:** Этот проект разработан исключительно в учебных и демонстрационных целях.