package dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor

public class BlogDto extends BaseDto implements Serializable {
    public static final Long serialVersionUID=1L;

    private String header;
    private String content;

    public BlogDto(long id, Date systemCreatedDate, String header, String content) {
        super(id, systemCreatedDate);
        this.header = header;
        this.content = content;
    }

    public BlogDto() {
    }
}
