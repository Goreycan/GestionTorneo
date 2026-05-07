package com.GestionTorneo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor 
@AllArgsConstructor 
@Builder
@Entity
@Table(name = "jugador") 

public class Jugador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 

    @NotBlank (message = "!crea tu nombre¡ , es obligatorio")
    @Size(min = 3, max = 100, message = "El nombre debe tener entre 3 y 100 caracteres")
    @Column(nullable = false, length = 100)
    private String nombre;

    
    @OneToMany(mappedBy = "jugador") //relación para ver en qué torneos ha participado el ugador
    private List<Participacion> participaciones;


    @ManyToOne
    @JoinColumn(name = "jugador_id", nullable = false)
    private Jugador jugador; //crea una columna ,que servirá como Llave Foránea ;)
}
