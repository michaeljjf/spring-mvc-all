package com.jjf.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Player {
    private Integer id;
    private String name;
    private String password;
    private String nickname;
    private String photo;
    private String filetype;
}
