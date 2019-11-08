package com.nice.pojo;

import com.nice.enumeration.SexEnum;
import lombok.Data;

import java.io.Serializable;

/**
 * @author ningh
 */
@Data
public class User implements Serializable {

    private Long id;

    private String userName;
    private SexEnum sex;
    private String note;


}
