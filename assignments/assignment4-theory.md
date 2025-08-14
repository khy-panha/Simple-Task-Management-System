# Assignment 4 — Short Questions (Theory)

## 1. Difference between @Component, @Service, and @Repository
- **@Component**: Generic Spring-managed bean; used for any class that needs dependency injection.  
- **@Service**: Specialization of @Component for the service/business logic layer.  
- **@Repository**: Specialization for the data access layer; automatically translates database exceptions into Spring’s DataAccessException.

---

## 2. Spring Boot Auto-Configuration
- Spring Boot automatically configures beans based on dependencies found in the classpath and default settings.  
- Reduces boilerplate configuration (e.g., database, web server, Jackson JSON mapping).  

---

## 3. MyBatis vs Hibernate
- **MyBatis**:
  - SQL Mapper framework
  - Developers write SQL manually
  - Maps results to Java objects
- **Hibernate**:
  - Full ORM framework
  - Generates SQL automatically from entity mappings
  - Handles caching, lazy loading, and relationships automatically

---

## 4. Dependency Injection in Spring Boot
- Spring Boot injects dependencies via:
  - **Constructor injection** (recommended)
  - **Field injection**
  - **Setter injection**
- Uses the IoC (Inversion of Control) container to manage bean creation and wiring.

---

## 5. CORS in Spring Boot
- **CORS** (Cross-Origin Resource Sharing) allows frontend apps from different origins to call your API.
- Example to enable globally:
```java
@Configuration
public class CorsConfig {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:5173")
                        .allowedMethods("GET","POST","PUT","DELETE")
                        .allowedHeaders("*");
            }
        };
    }
}

----

## 6. Securing a REST API
-Use HTTPS for encryption

-Implement authentication (e.g., JWT, OAuth2)

-Implement authorization (role-based access)

-Validate inputs to prevent attacks (SQL injection, XSS)

- Optionally implement rate limiting and logging for security