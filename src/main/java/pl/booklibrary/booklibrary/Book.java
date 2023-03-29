package pl.booklibrary.booklibrary;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Book {
    private int id;
    private String title;
    private int review;
    private String author;
}
