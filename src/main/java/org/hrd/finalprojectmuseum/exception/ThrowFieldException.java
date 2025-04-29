package org.hrd.finalprojectmuseum.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ThrowFieldException extends RuntimeException {
    private String field;
    private String message;
}

