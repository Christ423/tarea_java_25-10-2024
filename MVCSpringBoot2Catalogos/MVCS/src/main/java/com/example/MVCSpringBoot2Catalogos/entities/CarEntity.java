package com.example.MVCSpringBoot2Catalogos.entities;


import lombok.*;

import java.util.UUID;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class CarEntity {
    private UUID id;
    private String name;
    private String brand;
    private int price;
    private int stock;
}
