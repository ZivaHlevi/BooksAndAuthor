package com.jb.bookandauthor.exseptions;

import lombok.Getter;

@Getter
public enum MsgExp {
    NO_BOOKS("no books fond "),
    ID_AUTHOR_FAILED("author not find"),
    YEAR_FAIL("year must be greater than 0");


    private String msg;

    MsgExp(String msg) {
        this.msg = msg;
    }
}
