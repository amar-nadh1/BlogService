package com.example.BlogsandComments.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor


public class AddBlog {

    private String title;
    private String description;
    private long userid;

}
