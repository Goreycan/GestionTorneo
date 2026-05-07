package com.GestionTorneo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "organizadores")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Organizadores {//la funcion de esta tabla intermedia es manejar la relacion de muchos a muchos entre organizadores y locales,
//ya que un organizador puede estar asociado a varios locales y un local puede tener varios organizadores asociados
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "local_id")
    @JsonBackReference//evita la recursividad infinita al serializar a JSON, al  identificar la jerarquia de la tabla (tabla hijo)
    private Local local;

    @ManyToOne
    @JoinColumn(name = "organizador_id")
    @JsonBackReference//evita la recursividad infinita al serializar a JSON, al  identificar la jerarquia de la tabla (tabla hijo)
    private Organizador organizador;
}
