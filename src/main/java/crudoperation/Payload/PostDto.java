package crudoperation.Payload;

import lombok.Data;

@Data
public class PostDto {
    private long id;
    private String name;
    private String email;
    private Long mobile;

}
