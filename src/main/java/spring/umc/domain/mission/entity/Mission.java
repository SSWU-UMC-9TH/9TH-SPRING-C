package spring.umc.domain.mission.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import spring.umc.domain.shop.entity.Shop;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "mission")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public class Mission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shop_id", nullable = false)
    private Shop shop;

    @Column(nullable = false)
    private Integer successPrice;

    @Column(nullable = false)
    private Integer earnedPoint;

    @Column(nullable = false)
    private LocalDate deadAt;

//    @OneToMany(mappedBy = "mission", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Review> reviews;
//
//    @OneToMany(mappedBy = "mission", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<UserMission> userMissions;

    @CreatedDate
    @Column(updatable = false, nullable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;
}
