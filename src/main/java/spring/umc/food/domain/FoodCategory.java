package spring.umc.food.domain;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.*;
import lombok.*;
import spring.umc.store.domain.Store;

import java.util.List;

@Entity
@Table(name = "food_category")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class FoodCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long foodCategoryId;

    @Column(length = 50)
    private String name;

    @OneToMany(mappedBy = "foodCategory")
    private List<Store> stores;
}