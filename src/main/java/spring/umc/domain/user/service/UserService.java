package spring.umc.domain.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.umc.domain.user.repository.PreferredFoodRepository;
import spring.umc.domain.user.repository.UserRepository;
import spring.umc.domain.user.repository.UserTermRepository;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserTermRepository userTermRepository;
    private final PreferredFoodRepository preferredFoodRepository;

    @Transactional
    public void deleteUserAndRelatedData(Long userId) {

        // 1. 사용자 관련 하위 데이터 삭제
        userTermRepository.deleteByUserId(userId);
        preferredFoodRepository.deleteByUserId(userId);

        // 2. 사용자 soft delete 처리
        userRepository.softDelete(userId);
    }
}
