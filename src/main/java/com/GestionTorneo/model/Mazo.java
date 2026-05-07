package com.GestionTorneo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Data
@NoArgsConstructor 
@AllArgsConstructor 
@Builder
@Entity
@Table(name = "mazo")

public class Mazo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre del mazo es obligatorio")
    @Size(min = 3, max = 50, message = "El nombre del mazo debe tener entre 3 y 50 caracteres")
    @Column(nullable = false, length = 50)
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "jugador_id", nullable = false)
    private Jugador jugador;

    @OneToMany(mappedBy = "mazo") //porsi se repite el mazo??
    private List<Participacion> participaciones;

    
}



