package org.example.restaurant.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import org.example.restaurant.entity.enums.Cuisine;
import org.example.restaurant.entity.enums.MealType;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = PRIVATE)
@SuperBuilder(toBuilder = true)
public class Meal extends BaseEntity{

    @NonNull
    long price;

    @NonNull
    String name;

    @NonNull
    Cuisine cuisine;

    @NonNull
    MealType mealType;

}
