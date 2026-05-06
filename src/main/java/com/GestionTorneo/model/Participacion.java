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
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "participacion",
       uniqueConstraints = @UniqueConstraint(columnNames = {"jugador_id", "torneo_id"}))
public class Participacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "El jugador es obligatorio")
    @ManyToOne
    @JoinColumn(name = "jugador_id", nullable = false)
    private Jugador jugador;

    @NotNull(message = "El torneo es obligatorio")
    @ManyToOne
    @JoinColumn(name = "torneo_id", nullable = false)
    private Torneo torneo;

    @NotNull(message = "El mazo es obligatorio")
    @ManyToOne
    @JoinColumn(name = "mazo_id", nullable = false)
    private Mazo mazo;

    @Min(0)
    private int puntos = 0;

    @Min(0)
    private int victorias = 0;

    @Min(0)
    private int derrotas = 0;

    @Min(0)
    private int empates = 0;
}
