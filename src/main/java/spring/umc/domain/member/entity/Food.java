package spring.umc.domain.member.entity;

import jakarta.persistence.*;
import lombok.*;
import spring.umc.domain.member.enums.FoodName;

@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Table(name = "food")
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 10, nullable = false)
    private FoodName foodName;
}
