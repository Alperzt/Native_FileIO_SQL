package dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
abstract public class BaseDto implements Serializable {
    public static final Long serialVersionUID=1L;

    private long id;
    private Date systemCreatedDate;

    public BaseDto() {
        this.systemCreatedDate = new Date(System.currentTimeMillis());
    }

    public BaseDto(long id, Date systemCreatedDate) {
        this.id = id;
        this.systemCreatedDate = systemCreatedDate;
    }
}
