package ru.javawebinar.topjava.web.meal;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.to.MealWithExceed;

import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequestMapping("/ajax/meals")

public class MealAjaxController extends AbstractMealController {


    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id) {
        super.delete(id);
    }

    @Override
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<MealWithExceed> getAll() {
        return super.getAll();
    }


    @PostMapping
    public void create(@RequestParam("id") Integer id,
                       @RequestParam("dateTime") String dateTime,
                       @RequestParam("description") String description,
                       @RequestParam("calories") Integer calories) {
        LocalDateTime localDateTime = LocalDateTime.parse(dateTime);
        Meal meal = new Meal(id, localDateTime, description, calories);
        if (meal.isNew()) {
            super.create(meal);
        }

    }
}