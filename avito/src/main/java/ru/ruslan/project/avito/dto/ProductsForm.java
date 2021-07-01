package ru.ruslan.project.avito.dto;

import lombok.Data;
@Data
public class ProductsForm {
    private String nick;
    private String name;
    private String filename;
    private Double price;
}
