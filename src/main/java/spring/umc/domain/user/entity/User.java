package spring.umc.domain.user.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import spring.umc.common.entity.BaseTimeEntity;
import spring.umc.domain.alarm.entity.AlarmSetting;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "user")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
@SQLDelete(sql = "UPDATE user SET is_deleted = TRUE, deleted_at = NOW() WHERE id = ?")  // soft delete
@SQLRestriction("deleted_at IS NULL")
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 10, nullable = false)
    private String authProvider;

    @Column(length = 100, nullable = false)
    private String authProviderId;

    @Column(nullable = false)
    private Boolean isAuthenticated;

    @Column(length = 10, nullable = false)
    private String name;

    @Column(length = 20, nullable = false)
    private String nickname;

    @Column(length = 10)
    private String gender;

    @Column(length = 50)
    private String email;

    @Column(nullable = false)
    private Integer point;

    @Column(nullable = false)
    private LocalDate birthday;

    @Column(length = 255, nullable = false)
    private String mainAddress;

    @Column(length = 255)
    private String detailedAddress;

    @Column(nullable = false)
    private Boolean isDeleted = false;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<PreferredFood> preferredFoods = new HashSet<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AlarmSetting>  alarmSettings = new ArrayList<>();
}