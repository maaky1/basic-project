package me.maaky1.basic.project.entity;

import lombok.Data;
import lombok.experimental.Accessors;
import javax.persistence.*;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "mahasiswa")
public class MahasiswaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "namaMahasiswa", length = 100, nullable = false)
    private String namaMahasiswa;

    @Column(name = "nim", length = 50, nullable = false)
    private String nim;

    @Column(name = "jenisKelamin", length = 15, nullable = false)
    private String jenisKelamin;
}
