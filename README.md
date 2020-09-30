# TestsAlfaBank

Тестирование хедера главной страницы "https://alfabank.ru/"
Проект реализован на selenid + junit5 + allure

Запуск тестов происходит из командной строки.

Команды для запуска:
* gradle clean alfaTest - запуск всех тестов в классе
* gradle clean searchTest - запуск тестов с тегом "search"
* gradle clean clickTest - запуск тестов с тегом "click"


Есть возможность просмотр allure Отчета со скринами ошибок, с page sourse страниц и логами
* Выполнить загрузку Allure: gradle downloadAllure
* Выполнить команду для формирования отчета: gradle allureServe 