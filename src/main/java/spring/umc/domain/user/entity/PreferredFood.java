package spring.umc.domain.user.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import spring.umc.domain.shop.entity.FoodCategory;

@Entity
@Table(name = "preferred_food")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PreferredFood {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private FoodCategory foodCategory;
}
