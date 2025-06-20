# Runael

Микросервисный проект интернет-магазина. Написан на Java с использованием Spring Boot, WebFlux и R2DBC. Проект находится в активной разработке.

## 📁 Структура проекта

Runael/
├── backend/ # Бэкенд-сервисы (Java)
│ ├── user_service/ # Сервис пользователей
│ ├── product_service/ # Сервис товаров
│ ├── order_service/ # Сервис заказов
│ ├── inventory_service/ # Складской сервис
│ ├── review_service/ # Отзывы и рейтинги
│ ├── notification_service/ # Уведомления
│ └── auth_service/ # Аутентификация и авторизация
├── frontend/ # (планируется) Фронтенд-приложение
├── infra/ # Инфраструктура и базы данных
│ └── db/
├── docker-compose.yml # Конфигурация для Docker Compose
└── README.md


## 🧩 Сервисы

Каждый сервис — отдельное Spring Boot приложение, общающееся через REST.

### 🔹 Пример: `user_service`

- Java 21
- Spring Boot 3.5.0
- Spring WebFlux
- Spring Data R2DBC
- PostgreSQL 16
- Flyway для миграций
- Валидация и обработка ошибок
- Логирование

## 🚀 Как запустить проект

### 📌 Требования

- Java 21
- Docker и Docker Compose
- Git
- Gradle (или `./gradlew` в проекте)

### 🛠️ Шаги запуска

```bash
git clone https://github.com/your-username/runael.git
cd runael
docker-compose up -d               # Запуск PostgreSQL и других сервисов
cd backend/user_service
./gradlew bootRun                  # Запуск сервиса пользователей

🔭 Планы на будущее

Реализация всех микросервисов

Интеграция с фронтендом

Подключение Keycloak (или другого провайдера авторизации)

CI/CD (GitHub Actions)

    Контейнеризация всех сервисов и деплой в Kubernetes

👤 Контакты

Автор: @solithx