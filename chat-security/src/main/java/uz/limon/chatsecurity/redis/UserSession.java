package uz.limon.chatsecurity.redis;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.Id;

@RedisHash(value = "userSession", timeToLive = 60 * 60 * 10)  // 10 hours
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserSession {

    @Id
    private String id;
    private String userInfo;
}
