package com.jb.bookandauthor.exseptions;

public class LibraryCustomException extends Exception {
    public LibraryCustomException(MsgExp msgExp) {
        super(msgExp.getMsg());
    }
}
