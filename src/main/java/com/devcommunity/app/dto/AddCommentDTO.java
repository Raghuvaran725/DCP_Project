package com.devcommunity.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddCommentDTO {
    private String comment;
    private Integer developerId;
    private Integer postId;
    private Integer responseId;
    private Boolean isPost;
}
