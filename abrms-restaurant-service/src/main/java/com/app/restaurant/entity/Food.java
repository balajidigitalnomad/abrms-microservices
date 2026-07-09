package com.app.restaurant.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name ="app_food")
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="food_id")
    private Long foodId;

    @Column(name="food_code")
    private String foodCode;

    @Column(name="food_name")
    private String foodName;

    @Column(name="food_price")
    private Double foodPrice;

    @Column(name="food_category_id")
    private Long foodCategoryId;

    @Column(name="is_active")
    private Boolean isActive;

}
