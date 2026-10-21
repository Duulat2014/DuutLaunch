# DuutLaunch

<a href="./README_RU.md">Читать на русском</a>

A lightweight Minecraft: Java Edition launcher for Android with an emerald interface.
Built on top of [MojoLauncher](https://github.com/MojoLauncher/MojoLauncher), which is in turn based on [PojavLauncher](https://github.com/PojavLauncherTeam/PojavLauncher).

> **Status: work in progress.** The project is being ported to the MojoLauncher base. Everything listed under "Goals" and "Roadmap" below is planned and may not be implemented yet.

## Goals

- **Small APK: under 50 MB.** arm64 only, no bundled Java runtime (it is downloaded on first launch), only the needed languages.
- **Performance** on par with MojoLauncher: GL4ES and OpenLTW renderers, per-device presets.
- **A simple interface** with five sections:
  - **Home**: account, version selection and game launch
  - **Versions**: install and manage versions, Fabric, Forge, NeoForge, Quilt, OptiFine
  - **Skin**: view and change your skin
  - **Settings**: game and launcher options
  - **Modrinth**: search and install mods and modpacks
- **Emerald theme** with a switch: dark, light or follow the system.

## Roadmap

- [ ] Rename and a separate `applicationId`
- [ ] arm64 build without a bundled runtime, measure the APK size
- [ ] Emerald theme (dark, light, system)
- [ ] Bottom navigation with 5 sections
- [ ] Skin screen
- [ ] Modrinth section design

## Building

You need Android Studio, JDK 17 and an internet connection: the build pulls dependencies, including some from JitPack.

```bash
git clone https://github.com/Duulat2014/DuutLaunch.git
cd DuutLaunch
./gradlew :app_mojo:assembleNoruntimeDebug
```

On Windows use `gradlew.bat` instead of `./gradlew`. The finished APK appears in `app_mojo/build/outputs/apk/`.

## License

DuutLaunch is licensed under the [GNU LGPLv3](LICENSE), like MojoLauncher and PojavLauncher. The source code of any changes stays open, and the copyright notices and license texts of the original projects are preserved.

## Third-party components

This project uses components from MojoLauncher and PojavLauncher and their dependencies:

- [MojoLauncher](https://github.com/MojoLauncher/MojoLauncher): GNU LGPLv3
- [PojavLauncher](https://github.com/PojavLauncherTeam/PojavLauncher): GNU LGPLv3
- Android Support Libraries: Apache License 2.0
- [Holy GL4ES](https://github.com/artdeell/gl4es_extra_extra/): MIT
- [OpenJDK](https://github.com/PojavLauncherTeam/openjdk-multiarch-jdk8u): GNU GPLv2 with Classpath Exception
- [LWJGL3](https://github.com/LWJGL/lwjgl3): BSD-3
- [mojoexec](https://github.com/MojoLauncher/mojoexec): MIT
- [Mesa 3D](https://gitlab.freedesktop.org/mesa/mesa): MIT
- [pro-grade](https://github.com/pro-grade/pro-grade): Apache License 2.0
- [OpenAL Soft](https://github.com/kcat/openal-soft/): GNU LGPL
- [Oboe](https://github.com/google/oboe): Apache License 2.0

## Disclaimer

This project is not affiliated with, endorsed by, or approved by Mojang Studios, Microsoft, MojoLauncher or PojavLauncher. Minecraft is a trademark of Mojang Studios. A legitimate copy of Minecraft: Java Edition is required to play.
