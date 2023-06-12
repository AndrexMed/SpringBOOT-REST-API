package com.voll.medic.api.medico;

import com.voll.medic.api.direccion.DatosDireccion;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

//Constructor
public record DatosRegistroMedico(@NotBlank
                                  String nombre,
                                  @NotBlank
                                  @Email
                                  String email,
                                  @NotBlank
                                  @Pattern(regexp = "\\d{4,10}")
                                  String documento,
                                  @NotBlank
                                  String telefono,
                                  @NotNull
                                  Especialidades especialidad,
                                  @NotNull
                                  @Valid
                                  DatosDireccion direccion) {

}