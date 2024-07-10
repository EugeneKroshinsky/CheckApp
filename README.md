#### Тестовое задание 1
Для запуска приложения необходимо использовать команду 
java -cp src ./src/main/java/ru/clevertec/check/CheckRunner.java id-quantity discountCard=xxxx balanceDebitCard=xxxx
где:
id - идентификатор товара (см. Таблицу 1)
quantity - количество товара
discountCard=xxxx - название и номер дисконтной карты (см. Таблицу 2)
balanceDebitCard=xxxx - баланс на дебетовой карте

В случае если дисконтная карта отсутствует использовать discountCard=-1

Приемр команды: 
java -cp src ./src/main/java/ru/clevertec/check/CheckRunner.java 1-6 4-5 discountCard=1111 balanceDebitCard = 20.5

В данном задании реализовал сервисы для чтения аргументов командной строки, чтения из файла, подсчета чека и записи в файл.
Также имеются валидации, поэтому при неправильном вводе данных в файл выведется ERROR и название ошибки.

Некоторые вещи не успел реализовать:
-Юнит тесты
-Не заменил double на BigDecimal(), проблемы с форматом некоторых чисел
-Вывод в файл ошибок типа "INTERNAL SERVER ERROR"
-Нет считывания из файла .propertie некоторых значений
