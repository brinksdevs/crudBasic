package com.brinksdevs.crudbasic.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDto {
    private Long id;
    private String name;
    private String email;
    private String profile;
}
