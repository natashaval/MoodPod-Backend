# MoodPod-Backend
Mood tracker project build with Spring Boot
### Source
- CRUD
  - https://developer.okta.com/blog/2018/09/11/android-kotlin-crud  
- Reactive
  - https://developer.okta.com/blog/2018/09/24/reactive-apis-with-spring-webflux
  - https://www.baeldung.com/spring-webflux
  
#### Error
1. Failed to configure a DataSource: no embedded datasource could be configured.  
Reason: Failed to determine a suitable driver class
   - **FIX**: spring.datasource.url=jdbc:postgres:// to jdbc:postgresql://
2. No default (no-argument) constructor for class ... -> findAll()  
   because of kotlin data class (need default constructor)
   - **FIX**: add plugin("kotlin.jpa") in build.gradle.kts
   - https://stackoverflow.com/questions/32038177/kotlin-with-jpa-default-constructor-hell
   - https://stackoverflow.com/questions/55228910/kotlin-jpa-plugin-not-generating-default-constructor