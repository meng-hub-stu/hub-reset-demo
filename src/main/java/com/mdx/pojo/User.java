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
@TableName(value = "user")
public class User {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;

    private Integer age;

}
