package ru.aladonin.restaurantapi.food;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.aladonin.restaurantapi.utils.Transcriptor;

import java.util.List;
import java.util.Optional;

@Service

public class FoodServiceImpl  implements FoodService{

    private Transcriptor transcriptor;
    private FoodRepository foodRepository;

    @Autowired
    public FoodServiceImpl(Transcriptor transcriptor, FoodRepository foodRepository) {
        this.transcriptor = transcriptor;
        this.foodRepository = foodRepository;
    }

    public Food createFood(Food food) {
        String russianToLatin = transcriptor.russianToLatin(food.getTitle());
        food.setTransliteration(russianToLatin.toLowerCase());
        return foodRepository.save(food);
    }

    public Optional<Food> getFoodById(Long id) {
        if (foodRepository.findById(id).isEmpty()) {
            throw new FoodNotFoundException("Requested Category does not exist");
        }
        return foodRepository.findById(id);
    }

    public List<Food> getFoodAll() {
        return foodRepository.findAll();
    }

    public List<Food> getFoodByCategory(String latin){
        return foodRepository.getFoodsByCategoryTransliteration(latin);
    }

    public void deleteFood(Long id) {
        if (foodRepository.findById(id).isEmpty()) {
            throw new FoodNotFoundException("Requested Food does not exist");
        }
        foodRepository.deleteById(id);
    }
}
