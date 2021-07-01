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
@Table(name = "basket")
public class Basket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nick;

    private String name;

    private String filename;

    private Double price;
}
