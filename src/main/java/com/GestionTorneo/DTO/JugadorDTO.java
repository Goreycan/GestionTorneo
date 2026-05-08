package com.GestionTorneo.DTO;


import lombok.Data;
import java.util.List;

@Data
public class JugadorDTO {
    private Long id;
    private String nombre;
    private List<String> nombresMazos; // nombre de mazos?
}
