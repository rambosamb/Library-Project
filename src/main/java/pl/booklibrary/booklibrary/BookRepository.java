package pl.booklibrary.booklibrary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

//komunikacja z baza danych
@Repository
public class BookRepository {


    @Autowired
    JdbcTemplate jdbcTemplate;


    public List<Book> getAll(){
        return jdbcTemplate.query("SELECT id,title,review,author FROM book", BeanPropertyRowMapper.newInstance(Book.class));
    }

    public Book getById(int id){
        return jdbcTemplate.queryForObject("SELECT id,title,review,author FROM book WHERE " + "id=?", BeanPropertyRowMapper.newInstance(Book.class), id);
    }

    public int addBook(List<Book> book){
        for (int i = 0; i<book.size(); i++){
            jdbcTemplate.update("INSERT INTO book(title,review,author) VALUES(?,?,?)", book.get(i).getTitle(),book.get(i).getReview(),book.get(i).getAuthor());
        }
        return 1;
    }

    public int updateBook(Book book){
        jdbcTemplate.update("UPDATE book SET title=?, review=?, author=? WHERE id=?", book.getTitle(),book.getReview(),book.getAuthor(),book.getId());
        return 1;
    }

    public int deleteBook(int id){
        jdbcTemplate.update("DELETE FROM book WHERE id=?", id);
        return 1;
    }






}
