# Проект-презентация по автоматизации для сайта "YouGile"

<img alt="Picture of site" src="/media/mainPage.png">

## :clipboard: Содержание:

- <a href="#tools"> Стек используемых технологий</a>
- <a href="#console"> Запуск автотестов</a>
- <a href="#jenkins"> Сборка в Jenkins</a>
- <a href="#allureReport"> Пример Allure-отчета</a>
- <a href="#allureTestOps"> Интеграция с Allure TestOps</a>
- <a href="#jira"> Интеграция с Jira</a>
- <a href="#tg"> Уведомления в Telegram с использованием бота</a>
- <a href="#video"> Видео примера запуска тестов в Selenoid</a>

<a id="tools"></a>
## :wrench: Стек используемых технологий

<p align="center">
<a href="https://www.w3schools.com/java/"> <img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/java/java-original-wordmark.svg" alt="java" width="40" height="40"/> </a>
<a href="https://selenide.org/"> <img src="https://ru.selenide.org/images/selenide-logo-big.png" alt="selenide" width="80" height="40"/> </a>
<a href="https://junit.org/junit5/"> <img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/junit/junit-original.svg" alt="junit" width="40" height="40"/> </a>
<a href="https://gradle.org/"> <img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/gradle/gradle-original.svg" alt="gradle" width="40" height="40"/> </a>
<a href="https://aerokube.com/selenoid-ui/latest/"> <img src="https://aerokube.com/img/aerokube_logo.svg" alt="selenoid" width="40" height="40"/> </a>
<a href="https://docs.qameta.io/allure-testops/"> <img src="https://plugins.jetbrains.com/files/12513/451639/icon/pluginIcon.svg" alt="allure testOps" width="35" height="35"/> </a>
<a href="https://allurereport.org/"> <img src="https://avatars.githubusercontent.com/u/5879127?s=200&v=4" alt="allure report" width="40" height="40"/> </a>
<a href="https://www.atlassian.com/software/jira"> <img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/jira/jira-original-wordmark.svg" alt="jira" width="40" height="40"/> </a>
<a href="https://www.jenkins.io/"> <img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/jenkins/jenkins-original.svg" alt="jenkins" width="40" height="40"/> </a>
<a href="https://web.telegram.org/"> <img src="https://upload.wikimedia.org/wikipedia/commons/8/83/Telegram_2019_Logo.svg" alt="telegram" width="40" height="40"/> </a>
</p>

Тесты в данном проекте написаны на языке ```Java``` с использованием фреймворка для тестирования ```Selenide```, сборщик - ```Gradle```.

```JUnit 5``` задействован в качестве фреймворка модульного тестирования.
При прогоне тестов для запуска браузеров используется ```Selenoid```.

Для удаленного запуска реализована джоба в <code>Jenkins</code> с формированием Allure-отчета и отправкой результатов в <code>Telegram</code> при помощи бота. Так же реализована интеграция с <code>Allure TestOps</code> и <code>Jira</code>.

Содержание Allure-отчета:
* Шаги теста;
* Скриншот страницы на последнем шаге;
* Page Source;
* Логи браузерной консоли;
* Видео выполнения автотеста.

<a id="checking"></a>
## :male_detective:: Реализованные проверки

Автоматизированные тесты
- ✓ Проверка отображения окна авторизации Team
- - Отображение окна авторизации Team при переходе по кнопке 'DesktopApp' с середины главной страницы
- - Отображение окна авторизации Team при переходе по кнопке 'DesktopApp' с футера
- - Отображение окна авторизации Team при переходе по кнопке 'Скачать приложение' с футера
- ✓ Проверка отображения данных на странице 'О нас'
- - Проверить отображение электронных почт отделов продаж, бухгалтерии, поддержки в футере
- - Проверить отображение информации в Росреестре на странице 'О нас'
- ✓ Калькуляторы цены
- - Проверка работы слайдера Расчёт стоимости
- - [Параметризованный тест] Проверка работы калькулятора Расчёт окупаемости

Ручные тесты
- ✓ Проверка ошибки при некорректных данных для авторизации
- ✓ Успешная авторизация

<a id="console"></a>
## :arrow_forward: Запуск автотестов

### Запуск тестов из терминала

