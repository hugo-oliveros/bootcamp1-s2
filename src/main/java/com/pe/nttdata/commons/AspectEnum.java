package com.pe.nttdata.commons;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public enum AspectEnum {

    ERROR("0"),
    EXITO("1"),
    MENSAJEOK("OK");


    private String value;

    AspectEnum(String value) {
        this.value = value;
    }

    public String value() {
        return this.value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static AspectEnum fromValue(String value) {
        for (AspectEnum e : AspectEnum.values()) {
            if (e.value.equalsIgnoreCase(value)) {
                return e;
            }
        }
        throw new RuntimeException(value);
    }

    @Override
    public String toString() {
        return this.value;
    }

}
