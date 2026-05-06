package com.GestionTorneo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;

import java.time.LocalDate;

@Getter
@Setter 
// Getter y Setter n vez de usar @Data para controlar manualmente los problemas de bucle, 
// asi se puede usar tablas participacion, enfrentamiento, ronda para generar el ranking
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "torneo")
public class Torneo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre del torneo es obligatorio")
    private String nombre;

    @NotNull(message = "La fecha es obligatoria")
    private LocalDate fecha;

    @ManyToOne
    @JoinColumn(name = "local_id", nullable = false)
    private Local local;

    @OneToMany(mappedBy = "torneo", cascade = CascadeType.ALL)
    private List<Participacion> participaciones;

    @OneToMany(mappedBy = "torneo", cascade = CascadeType.ALL)
    private List<Ronda> rondas;

    @ManyToMany
    @JoinTable(
        name = "jueces",
        joinColumns = @JoinColumn(name = "torneo_id"),
        inverseJoinColumns = @JoinColumn(name = "juez_id")
    )
    private List<Juez> jueces;
}
