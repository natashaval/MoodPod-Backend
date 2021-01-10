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
   - fix with spring.datasource.url=jdbc:postgres:// to jdbc:postgresql://
