package com.GestionTorneo.model;

import jakarta.persistence.*;

import lombok.*;

@Getter 
@Setter 
@NoArgsConstructor 
@AllArgsConstructor 
@Builder
@Entity
@Table(name = "participantes")

public class Participantes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "partida_id", nullable = false)
    private Partida partida;

    @ManyToOne
    @JoinColumn(name = "participacion_id", nullable = false)
    private Participacion participacion;

    private int posicion; // 1 = ganador
    private int puntos;   // puntos obtenidos en la partida
}