# DuutLaunch

<a href="./README.md">Readme in English</a>

Лёгкий лаунчер Minecraft: Java Edition для Android с изумрудным интерфейсом.
Построен на базе [MojoLauncher](https://github.com/MojoLauncher/MojoLauncher), который, в свою очередь, основан на [PojavLauncher](https://github.com/PojavLauncherTeam/PojavLauncher).

> **Статус: в разработке.** Проект переносится на базу MojoLauncher. Всё, что описано ниже в разделах «Цели» и «Дорожная карта», пока планируется и может быть ещё не реализовано.

## Цели

- **Лёгкий APK: до 50 МБ.** Только arm64, без встроенного Java-рантайма (он скачивается при первом запуске), только нужные языки.
- **Производительность** уровня MojoLauncher: рендереры GL4ES и OpenLTW, пресеты под устройство.
- **Простой интерфейс** из пяти разделов:
  - **Главная**: аккаунт, выбор версии и запуск игры
  - **Версии**: установка и управление версиями, Fabric, Forge, NeoForge, Quilt, OptiFine
  - **Скин**: просмотр и смена скина
  - **Настройки**: параметры игры и лаунчера
  - **Modrinth**: поиск и установка модов и модпаков
- **Изумрудная тема** с переключением: тёмная, светлая или системная.

## Дорожная карта

- [ ] Переименование и отдельный `applicationId`
- [ ] Сборка arm64 без встроенного рантайма, замер размера APK
- [ ] Изумрудная тема (тёмная, светлая, системная)
- [ ] Нижняя навигация на 5 разделов
- [ ] Экран скинов
- [ ] Оформление раздела Modrinth

## Сборка

Нужны Android Studio, JDK 17 и доступ в интернет: при сборке подтягиваются зависимости, в том числе с JitPack.

```bash
git clone https://github.com/Duulat2014/DuutLaunch.git
cd DuutLaunch
./gradlew :app_mojo:assembleNoruntimeDebug
```

На Windows используйте `gradlew.bat` вместо `./gradlew`. Готовый APK появится в `app_mojo/build/outputs/apk/`.

## Лицензия

DuutLaunch распространяется под лицензией [GNU LGPLv3](LICENSE), как и MojoLauncher и PojavLauncher. Исходный код изменений остаётся открытым, а авторские права и тексты лицензий исходных проектов сохранены.

## Сторонние компоненты

Проект использует компоненты MojoLauncher и PojavLauncher и их зависимости:

- [MojoLauncher](https://github.com/MojoLauncher/MojoLauncher): GNU LGPLv3
- [PojavLauncher](https://github.com/PojavLauncherTeam/PojavLauncher): GNU LGPLv3
- Android Support Libraries: Apache License 2.0
- [Holy GL4ES](https://github.com/artdeell/gl4es_extra_extra/): MIT
- [OpenJDK](https://github.com/PojavLauncherTeam/openjdk-multiarch-jdk8u): GNU GPLv2 с исключением Classpath
- [LWJGL3](https://github.com/LWJGL/lwjgl3): BSD-3
- [mojoexec](https://github.com/MojoLauncher/mojoexec): MIT
- [Mesa 3D](https://gitlab.freedesktop.org/mesa/mesa): MIT
- [pro-grade](https://github.com/pro-grade/pro-grade): Apache License 2.0
- [OpenAL Soft](https://github.com/kcat/openal-soft/): GNU LGPL
- [Oboe](https://github.com/google/oboe): Apache License 2.0

## Отказ от ответственности

Проект не связан с Mojang Studios, Microsoft, MojoLauncher или PojavLauncher и не одобрен ими. Minecraft является товарным знаком Mojang Studios. Для игры нужна лицензионная копия Minecraft: Java Edition.
