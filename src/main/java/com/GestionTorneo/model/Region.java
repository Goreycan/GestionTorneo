package com.GestionTorneo.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "regiones")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Region {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique=true, nullable=false)
    private Long id;

    @Column
    private String nombre;

    @OneToMany(mappedBy="region")
    @JsonManagedReference//evita la recursividad infinita al serializar a JSON, al  identificar la jerarquia de la tabla (tabla padre)
    private List<Comuna> comunas;
}
