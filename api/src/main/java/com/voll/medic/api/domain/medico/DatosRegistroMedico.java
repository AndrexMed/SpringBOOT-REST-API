package com.voll.medic.api.domain.medico;

import com.voll.medic.api.domain.direccion.DatosDireccion;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

//Constructor
public record DatosRegistroMedico(@NotBlank(message = "{nombre.obligatorio}")
                                  String nombre,
                                  @NotBlank(message = "{email.obligatorio}")
                                  @Email(message = "{email.invalido}")
                                  String email,
                                  @NotBlank(message = "{documento.obligatorio}")
                                  @Pattern(regexp = "\\d{4,10}", message = "{documento.invalido}")
                                  String documento,
                                  @NotBlank(message = "{telefono.obligatorio}")
                                  String telefono,
                                  @NotNull(message = "{especialidad.obligatorio}")
                                  Especialidades especialidad,
                                  @NotNull(message = "{direccion.obligatorio}")
                                  @Valid
                                  DatosDireccion direccion) {

}