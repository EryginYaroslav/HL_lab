# Используем официальный Python-образ (версии 3.9-slim)
FROM python:3.9-slim

# Устанавливаем рабочую директорию в /sql-init (это будет том с SQL-скриптами)
WORKDIR /sql-init

# Копируем файл генератора в рабочую директорию
COPY db_init_generator.py .

# Устанавливаем необходимые пакеты, например, jinja2 (если понадобится, здесь используется стандартный Python)
RUN pip install --no-cache-dir jinja2

# По умолчанию запускаем наш генератор
CMD ["python", "db_init_generator.py"]
