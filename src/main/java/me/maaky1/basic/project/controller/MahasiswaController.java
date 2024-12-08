package me.maaky1.basic.project.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import me.maaky1.basic.project.dto.MahasiswaDTO;
import me.maaky1.basic.project.dto.RequestDTO;
import me.maaky1.basic.project.service.MahasiswaService;
import me.maaky1.basic.project.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/mahasiswa")
@Tag(name = "Mahasiswa Controller", description = "Controller untuk data mahasiswa")
public class MahasiswaController {

    @Autowired
    private MahasiswaService mahasiswaService;

    @PostMapping("/insert")
    @Operation(summary = "Insert data mahasiswa", description = "Endpoint untuk menambahkan data mahasiswa")
    public ResponseEntity<?> insertDataMhs(@RequestBody MahasiswaDTO payload) {
        RequestDTO requestDTO = CommonUtil.constructRequestPayload(null, null, payload);
        log.info("[{}][RECEIVE REQUEST][{}][{}]", getClass().getSimpleName(), requestDTO.getRequestId(), requestDTO.getRequestPayload());
        ResponseEntity<?> response = mahasiswaService.insertData(requestDTO);
        log.info("[{}][REQUEST COMPLETED][{}]", this.getClass().getSimpleName(), requestDTO.getRequestId());
        return response;
    }
}
