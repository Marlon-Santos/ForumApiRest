package br.com.gft.apiRest.model.validation;

import java.util.Objects;

public class ErrorsDto {
    private String error;
    private String message;

    public ErrorsDto(String error, String message) {
        this.error = error;
        this.message = message;
    }

    public String getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ErrorsDto errorsDto = (ErrorsDto) o;
        return Objects.equals(error, errorsDto.error);
    }

    @Override
    public int hashCode() {
        return Objects.hash(error);
    }
}
