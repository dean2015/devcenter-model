package cn.devcenter.model.exception;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Data
public class ExceptionMessage {

    /**
     * Unique code at the specific service in the specific system
     */
    private Object code;

    /**
     * Details message
     */
    private String message;

    /**
     * which service this message serve to
     */
    private String service;

    /**
     * Optional, which system this message serves to
     */
    private String system;

}
