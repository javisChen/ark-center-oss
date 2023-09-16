package com.ark.center.oss.module.core.controller;//package com.ark.center.oss.module.demo.controller;
import com.ark.center.oss.module.core.dto.OssUploadReqDTO;
import com.ark.center.oss.module.core.service.OssService;
import com.ark.center.oss.module.core.dto.OssUploadRespDTO;
import com.ark.component.dto.SingleResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;


@Tag(name = "OSS")
@RequestMapping("/v1/oss")
@RestController
public class OssController {

    private final OssService ossService;

    public OssController(OssService ossService) {
        this.ossService = ossService;
    }

    @Operation(summary = "上传OSS")
    @PostMapping("/upload")
    public SingleResponse<OssUploadRespDTO> upload(OssUploadReqDTO ossUploadDTO) {
        return SingleResponse.ok(ossService.upload(ossUploadDTO));
    }
}