Локальный запуск:
```
gradle clean smoke 
```
Удаленный запуск:
```
clean smoke -Dbrowser=${BROWSER} -DbrowserVersion=${BROWSER_VERSION} -DbrowserSize=${BROWSER_SIZE}  -DbrowserRemoteUrl=${BROWSER_REMOTE_URL}
```

<a id="jenkins"></a>
## <img width="5%" style="vertical-align:middle" title="Jenkins" src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/jenkins/jenkins-original.svg"> </a> Сборка в <a target="_blank" href="https://jenkins.autotests.cloud/view/C24/job/C24-v_artyomenko-HW17-YouGile/"> Jenkins </a>

Для запуска сборки необходимо перейти в раздел ```Build with Parameters```, выбрать необходимые параметры и нажать кнопку ```Build```.
#### :hammer_and_wrench:: Параметры сборки в Jenkins:
- BROWSER (браузер: chrome/firefox, по умолчанию chrome)
- BROWSER_VERSION (версия браузера, по умолчанию 100.0)
- BROWSER_SIZE (размер окна браузера, по умолчанию 1920x1080)
- REMOTE_URL (адрес удаленного сервера для запуска)
<p align="center">
<img title="Jenkins Build" src="media/jenkinsMain.png">
</p>

После выполнения сборки, в блоке ```Build History``` напротив номера сборки появятся значки ```Allure Report``` и ```Allure TestOps```, при клике на которые откроется страница с сформированным html-отчетом и тестовой документацией соответственно.

<a id="allureReport"></a>
## <img width="5%" style="vertical-align:middle" title="Allure Report" src="https://avatars.githubusercontent.com/u/5879127?s=200&v=4"> </a> Пример <a target="_blank" href="https://jenkins.autotests.cloud/view/C24/job/C24-v_artyomenko-HW17-YouGile/6/allure/"> Allure-отчета </a>
### Overview

<p align="center">
<img title="Allure Overview" src="media/allureReport.png">
</p>

<a id="allureTestOps"></a>
## <img width="3%" style="vertical-align:middle" title="Allure TestOps" src="https://plugins.jetbrains.com/files/12513/451639/icon/pluginIcon.svg"> </a> Интеграция с <a target="_blank" href="https://allure.autotests.cloud/project/4085/dashboards"> Allure TestOps </a>

На *Dashboard* в ```Allure TestOps``` видна статистика количества тестов: сколько из них добавлены и проходятся вручную, сколько автоматизированы. Новые тесты, а так же результаты прогона приходят по интеграции при каждом запуске сборки.

<p align="center">
<img title="Allure TestOps DashBoard" src="media/allureTestOps.png">
</p>

### Результат выполнения автотеста в прогоне

<p align="center">
<img title="Test Results in Alure TestOps" src="media/allureTestOpsDetail.png">
</p>

<a id="jira"></a>
## <img width="4%" style="vertical-align:middle" title="Jira" src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/jira/jira-original-wordmark.svg"> </a> Интеграция с <a target="_blank" href="https://jira.autotests.cloud/browse/HOMEWORK-1131"> Jira </a>

Реализована интеграция ```Allure TestOps``` с ```Jira```, в тикете отображается, какие тест-кейсы были написаны в рамках задачи и результат их прогона.

<p align="center">
<img title="Jira Task" src="media/jira.png">
</p>

И наоборот, у тест кейсов отображается ссылка на тикет в Jira, во вкладке ```Test cases```.

<p align="center">
<img title="Allure TestOps test case" src="media/allureTestOpsTestCase.png">
</p>

<a id="tg"></a>
## <img width="4%" style="vertical-align:middle" title="Telegram" src="https://upload.wikimedia.org/wikipedia/commons/8/83/Telegram_2019_Logo.svg"> Уведомления в Telegram с использованием бота

После завершения сборки специальный бот, созданный в ```Telegram```, автоматически обрабатывает и отправляет сообщение с отчетом о прогоне тестов и информацией о нём.

<p align="center">
<img width="50%" title="Telegram Notifications" src="media/tg.png">
</p>

<a id="video"></a>
## <img width="4%" style="vertical-align:middle" title="Selenoid" src="https://aerokube.com/img/aerokube_logo.svg"> Видео примера запуска тестов в Selenoid

В отчетах Allure для каждого теста прикреплен не только скриншот, но и видео прохождения теста.
<p align="center">
  <img title="Selenoid Video" src="media/video.gif">
</p>