package spring.umc.store.domain;


import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.*;
import lombok.*;
import org.locationtech.jts.geom.Point;
import spring.umc.enumeration.StoreStatus;
import spring.umc.food.domain.FoodCategory;
import spring.umc.region.domain.Region;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "store")
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long storeId;

    @Column(columnDefinition = "POINT")
    private Point location;

    @Column(length = 20)
    private String type;

    @Column(length = 100)
    private String address;

    @Enumerated(EnumType.STRING)
    private StoreStatus storeStatus;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private Float storeScore;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id")
    private Region region;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "food_category_id")
    private FoodCategory foodCategory;
}