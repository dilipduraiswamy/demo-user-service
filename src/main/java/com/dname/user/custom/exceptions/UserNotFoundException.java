package com.dname.user.custom.exceptions;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@ApiModel(description = "User Not Found Exception Model")
@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserNotFoundException extends RuntimeException{

    @ApiModelProperty(notes = "Error Code", name = "errorCode", required = true)
    private Integer errorCode;

    @ApiModelProperty(notes = "Error Message", name = "errorMessage", required = true)
    private String errorMessage;
}
