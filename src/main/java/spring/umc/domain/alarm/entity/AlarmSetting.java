package spring.umc.domain.alarm.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import spring.umc.domain.alarm.AlarmType;
import spring.umc.domain.user.entity.User;

@Entity
@Table(name = "alarm_setting")
@Getter
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AlarmSetting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Enumerated(EnumType.STRING)
    @JoinColumn(nullable = false)
    private AlarmType alarmType;

    @Column(nullable = false)
    private Boolean isAlarmEnabled = true;
}
