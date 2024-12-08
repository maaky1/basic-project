package me.maaky1.basic.project.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class MahasiswaDTO {

    private String namaMahasiswa;
    private String nim;
    private String jenisKelamin;
}
