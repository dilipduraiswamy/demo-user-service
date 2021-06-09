package com.dname.user.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;


import javax.persistence.*;
import java.util.Date;

@ApiModel(description = "User Model")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    @ApiModelProperty(notes = "First Name Of User", name = "firstName", required = true, value = "Default First Name")
    @Column(name = "first_name")
    private String firstName;

    @ApiModelProperty(notes = "Last Name Of User", name = "lastName", required = false)
    @Column(name = "last_name")
    private String lastName;

    @ApiModelProperty(notes = "Middle Name Of User", name = "middleName", required = false)
    @Column(name = "middle_name")
    private String middleName;

    @ApiModelProperty(notes = "Email Id Of User", name = "emailId", required = true, value = "default@gmail.com")
    @Column(name = "email_id")
    private String emailId;

    @ApiModelProperty(notes = "Mobile Number Of User", name = "mobileNumber", required = false)
    @Column(name = "mobile_number")
    private Long mobileNumber;

    @ApiModelProperty(notes = "Date Of Birth Of User", name = "dob", required = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Nullable
    private Date dob;


}
