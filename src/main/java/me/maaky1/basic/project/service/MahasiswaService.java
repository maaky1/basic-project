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

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Slf4j
@Service
public class MahasiswaService {

    @Autowired
    private MahasiswaRepository mahasiswaRepository;

    public ResponseEntity<?> insertData(RequestDTO requestDTO) {
        try {
            log.info("[{}][START][{}][{}]", requestDTO.getRequestId(), requestDTO.getOperationName(), requestDTO.getRequestAt());
            MahasiswaDTO mahasiswaDTO = (MahasiswaDTO) requestDTO.getRequestPayload();
            if (mahasiswaDTO.getNim().isEmpty() || mahasiswaDTO.getNamaMahasiswa().isEmpty() || mahasiswaDTO.getJenisKelamin().isEmpty()) throw new Exception("Pastikan value terisi semua");

            MahasiswaEntity mahasiswaEntity = new MahasiswaEntity()
                    .setNamaMahasiswa(mahasiswaDTO.getNamaMahasiswa())
                    .setNim(mahasiswaDTO.getNim())
                    .setJenisKelamin(mahasiswaDTO.getJenisKelamin())
                    .setCreatedOn(Timestamp.valueOf(LocalDateTime.now()));
            mahasiswaRepository.save(mahasiswaEntity);

            log.info("[{}][FINISH][{}][{}]", requestDTO.getRequestId(), requestDTO.getOperationName(), requestDTO.getRequestAt());
            return new ResponseEntity<>(mahasiswaDTO, HttpStatus.CREATED);
        } catch (Exception e) {
            log.error("[{}][ERROR][{}][{}]", requestDTO.getRequestId(), requestDTO.getOperationName(), requestDTO.getRequestAt());
            return new ResponseEntity<>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<?> updateData(RequestDTO requestDTO) {
        try {
            log.info("[{}][START][{}][{}]", requestDTO.getRequestId(), requestDTO.getOperationName(), requestDTO.getRequestAt());
            MahasiswaDTO mahasiswaDTO = (MahasiswaDTO) requestDTO.getRequestPayload();
            if (mahasiswaDTO.getNim().isEmpty()) throw new Exception("Masukkan NIM yang sesuai");

            MahasiswaEntity findByNim = mahasiswaRepository.findByNim(mahasiswaDTO.getNim()).orElseThrow(() -> new Exception("Data tidak ditemukan"));
            if (!mahasiswaDTO.getNamaMahasiswa().isEmpty()) findByNim.setNamaMahasiswa(mahasiswaDTO.getNamaMahasiswa()).setModifiedOn(Timestamp.valueOf(LocalDateTime.now()));;
            mahasiswaRepository.save(findByNim);

            log.info("[{}][START][{}][{}]", requestDTO.getRequestId(), requestDTO.getOperationName(), requestDTO.getRequestAt());
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            log.info("[{}][START][{}][{}]", requestDTO.getRequestId(), requestDTO.getOperationName(), requestDTO.getRequestAt());
            return new ResponseEntity<>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
