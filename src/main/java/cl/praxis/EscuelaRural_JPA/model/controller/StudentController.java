package cl.praxis.EscuelaRural_JPA.model.controller;


import cl.praxis.EscuelaRural_JPA.model.entity.Student;
import cl.praxis.EscuelaRural_JPA.model.service.ICourseService;
import cl.praxis.EscuelaRural_JPA.model.service.IStudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/students")
public class StudentController {
    private final IStudentService service;
    private final ICourseService courseService;

    public StudentController(IStudentService service, ICourseService courseService) {
        this.service = service;
        this.courseService = courseService;
    }

    @GetMapping
    public String findAll(Model model){
        model.addAttribute("students", service.findAll());
        return "studentsList";
    }

    @GetMapping("/{id}")
    public String findOne(@PathVariable("id") int id, Model model){
        model.addAttribute("student", service.findOne(id));
        model.addAttribute("courses", courseService.findAll());
        return "studentEdit";
    }
    @PostMapping
    public String update(@ModelAttribute Student student){
        boolean result = service.update(student);
        return "redirect:/students";
    }

    @GetMapping("/new")
    public String toCreate(Model model){
        model.addAttribute("courses", courseService.findAll());
        return "studentNew";
    }

    @PostMapping("/new")
    public String create(@ModelAttribute Student student){
        boolean result = service.create(student);

        return "redirect:/students";
    }
    @GetMapping("/{id}/del")
    public String delete(@PathVariable("id") int id){
        boolean result = service.delete(id);

        return "redirect:/films";
    }

}
