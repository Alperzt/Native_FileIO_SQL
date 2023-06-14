package dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@Builder
public class RegisterDto extends BaseDto implements Serializable {
    public static final Long serialVersionUID=1L;

    private String uName;
    private String uEmail;
    private String uSurName;
    private String password;

    public RegisterDto() {
    }

    public RegisterDto(long id, Date systemCreatedDate, String uName, String uEmail, String uSurName, String password) {
        super(id, systemCreatedDate);
        this.uName = uName;
        this.uEmail = uEmail;
        this.uSurName = uSurName;
        this.password = password;
    }
}
