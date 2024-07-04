# Spring Data JPA Reproducer

This standalone reproducer shows that the method `findBy(...)` of `JpaSpecificationExecutor` has a bug
in its limit / offset handling. This has been recently introduced in version 3.3.0.

To demonstrate:

- Run `gradlew test`

You can switch the Spring Boot version in `build.gradle` from 3.3.1 to 3.2.5. Doing so will make the
tests pass. Changing it back to 3.3.1 will make them fail again.