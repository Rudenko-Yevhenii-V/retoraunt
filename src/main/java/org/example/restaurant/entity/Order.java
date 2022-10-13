package org.example.restaurant.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import org.example.restaurant.exception.CustomException;

import java.util.ArrayList;
import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = PRIVATE)
@SuperBuilder(toBuilder = true)
public class Order extends BaseEntity{

    @NonNull
    long price;

    List<Meal> meals = new ArrayList<>();

    List<Drink> drinks = new ArrayList<>();

    public void setPrice(long price) {
        if (price <= 0) {
            throw new CustomException("price must be greater than zero...");
        }
        this.price = price;
    }
}
