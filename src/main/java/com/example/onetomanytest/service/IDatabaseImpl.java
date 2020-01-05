package com.example.onetomanytest.service;

import com.example.onetomanytest.domain.Category;
import com.example.onetomanytest.domain.Item;
import com.example.onetomanytest.repository.CategoryRepository;
import com.example.onetomanytest.repository.ItemRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class IDatabaseImpl implements IDatabase {

    private final CategoryRepository categoryRepository;

    private final ItemRepository itemRepository;

    public IDatabaseImpl(CategoryRepository categoryRepository, ItemRepository itemRepository) {
        this.categoryRepository = categoryRepository;
        this.itemRepository = itemRepository;
    }

    @Override
    @Transactional
    public void createDatabase() {

        Category c1 = new Category();
        c1.setName("Frits");

        Category c2 = new Category();
        c2.setName("Meat");

        Item t1 = new Item("Apple" , 12 , 5000);
        Item t2 = new Item( "Orange" , 10 , 6000);
        Item t3 = new Item( "fish" , 3 , 54000);
        Item t4 = new Item( "beaf" , 6 , 40000);

        t1.setCategory(c1);
        t2.setCategory(c1);

        t3.setCategory(c2);
        t4.setCategory(c2);

        categoryRepository.save(c1);
        categoryRepository.save(c2);

        itemRepository.save(t1);
        itemRepository.save(t2);
        itemRepository.save(t3);
        itemRepository.save(t4);

    }
}
