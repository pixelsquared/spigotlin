# spigotlin
The best library for Spigot plugins written in Kotlin.

See the wiki for code examples!

### Features
Spigotlin has a lot of features:
- Type-safe command library with/without namespaces! Features configurable (and automatic) argument-arity, type-verification and correct CommandSender checks.
- Easy event-listening.
- Easy manipulation to all online players.
- Easy event scheduling.
- Easy creation and management of configurations.
- Easy GUI creation.
- Configurable update checks!
- Configurable help-menu creation for plugin and namespace commands!
- Useful extension functions for Player and ChatColor.
- Easy ScoreBoard creation.
- Easy BossBar creation.
- DSL builders for all of these features!

Plans:
- Easy MySQL and H2 database management.
- Easy language/locale support.
- Easy NBT manipulation.
- YAML serializers for common data-types.

Not Plans:
- Add Bungeecord support.

Important note:
Use this library wisely, it is over 3500 lines of Kotlin. If you're planning to use it in multiple plugins, you should create another library which shades Spigotlin.

### Maven and Gradle
Kotlin
```kotlin
repositories {
    maven("https://jitpack.io")
}

dependencies {
    implementation("com.github.7we:spigotlin:0.1.2-BETA")
}
```

Groovy
```groovy
repositories {
    maven { url 'https://jitpack.io' }
}

dependencies {
    implementation 'com.github.7we:spigotlin:0.1.2-BETA'
}
```

Maven
```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
<dependencies>
    <dependency>
        <groupId>com.github.7we</groupId>
        <artifactId>spigotlin</artifactId>
        <version>0.1.2-BETA</version>
    </dependency>
</dependencies>
```
