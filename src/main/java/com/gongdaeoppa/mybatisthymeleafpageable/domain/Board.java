package com.gongdaeoppa.mybatisthymeleafpageable.domain;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Board {

    private Long id;
    private String title;
    private String regDay;


    public String getRegDayForPrint() {
        return regDay.substring(2, 16);
    }

}
