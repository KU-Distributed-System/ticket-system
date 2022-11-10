package DistributedSystem.ticketsystem.global.error;

import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException {

    private int status;

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(int status, String message) {
        super(message);
        this.status = status;
    }


}
