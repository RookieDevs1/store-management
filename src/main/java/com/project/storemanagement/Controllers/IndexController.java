package com.project.storemanagement.Controllers;

import com.project.storemanagement.Models.Empleado;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping
public class IndexController {
@GetMapping({"/"})
    public String index(Model model) {
//  //  empleado.setNombre("Hola");
    Empleado empleado = new Empleado();

    empleado.getId();
    empleado.setNombre("isa");
    empleado.setEmail("@");
    //empleado.getNombre();
    //model.addAttribute("titulo", "hola Mundo");


    return empleado.toString();
}


}
