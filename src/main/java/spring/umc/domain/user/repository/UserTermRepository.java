package spring.umc.domain.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import spring.umc.domain.user.entity.UserTerm;

@Repository
public interface UserTermRepository extends JpaRepository<UserTerm,Long> {

    @Modifying
    @Query("DELETE FROM UserTerm ut WHERE ut.user.id = :userId")
    void deleteByUserId(Long userId);
}
