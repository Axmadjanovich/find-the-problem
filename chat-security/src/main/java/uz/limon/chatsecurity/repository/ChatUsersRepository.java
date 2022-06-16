package uz.limon.chatsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.limon.chatsecurity.model.ChatUsers;

@Repository
public interface ChatUsersRepository extends JpaRepository<ChatUsers, Integer> {

    boolean existsByChatIdAndUserId(Integer chatId, Integer userId);
}
