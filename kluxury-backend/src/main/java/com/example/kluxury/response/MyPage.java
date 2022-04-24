package com.example.kluxury.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MyPage {
    private int page;
    private int pageSize;
    private int totalPage;
    private Object content;
}
