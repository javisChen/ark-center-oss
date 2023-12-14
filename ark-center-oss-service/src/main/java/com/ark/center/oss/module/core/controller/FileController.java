package com.ark.center.oss.module.core.controller;//package com.ark.center.oss.module.demo.controller;
import cn.hutool.core.io.IoUtil;
import com.ark.center.oss.module.core.dto.OssUploadReqDTO;
import com.ark.center.oss.module.core.service.OssService;
import com.ark.center.oss.module.core.dto.OssUploadRespDTO;
import com.ark.component.dto.SingleResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


@Tag(name = "OSS")
@RequestMapping("/v1/file")
@RestController
@Slf4j
public class FileController {

    private final OssService ossService;

    public FileController(OssService ossService) {
        this.ossService = ossService;
    }

    @Operation(summary = "上传OSS")
    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public SingleResponse<OssUploadRespDTO> upload(OssUploadReqDTO ossUploadDTO) {
        return SingleResponse.ok(ossService.upload(ossUploadDTO));
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
