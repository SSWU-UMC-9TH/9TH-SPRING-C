package spring.umc.domain.user.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PreferredFoodRepository {

    @Modifying
    @Query("DELETE FROM PreferredFood pf WHERE pf.user.id = :userId")
    void deleteByUserId(Long userId);
}
