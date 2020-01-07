package org.ccw.store.inventory.controller;

import java.util.List;
import java.util.Optional;
import org.ccw.store.inventory.dto.CategoryDTO;
import org.ccw.store.inventory.model.Category;
import org.ccw.store.inventory.repo.CategoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("categories")
public class CategoryController {

    private Logger logger = LoggerFactory.getLogger(CategoryController.class);

    @Autowired
    private CategoryRepository categoryRepository;

    @RequestMapping(method = RequestMethod.POST)
    public Optional<Category> newInventory(@RequestBody CategoryDTO categoryDTO) {
        Category c = new Category();
        c.setName(categoryDTO.getCategoryName());
        if (categoryDTO.getParentCategoryName() != null){
            // it is a sub category
            List<Category> list = categoryRepository.findByName(categoryDTO.getParentCategoryName());
            if (list != null && !list.isEmpty()){
                c.setParentCategory(list.get(0));
            }
        }
        categoryRepository.saveAndFlush(c);
        return Optional.of(c);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @RequestMapping(path = "/page/{pageid}", method = RequestMethod.GET)
    public Page<Category> getAllInventoriesWithPage(@PathVariable int pageid, @RequestParam("size") int size) {
        return categoryRepository.findAll(PageRequest.of(pageid, size));
    }

    @GetMapping(path = "/name/{name}")
    public List<Category> findByName(@PathVariable(name="name") String name){
        logger.debug("query by name");
        return categoryRepository.findByName(name);
    }

    @DeleteMapping("/{id}")
    void deleteEmployee(@PathVariable Long id) {
        categoryRepository.deleteById(id);
    }
}
