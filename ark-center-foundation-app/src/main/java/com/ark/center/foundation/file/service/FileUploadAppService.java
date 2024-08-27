package com.ark.center.foundation.file.service;

import com.ark.center.foundation.client.file.command.FileUploadCommand;
import com.ark.center.foundation.client.file.dto.FileUploadDTO;
import com.ark.component.exception.ExceptionFactory;
import com.ark.component.oss.api.strategy.OssStrategy;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@Slf4j
@RequiredArgsConstructor
public class FileUploadAppService {

    private final OssStrategy ossStrategy;

    public FileUploadDTO upload(FileUploadCommand ossUploadDTO) {

        MultipartFile file = ossUploadDTO.getFile();
        String ossUrl = "";
        try {
            ossUrl = ossStrategy.put(ossUploadDTO.getBucket(), ossUploadDTO.getFileName(), file.getInputStream());
        } catch (Exception e) {
            log.error("上传失败", e);
            throw ExceptionFactory.sysException("上传失败", e);
        }

        return toOssUploadRespDTO(ossUploadDTO.getFileName());
    }

    private FileUploadDTO toOssUploadRespDTO(String ossUrl) {
        FileUploadDTO respDTO = new FileUploadDTO();
        respDTO.setUrl(ossUrl);
        return respDTO;
    }
}
