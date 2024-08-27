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
 * 文件分组表
 * </p>
 *
 * @author
 * @since 2024-08-27
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("t_file_group")
public class FileGroup extends BaseEntity {


    /**
     * 分组名称
     */
    @TableField("name")
    private String name;

    /**
     * 父级路由id
     */
    @TableField("pid")
    private Long pid;

    /**
     * 层级路径
     */
    @TableField("path")
    private String path;

    /**
     * 层级
     */
    @TableField("level")
    private Integer level;

}