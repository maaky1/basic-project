package me.maaky1.basic.project.repository;

import me.maaky1.basic.project.entity.MataKuliahEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MataKuliahRepository extends JpaRepository<MataKuliahEntity, Long> {

}
