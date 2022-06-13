package com.gongdaeoppa.mybatisthymeleafpageable.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Board {

    private Long id;
    private String title;
    private String regDay;

}
