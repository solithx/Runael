# Runael

Микросервисный проект интернет-магазина.  
Реализован на Java с использованием Spring Boot, WebFlux и R2DBC.  
Проект находится в активной разработке.

---

## 📁 Структура проекта

```text
Runael/
├── backend/                  # Бэкенд-сервисы (Java)
│   ├── user_service/         # Сервис пользователей
│   ├── product_service/      # Сервис товаров
│   ├── order_service/        # Сервис заказов
│   ├── inventory_service/    # Складской сервис
│   ├── review_service/       # Отзывы и рейтинги
│   ├── notification_service/ # Уведомления
│   └── auth_service/         # Аутентификация и авторизация
├── frontend/                 # (планируется) Фронтенд-приложение
├── infra/                    # Инфраструктура и базы данных
│   └── db/
├── docker-compose.yml        # Конфигурация Docker Compose
└── README.md
```

## 🧩 Сервисы

Каждый сервис — отдельное Spring Boot-приложение. Коммуникация между ними будет осуществляться через REST и/или брокеры сообщений.

### 🔹 Пример: `user_service`

- Java 21  
- Spring Boot 3.5.0  
- Spring WebFlux  
- Spring Data R2DBC  
- PostgreSQL 16  
- Flyway для миграций  
- Валидация и обработка ошибок  
- Логирование

---


🔭 Планы на будущее

    ✅ Реализация всех микросервисов

    🧪 Покрытие тестами

    ⚙️ CI/CD (GitHub Actions)

    ☁️ Деплой через Docker и Kubernetes

    🌐 Веб-интерфейс (React)

👤 Контакты

Автор: @solithx
