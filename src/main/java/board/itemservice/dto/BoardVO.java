package board.itemservice.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class BoardVO {
    private int num;
    private String title;
    private String description;
    private String author;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
}
