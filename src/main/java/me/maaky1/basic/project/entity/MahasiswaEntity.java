package me.maaky1.basic.project.entity;

import lombok.Data;
import lombok.experimental.Accessors;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "mahasiswa")
public class MahasiswaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nim", length = 50, nullable = false)
    private String nim;

    @Column(name = "namaMahasiswa", length = 100, nullable = false)
    private String namaMahasiswa;

    @Column(name = "mataKuliah")
    @OneToMany(mappedBy = "mahasiswa", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<MataKuliahEntity> mataKuliah;

    @Column(name = "createdOn")
    private Timestamp createdOn;

    @Column(name = "modifiedOn")
    private Timestamp modifiedOn;
}
