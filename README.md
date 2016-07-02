This is a simple [Logback](http://logback.qos.ch/) appender which pushes logs to [Firebase Cloud Messaging (FCM)](https://firebase.google.com/docs/cloud-messaging/)

Install via gradle:
-----
```gradle
repositories {
    ...
    maven { url 'http://maven.subey.net' }
}

dependencies {
    ...
    compile group: 'net.subey', name: 'logback-fcm-appender', version: '1.0-SNAPSHOT'

}
```

Usage:
src/main/resources/logback.xml
-----
```xml
    <appender name="FCM" class="net.subey.logback.FcmAppender">
        <filter class="ch.qos.logback.classic.filter.ThresholdFilter">
            <level>ERROR</level>
        </filter>
        <key>YOUR KEY</key>
        <title>YOUR NOTIFY TITLE</title>
        <to>/topics/log</to>
    </appender>
```