package spring.umc.member.domain;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import spring.umc.BaseEntity;
import spring.umc.alarm.domain.Alarm;
import spring.umc.enumeration.UserStatus;
import spring.umc.food.domain.UserCategory;
import spring.umc.inquiry.domain.Inquiry;
import spring.umc.mission.domain.UserMission;
import spring.umc.review.domain.Review;
import spring.umc.review.domain.ReviewReply;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@SQLDelete(sql = "UPDATE users SET deleted_at = NOW(), user_status = 'DELETED' WHERE user_id = ?")
@Where(clause = "deleted_at IS NULL")
@Table(name = "users")
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String name;

    private String gender;

    private String address;

    private LocalDate birthDate;

    private Integer points;

    @Enumerated(EnumType.STRING)
    private UserStatus userStatus;

    private String loginProvider;

    private String phoneNum;

    private Boolean isPhoneAuthorized;

    private String email;

    private LocalDateTime deletedAt;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<Alarm> alarms;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<UserCategory> userCategories;

    @OneToMany(mappedBy = "user")
    private List<Review> reviews;

    @OneToMany(mappedBy = "user")
    private List<ReviewReply> reviewReplies;

    @OneToMany(mappedBy = "user")
    private List<UserMission> userMissions;

    @OneToMany(mappedBy = "user")
    private List<Inquiry> inquiries;

}