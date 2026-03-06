package com.project.jobnest.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ExternalJobResponseDto {

    private List<ExternalJobDto> data;
}
