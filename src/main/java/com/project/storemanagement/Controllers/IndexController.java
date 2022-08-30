package com.project.storemanagement.Controllers;

import com.project.storemanagement.Models.Empleado;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
@GetMapping({"/"})
    public String index(Model model) {
    Empleado empleado = new Empleado();
    empleado.getId();
    empleado.setNombre("isa");
    empleado.setEmail("@");
    return empleado.toString();
}


}
