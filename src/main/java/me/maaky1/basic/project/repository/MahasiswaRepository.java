package me.maaky1.basic.project.repository;

import me.maaky1.basic.project.entity.MahasiswaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MahasiswaRepository extends JpaRepository<MahasiswaEntity, Long> {
}
