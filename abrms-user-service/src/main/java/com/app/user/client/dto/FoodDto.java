package com.app.user.client.dto;

import lombok.*;

@Data
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FoodDto {
    private Long foodId;
    private String foodCode;
    private String foodName;
    private Double foodPrice;
    private Long foodCategoryId;
    private Boolean isActive;
}
