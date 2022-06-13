package com.github.erf88.model.out;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class ClienteOut implements Serializable {

    private Integer id;
    private String nomeCompleto;
    private String email;
    private String dataProcessamento;

}
