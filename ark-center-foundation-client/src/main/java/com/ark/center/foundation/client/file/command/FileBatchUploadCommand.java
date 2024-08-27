package com.ark.center.foundation.client.file.command;

import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.Valid;
import lombok.Data;

import java.util.List;

@Data
public class FileBatchUploadCommand {

    @Valid
    private List<FileCommand> files;

}