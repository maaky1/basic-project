package me.maaky1.basic.project.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "mata_kuliah")
public class MataKuliahEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "namaMataKuliah", length = 50, nullable = false)
    private String namaMataKuliah;

    @ManyToOne
    @JoinColumn(name = "mahasiswaId")
    private MahasiswaEntity mahasiswa;

    @Column(name = "createdOn")
    private Timestamp createdOn;

    @Column(name = "modifiedOn")
    private Timestamp modifiedOn;
}
