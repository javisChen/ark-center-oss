package com.ark.center.foundation.adapter.file.web;//package com.ark.center.oss.module.demo.controller;

import cn.hutool.core.io.IoUtil;
import com.ark.center.foundation.client.file.command.FileUploadCommand;
import com.ark.center.foundation.client.file.dto.FileUploadDTO;
import com.ark.center.foundation.file.service.FileUploadAppService;
import com.ark.component.dto.SingleResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Tag(name = "文件管理")
@RequestMapping("/v1/file")
@RestController
@Slf4j
public class FileUploadController {

    private final FileUploadAppService fileUploadAppService;

    public FileUploadController(FileUploadAppService fileUploadAppService) {
        this.fileUploadAppService = fileUploadAppService;
    }

    @Operation(summary = "上传文件")
    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public SingleResponse<FileUploadDTO> upload(FileUploadCommand ossUploadDTO) {
        return SingleResponse.ok(fileUploadAppService.upload(ossUploadDTO));
    }

    @Operation(summary = "转发文件流")
    @GetMapping(value = "/get")
    public void get(String uri, HttpServletResponse httpServletResponse) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .build();
        byte[] body;
        try {
            HttpResponse<byte[]> response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofByteArray());
            body = response.body();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        try {
            IoUtil.write(httpServletResponse.getOutputStream(), true, body);
        } catch (IOException e) {
            log.warn("write error", e);
        }
    }
}
