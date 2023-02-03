package com.nznotes.noteapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.Data;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NoteNotFoundException  extends RuntimeException{
    private String noteName;
    private String fieldName;
    private Object fieldValue;
    public NoteNotFoundException( String noteName, String fieldName, Object fieldValue) {
        super(String.format("%s not found with %s : '%s'", noteName, fieldName, fieldValue));
        this.noteName = noteName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
}
