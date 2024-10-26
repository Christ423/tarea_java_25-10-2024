package com.example.MVCSpringBoot2Catalogos.entities;

import lombok.*;

import java.util.UUID;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class BikeEntity {
    private UUID id;
    private String name;
    private String type;
    private double price;
    private int stock;
}
