package jpabook.jpashop.service;

import jakarta.persistence.EntityManager;
import jpabook.jpashop.domain.item.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ItemUpdateService {

    @Autowired
    EntityManager em;
    
    @Test
    public void ItemUpdateService() throws Exception{
        Book book = em.find(Book.class, 1L);

        //TX
        book.setName("asdfkdf");

        //변경감지 == dirty checking
        //TX commit



    }

}
