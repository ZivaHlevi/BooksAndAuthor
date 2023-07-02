package com.jb.bookandauthor.exceptions;

public class LibraryCustomException extends Exception {
    public LibraryCustomException(MsgExp msgExp) {
        super(msgExp.getMsg());
    }
}
