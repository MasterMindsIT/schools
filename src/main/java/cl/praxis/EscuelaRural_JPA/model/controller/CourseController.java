package cl.praxis.EscuelaRural_JPA.model.controller;

import cl.praxis.EscuelaRural_JPA.model.entity.Course;
import cl.praxis.EscuelaRural_JPA.model.service.ICourseService;
import cl.praxis.EscuelaRural_JPA.model.service.IStudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/courses")
public class CourseController {

    private final ICourseService service;
    private final IStudentService studentService;

    public CourseController(ICourseService service, IStudentService studentService) {
        this.service = service;
        this.studentService = studentService;
    }

    @GetMapping
    public String findAll(Model model){
        model.addAttribute("courses", service.findAll());
        System.out.println(service.findAll().toString());
        return "coursesList";
    }

    @GetMapping("/{id}")
    public String findOne(@PathVariable("id") int id, Model model){
        model.addAttribute("course", service.findOne(id));
        model.addAttribute("Students", studentService.findAll());
        return "coursesEdit";
    }

    @PostMapping
    public String update(@ModelAttribute Course course){
        boolean result = service.update(course);
        return "redirect:/courses";
    }

    @GetMapping("/new")
    public String toCreate(){

        return "courseNew";
    }

    @PostMapping("/new")
    public String create(@ModelAttribute Course course){
        boolean result = service.create(course);

        return "redirect:/courses";
    }
    @GetMapping("/{id}/del")
    public String delete(@PathVariable("id") int id){
        boolean result = service.delete(id);

        return "redirect:/courses";
    }


}
