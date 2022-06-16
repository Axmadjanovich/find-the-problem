package uz.limon.chatsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.limon.chatsecurity.model.Chat;

@Repository
public interface ChatRepository extends JpaRepository<Chat, Integer> {

    boolean existsByName(String name);
}
