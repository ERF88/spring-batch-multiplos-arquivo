package com.github.erf88.model.in;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.*;
import java.io.Serializable;

@Getter
@Setter
@ToString
public class ClienteIn implements Serializable {

    @NotNull
    private Integer id;

    @NotBlank
    @Pattern(regexp = "[a-zA-Z\\u00C0-\\u00FF ]+", message = "Nome deve conter apenas letras")
    private String nome;

    @NotBlank
    @Pattern(regexp = "[a-zA-Z\\u00C0-\\u00FF ]+", message = "Sobrenome deve conter apenas letras")
    private String sobrenome;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String status;

}
