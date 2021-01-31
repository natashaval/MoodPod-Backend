# MoodPod-Backend
Mood tracker project build with Spring Boot
### Source
- CRUD
  - https://developer.okta.com/blog/2018/09/11/android-kotlin-crud  
- Reactive
  - https://developer.okta.com/blog/2018/09/24/reactive-apis-with-spring-webflux
  - https://www.baeldung.com/spring-webflux
- WebFlux
  - https://howtodoinjava.com/spring-webflux/spring-webflux-tutorial/
  - https://jstobigdata.com/spring/getting-started-with-spring-webflux/  
  
#### Error
1. Failed to configure a DataSource: no embedded datasource could be configured.  
Reason: Failed to determine a suitable driver class
   - **FIX**: spring.datasource.url=jdbc:postgres:// to jdbc:postgresql://
2. No default (no-argument) constructor for class ... -> findAll()  
   because of kotlin data class (need default constructor)
   - **FIX**: add plugin("kotlin.jpa") in build.gradle.kts
   - https://stackoverflow.com/questions/32038177/kotlin-with-jpa-default-constructor-hell
   - https://stackoverflow.com/questions/55228910/kotlin-jpa-plugin-not-generating-default-constructor
3. When using webflux, emit exception if find value is null; how to get error message when throwing ResponseStatusException
   - **FIX1**: use switchIfEmpty
   - https://stackoverflow.com/questions/45365791/spring-webflux-emit-exception-upon-null-value-in-spring-data-mongodb-reactive-r/45392930
   - **FIX2**: enable server.error.include-message=always in application.properties
   - https://stackoverflow.com/questions/49137253/how-could-we-use-exceptionhandler-with-spring-web-flux
   - https://stackoverflow.com/questions/62459836/exception-message-not-included-in-response-when-throwing-responsestatusexception  
4. Get First day of Month and end day of month
   - https://stackoverflow.com/questions/3083781/start-and-end-date-of-a-current-month
   - https://stackoverflow.com/questions/22223786/get-first-and-last-day-of-month-using-threeten-localdate