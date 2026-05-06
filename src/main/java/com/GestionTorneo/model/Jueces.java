package com.GestionTorneo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDate;

@Getter
@Setter 
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "jueces",
       uniqueConstraints = @UniqueConstraint(columnNames = {"torneo_id", "juez_id"}))
public class Jueces {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "torneo_id", nullable = false)
    private Torneo torneo;

    @NotNull (message = "El juez es obligatorio")
    @ManyToOne
    @JoinColumn(name = "juez_id", nullable = false)
    private Juez juez;

    private String rol; // Opcional Ej: "Principal", "Asistente"
}