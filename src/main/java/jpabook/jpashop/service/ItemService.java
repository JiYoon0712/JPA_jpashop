package jpabook.jpashop.service;

import jpabook.jpashop.domain.Item;
import jpabook.jpashop.domain.item.Book;
import jpabook.jpashop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    @Transactional  // 오버라이딩 ( readOnly X )
    public void savaItem(Item item){
        itemRepository.save(item);
    }

    // 변경감지.. 머지 대신 변경감지를 사용하는 것을 권장.
    // set을 직접 사용하여 변경하는 것 지양. > change 등 엔티티 안에서 바로 추적할 수 있는 메소드 만들기.
    @Transactional
    public void updateItem(Long itemId, String name, int price, int stockQuantity){
        Item findItem = itemRepository.findOne(itemId); //영속 상태
        findItem.setName(name);
        findItem.setPrice(price);
        findItem.setStockQuantity(stockQuantity);
    }

    public List<Item> findItems(){
        return itemRepository.findAll();
    }

    public Item findOne(Long itemId){
        return itemRepository.findOne(itemId);
    }

}
