package org.example.restaurant.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.time.Instant;
import java.util.UUID;

import static lombok.AccessLevel.PROTECTED;

@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level = PROTECTED)
@SuperBuilder(toBuilder = true)
public class BaseEntity {

    UUID id;

    Instant createdDate;

}

