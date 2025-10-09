package spring.umc.domain.shop.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import spring.umc.common.entity.BaseTimeEntity;

import java.time.LocalDateTime;

@Entity
@Table(name = "shop")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public class Shop extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id", nullable = false)
    private Region region;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "food_category_id", nullable = false)
    private FoodCategory foodCategory;

    @Column(length = 30, nullable = false)
    private String name;

    @Column(length = 255, nullable = false)
    private String mainAddress;

    @Column(length = 255)
    private String detailedAddress;

    @Column(nullable = false)
    private Boolean isDeleted = false;

    @LastModifiedDate
    private LocalDateTime updatedAt;
}
