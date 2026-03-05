package com.project.jobnest.DTO;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JobResponseDto {

    private Long id;
    private String title;
    private String company;
}
