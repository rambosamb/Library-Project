package pl.booklibrary.booklibrary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/book")
@RestController
public class BookControler {
    @Autowired
    BookRepository bookRepository;

    @GetMapping("/test")
    public int test(){
        return 1;
    }

    @GetMapping("")
    public List<Book> getAll(){
        return bookRepository.getAll();
    }

    @GetMapping("/{id}")
    public Book getById(@PathVariable("id") int id){
         return bookRepository.getById(id);
    }

    @PostMapping ("")
    public int addBook(@RequestBody List<Book> book){
        return bookRepository.addBook(book);
    }

    @PutMapping("/{id}")
    public int updateBook(@PathVariable("id") int id, @RequestBody Book updatedBook){
        Book book = bookRepository.getById(id);
        if (book != null){
            book.setTitle(updatedBook.getTitle());
            book.setAuthor(updatedBook.getAuthor());
            book.setReview(updatedBook.getReview());
            bookRepository.updateBook(book);
            return 1;
        }else
        {
            return -1;
        }
    }

    @PatchMapping("/{id}")
    public int partiallyUpdate(@PathVariable("id") int id, @RequestBody Book updatedBook){
        Book book = bookRepository.getById(id);
        if (book != null){
            if (updatedBook.getTitle() != null) book.setTitle(updatedBook.getTitle());
            if (updatedBook.getReview() > 0) book.setReview(updatedBook.getId());
            if (updatedBook.getAuthor() != null) book.setAuthor(updatedBook.getAuthor());
            bookRepository.updateBook(book);
            return 1;
        }else
        {
            return -1;
        }
    }

    @DeleteMapping("/{id}")
    public int delete(@PathVariable("id") int id){
        return bookRepository.deleteBook(id);
    }


}
