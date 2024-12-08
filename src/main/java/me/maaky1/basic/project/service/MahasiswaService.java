package me.maaky1.basic.project.service;

import lombok.extern.slf4j.Slf4j;
import me.maaky1.basic.project.dto.MahasiswaDTO;
import me.maaky1.basic.project.dto.RequestDTO;
import me.maaky1.basic.project.entity.MahasiswaEntity;
import me.maaky1.basic.project.repository.MahasiswaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MahasiswaService {

    @Autowired
    private MahasiswaRepository mahasiswaRepository;

    public ResponseEntity<?> insertData(RequestDTO requestDTO) {
        try {
            log.info("[{}][START][{}][{}]", getClass().getSimpleName(), requestDTO.getRequestId(), requestDTO.getRequestAt());
            MahasiswaDTO mahasiswaDTO = (MahasiswaDTO) requestDTO.getRequestPayload();
            if (mahasiswaDTO.getNim().isEmpty() || mahasiswaDTO.getNamaMahasiswa().isEmpty() || mahasiswaDTO.getJenisKelamin().isEmpty()) throw new Exception("Pastikan value terisi semua");

            MahasiswaEntity mahasiswaEntity = new MahasiswaEntity()
                    .setNamaMahasiswa(mahasiswaDTO.getNamaMahasiswa())
                    .setNim(mahasiswaDTO.getNim())
                    .setJenisKelamin(mahasiswaDTO.getJenisKelamin());
            mahasiswaRepository.save(mahasiswaEntity);

            log.info("[{}][FINISH][{}][{}]", getClass().getSimpleName(), requestDTO.getRequestId(), requestDTO.getRequestAt());
            return new ResponseEntity<>(mahasiswaDTO, HttpStatus.CREATED);
        } catch (Exception e) {
            log.error("[{}][ERROR][{}][{}]", getClass().getSimpleName(), requestDTO.getRequestId(), e.getMessage());
            return new ResponseEntity<>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
