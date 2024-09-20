package com.example.inicial1.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.Audited;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Libro")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
@Audited

public class Libro implements Serializable {
    @Column(name = "Cod_Libro")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "Titulo")
    private String titulo;
    @Column(name = "Fecha")
    private int fecha;
    @Column(name = "Genero")
    private String genero;
    @Column(name = "Pagina")
    private int paginas;

    @ManyToMany(cascade = {CascadeType.ALL, CascadeType.MERGE})
    @JoinTable(
            name = "Libro_Autor", // Nombre de la tabla intermedia
            joinColumns = @JoinColumn(name = "libro_id"), // Columna que representa la clave foránea de Libro
            inverseJoinColumns = @JoinColumn(name = "autor_id") // Columna que representa la clave foránea de Autor
    )
    @Builder.Default
    private List<Autor> autores = new ArrayList<>();

}
