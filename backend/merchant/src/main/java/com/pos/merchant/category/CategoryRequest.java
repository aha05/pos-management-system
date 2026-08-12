package com.pos.merchant.category;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CategoryRequest {
   @NotBlank(message = "Category Code is mandatory")
   private String categoryCode;

   @NotBlank(message = "Category Name is mandatory")
   private String categoryName;

   @NotBlank(message = "Description is mandatory")
   private String description;

   @NotNull(message = "Status is mandatory")
   private Boolean active;
}
