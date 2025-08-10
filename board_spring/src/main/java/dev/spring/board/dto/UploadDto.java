package dev.spring.board.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UploadDto {
    private int fileId;        // FILE_ID (시퀀스/IDENTITY)
    private String boardId;     // BOARD_ID
    private int boardSeq;      // BOARD_SEQ
    private Integer attachIdx;  // ATTACH_IDX

    private String origName;    // ORIG_NAME
    private String storedName;  // STORED_NAME
    private String relPath;     // REL_PATH
    private String contentType; // CONTENT_TYPE
    private long fileSize;      // FILE_SIZE
    private String userId;  // UPLOADER_ID

}    
