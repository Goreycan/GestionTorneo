package com.GestionTorneo.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "comunas")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Comuna {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique=true, nullable=false)
    private Long id;

    @Column(nullable=false)
    private String nombre;

    @ManyToOne
    @JoinColumn(name="region_id", nullable=false)
    @JsonBackReference//evita la recursividad infinita al serializar a JSON al identificar la jerarquia de la tabla (tabla hijo)
    private Region region;

    @OneToMany(mappedBy="comuna")
    @JsonManagedReference//evita la recursividad infinita al serializar a JSON, al  identificar la jerarquia de la tabla (tabla padre)
    private List<Local> locales;
}
