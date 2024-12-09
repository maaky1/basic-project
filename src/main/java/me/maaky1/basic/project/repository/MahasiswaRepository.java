package me.maaky1.basic.project.repository;

import me.maaky1.basic.project.entity.MahasiswaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MahasiswaRepository extends JpaRepository<MahasiswaEntity, Long> {

    Optional<MahasiswaEntity> findByNim(String nim);
}
