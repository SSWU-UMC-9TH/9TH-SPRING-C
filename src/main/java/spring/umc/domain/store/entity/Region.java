package spring.umc.domain.store.entity;

import jakarta.persistence.*;
import lombok.*;
import spring.umc.global.entity.BaseEntity;

import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Table(name = "region")
public class Region extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "city", length = 10, nullable = false)
    private String city;

    @Column(name = "county", length = 10, nullable = false)
    private String county;

    @Column(name = "district", length = 10, nullable = false)
    private String district;
}

