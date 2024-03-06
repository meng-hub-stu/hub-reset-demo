package com.mdx.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author Mengdl
 * @date 2023/04/25
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@TableName(value = "hub_user")
@EqualsAndHashCode(callSuper = true)
public class User extends BaseEntity{
    private static final long serialVersionUID = 1L;

    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date birthday;

    private String gender;

    private String userName;

    private String password;

    private String remark;

    private String mobile;

    private String name;

}
