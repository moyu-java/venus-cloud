# Redis 使用示例

## 引入依赖

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project>
    <!-- 其他配置... -->
    <dependencies>
        <dependency>
            <groupId>com.junmoyu</groupId>
            <artifactId>venus-starter-redis</artifactId>
        </dependency>
    </dependencies>
</project>
```

## 添加 Redis 连接信息

**application.yaml**

```yaml
spring:
  redis:
    database: 8
    host: 127.0.0.1
    port: 6379
    password: password
    lettuce:
      pool:
        max-active: 8
        max-idle: 8
        min-idle: 0
        max-wait: -1ms
      shutdown-timeout: 2000ms
```

## 使用 RedisService

```java
@RestController
@RequestMapping("redis")
@RequiredArgsConstructor
public class RedisController {

    private final RedisService redisService;

    @PostMapping("/users")
    public String setObject(User user) {
        redisService.setCacheObject("user.info", user);
        return "success.";
    }

    @GetMapping("/users")
    public User getObject() {
        return redisService.getCacheObject("user.info");
    }
}
```