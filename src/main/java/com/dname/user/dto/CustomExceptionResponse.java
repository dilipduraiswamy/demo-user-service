package com.dname.user.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(description = "Custom Exception Response Model")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomExceptionResponse {

    @ApiModelProperty(notes = "Error Code", name = "errorCode", required = true)
    private Integer errorCode;

    @ApiModelProperty(notes = "Error Message", name = "errorMessage", required = true)
    private String errorMessage;

}
