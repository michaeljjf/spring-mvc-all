package com.jjf.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Person implements Serializable {
    private String name;
    private String age;
    private String gender;
    private String[] hobby;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthdate;// 时间转换格式设置
    private List<Pet> pets;
    private Map<String, Pet> petMap;
}
