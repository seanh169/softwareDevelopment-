package com.recipeproject.recipe.contollers;

import com.recipeproject.recipe.domain.Category;
import com.recipeproject.recipe.domain.UnitOfMeasure;
import com.recipeproject.recipe.repositories.CategoryRepository;
import com.recipeproject.recipe.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {

    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasure;

    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasure) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasure = unitOfMeasure;
    }


    @RequestMapping({"", "/", "/index"})
    public String getIndexPage() {
//        System.out.println("Messagssse");
//        Optional<Category> categoryOptional = categoryRepository.findOneByDescription("American");
//        Optional<UnitOfMeasure> unitOfMeasureOptional = unitOfMeasure.findByDescription("Teaspoon");

//        System.out.println("Cat Id is: " + categoryOptional.get().getId());

//        System.out.println("UOM ID is: " + unitOfMeasureOptional.get().getId());
        return "index";
    }

}
