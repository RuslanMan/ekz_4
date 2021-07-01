package ru.ruslan.project.avito.models;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String nick;

    private String filename;

    private Double price;
}
