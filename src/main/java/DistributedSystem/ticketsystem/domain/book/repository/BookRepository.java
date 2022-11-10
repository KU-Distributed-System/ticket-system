package DistributedSystem.ticketsystem.domain.book.repository;

import DistributedSystem.ticketsystem.domain.book.domain.Book;
import DistributedSystem.ticketsystem.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByUser(User user);
}
