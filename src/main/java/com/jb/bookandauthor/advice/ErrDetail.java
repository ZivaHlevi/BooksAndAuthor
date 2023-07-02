package com.jb.bookandauthor.advice;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrDetail {
    private final String title="Error Msg By Advice";
    private String errMsg;


}
