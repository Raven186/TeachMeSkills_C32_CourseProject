# TeachMeSkills_C32_CourseProject
Создать программу обработки платежных документов и предоставления финансовой отчетности.
Доступ в программу должен осуществляться по логину и паролю.
Реализовать двухфакторную аутентификацию с использованием OTP и QR кода, используя приложения Authenticator.

Программа должна получить путь к папке с финансовыми документами, считать информацию из документов и 
составить статистику. 
Документы могут быть трех видов: инвойсы, ордера, чеки. 
Все документы тхт формата. +
Каждый вид документа имеет свою собственную структуру и собственный шаблон названия. 
Примеры документов будут предоставлены. 
Необходимо обрабатывать файлы только за текущий год. 

Сделать техническое документирование программы: solution-диаграмму, диаграмму классов, диаграмму 
последовательности.
Реализовать различные проверки.
Реализовать сохранение логов в отдельный файл.
Желательно сделать разделение логов: для хранения общей информации и для хранения информации об ошибках.

По завершению работы программы все невалидные файлы должны быть перемещены в отдельную папку. 

Финальная статистика должна быть загружена в отдельный файл.  
Файл статистики должен быть загружен в облачное хранилище Amazon S3.
Настройки для работы программы, такие как ключи для S3 и время жизни сессии, должны находиться в файле 
properties.

Статистика:
- суммарный оборот по всем инвойсам 
- суммарный оборот по всем ордерам 
- суммарный оборот по всем чекам 

Критерии приемки
- Работающая программа.
- Чистый и понятный код.
- Соблюдение нейминг конвеншн для пакетов, классов, методов, переменных.
- Javadoc комментарии для сервисов обязательны.
- Комментарии на английском.
    - Заполненный, краткий и ясный ReadMe файл. Файл должен быть заполнен на английском.
    - Весь рабочий код должные находится в ветке master. Количество другие веток не ограничено.
    - Репозиторий не должен содержать ненужных файлов и папок (например, out, target и другие).

Сценарий проверки
1. Запуск программы
2. Программа запрашивает креды -> ввод логина и пароля
3. Программа генерирует QR код -> сканирование код и получение временного пароля для входа в программу (OTP)
4. Программа запрашивает путь к папке -> ввод пути к папке
5. Программа выполняется и результаты работы программы сохраняются в отдельную папку, отчет загружается в 
облачное хранилище

Дополнительная техническая информация по структуре проекта
Сервисы:
- Сервис авторизации.
- Сервис считывания и обработки файлов.

	Пакеты:
		- классы для описания файлов
		- классы для записи логов
		- классы для парсинга файлов
		- классы для описания сессии
		- классы с утилитарной информацией
		- исключения
	

