package com.ark.center.foundation.dao.file;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ark.component.orm.mybatis.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * <p>
 * 文件表
 * </p>
 *
 * @author
 * @since 2024-08-27
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("t_file")
public class File extends BaseEntity {

    /**
     * 主键ID
     */
    @TableId
    private Long id;

    /**
     * 文件名称
     */
    @TableField("name")
    private String name;

    /**
     * 文件地址
     */
    @TableField("uri")
    private String uri;

    /**
     * 文件类型
     */
    @TableField("mime_type")
    private String mimeType;

    /**
     * 业务编码
     */
    @TableField("biz_type")
    private String bizType;

    /**
     * 文件分组
     */
    @TableField("group_id")
    private Long groupId;

}