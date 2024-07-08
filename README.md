# Java Modularity sample project

## Maven Exec Plugin issue

1. `mvn clean install`
2. `mvn -f ui exec:java`

[tkyjovsk.modularity.ui.Greetings.java](ui/src/main/java/tkyjovsk/modularity/ui/Greetings.java)
```
[INFO] --- exec:1.6.0:java (default-cli) @ ui ---
[WARNING] 
java.lang.RuntimeException: No service implementations were found.
    at tkyjovsk.modularity.ui.Greetings.main (Greetings.java:11)
    at jdk.internal.reflect.DirectMethodHandleAccessor.invoke (DirectMethodHandleAccessor.java:103)
    at java.lang.reflect.Method.invoke (Method.java:580)
    at org.codehaus.mojo.exec.ExecJavaMojo$1.run (ExecJavaMojo.java:282)
    at java.lang.Thread.run (Thread.java:1583)
```

This is caused by the exec plugin not adding the `--module-path` arg to the `java` command.

## Solution 1

Run `java` command directly:

`java --module-path api/target/api-1.0.0-SNAPSHOT.jar:ui/target/ui-1.0.0-SNAPSHOT.jar:en/target/en-1.0.0-SNAPSHOT.jar:cs/target/cs-1.0.0-SNAPSHOT.jar --module tkyjovsk.modularity.ui/tkyjovsk.modularity.ui.Greetings`


## Solution 2

Add `META-INF/services` entries to the `cs` and `en` modules:

```
cs/src/main/
  resources/META-INF/services/
    tkyjovsk.modularity.api.GreetingInterface:
---
tkyjovsk.modularity.cs.CzechGreeting
```
```
en/src/main/
  resources/META-INF/services/
    tkyjovsk.modularity.api.GreetingInterface:
---
tkyjovsk.modularity.en.EnglishGreeting
```
