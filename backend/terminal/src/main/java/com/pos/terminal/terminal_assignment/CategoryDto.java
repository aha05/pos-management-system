package com.pos.terminal.terminal_assignment;

import lombok.Data;

@Data
public class CategoryDto {
    private Long id;
    private String categoryCode;
    private String categoryName;
    private String description;
    private Boolean active;
}
