package com.mdx.pojo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Mengdl
 * @date 2023/05/31
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BaseUser extends BaseEntity {

    @JsonSerialize(using = ToStringSerializer.class)
    private Long userId;

    private String userName;

    private String mobile;

    private String name;

}
