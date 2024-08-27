package com.ark.center.foundation.client.file.command;

import com.ark.center.foundation.client.file.constants.OssTypeEnum;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;


@Data
public class FileUploadCommand {

    @ApiModelProperty(value = "OSS类型 （MINIO、ALI_CLOUD）", allowableValues = "MINIO,ALI_CLOUD", required = false)
    private String type = "MINIO";

    @ApiModelProperty(value = "bucket（不传就取默认值）", required = false)
    private String bucket = "default";

    @ApiModelProperty(value = "文件名称", required = false)
    private String fileName;

    @ApiModelProperty(value = "文件", required = true)
    @NotNull(message = "文件不能为空")
    private MultipartFile file;

}
