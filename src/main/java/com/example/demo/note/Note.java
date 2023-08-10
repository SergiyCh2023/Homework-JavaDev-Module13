package com.example.demo.note;

import lombok.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Service
public class Note {
    public Note(String title, String content) {
        this.title = title;
        this.content = content;
    }


    private long id ;
    private String title;
    private String content;

}
