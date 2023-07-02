package com.jb.bookandauthor.exceptions;

import lombok.Getter;

@Getter
public enum MsgExp {
    NO_BOOKS("No books found "),
    ID_AUTHOR_FAILED("Author not found"),
    YEAR_FAIL("Year must be greater than 0");


    private String msg;

    MsgExp(String msg) {
        this.msg = msg;
    }
}
