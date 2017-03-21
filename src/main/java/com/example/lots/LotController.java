package com.example.lots;

import com.example.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Yurii on 21.03.2017.
 */
@RestController
public class LotController {

    @Autowired
    private LotService lotService;
/*@RequestMapping("/topics/{id}/courses")
    public List<Course> getAllCourses(@PathVariable String id){
        return courseService.getAllCourses(id);
    }*/
    @RequestMapping("/users/{username}/lots")
    public List<Lot> getAllLots(@PathVariable String username){
        return lotService.getAllLots(username);
    }
/* @RequestMapping("/topics/{topicId}/courses/{id}")
    public Course geCourse(@PathVariable String id){
        return courseService.getCourse(id);
    }*/

    @RequestMapping("/users/{username}/lots/{id}")
    public Lot getLot(@PathVariable String id){
        return lotService.getLot(id);
    }
/*@RequestMapping(method= RequestMethod.POST, value = "/topics/{topicId}/courses")
    public void addCourse(@RequestBody Course course , @PathVariable String topicId){
        course.setTopic(new Topic( topicId,"",""));
            courseService.addCourse(course);
    }*/
    @RequestMapping(method= RequestMethod.POST, value = "/users/{username}/lots")
    public void addLot(@RequestBody Lot lot, @PathVariable String username){
        lot.setUser(new User(username,"","", "",0));
        lotService.addLot(lot);
    }

/*@RequestMapping(method= RequestMethod.PUT, value ="/topics/{topicId}/courses/{id}")
    public void updateCourse(@RequestBody Course course,@PathVariable String topicId, @PathVariable String id){
        course.setTopic(new Topic( topicId,"",""));
        courseService.updateCourse(course);
    }*/
    @RequestMapping(method= RequestMethod.PUT, value = "/users/{username}/lots/{id}")
    public void updateLot(@RequestBody Lot lot, @PathVariable String username,@PathVariable String id){
        lot.setUser(new User(username,"","", "",0));
        lotService.updateLot(lot);
    }
/*@RequestMapping(method = RequestMethod.DELETE, value = "/topics/{topicId}/courses/{id}")
    public void  deleteCourse(@PathVariable String id){
            courseService.deleteCour(id);
    }*/
    @RequestMapping(method = RequestMethod.DELETE, value = "/users/{username}/lots/{id}")
    public void  deleteLot(@PathVariable String id){
        lotService.deleteLot(id);
    }

}
