package com.datav.rule.domain;


import lombok.Data;

import java.util.List;

@Data
public class User {

    private String name;
    private List<String> roles;
    private String avatar;
    private String introduction;
}
