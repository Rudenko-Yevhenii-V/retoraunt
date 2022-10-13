package org.example.restaurant.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import org.example.restaurant.entity.enums.Cuisine;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = PRIVATE)
@SuperBuilder(toBuilder = true)
public class Drink extends BaseEntity{

    @NonNull
    long price;

    @NonNull
    String name;

    @NonNull
    Cuisine cuisine;

    boolean cubes;

    boolean lemon;

    public long getPrice() {
        long additionPrice = price;

        if (cubes) {
            additionPrice += 50L;
        }

        if (lemon) {
            additionPrice += 100L;
        }

        return additionPrice;
    }
}
