package com.project.jobnest.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JobRequestDto {

    @NotBlank
    private String title;

    @NotBlank
    private String company;
}
