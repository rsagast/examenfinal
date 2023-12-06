package com.example.examenfinal.controllers;

import com.example.examenfinal.models.entity.direccion;
import com.example.examenfinal.models.services.IDireccionService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.Map;

@Controller
@SessionAttributes("direccion")
public class DireccionController {

    private final IDireccionService direccionService;

    public DireccionController(IDireccionService direccionService) {
        this.direccionService = direccionService;
    }

//    @GetMapping ({"/",""})
//    public String inicio(Model model){
//        model.addAttribute("titulo", "Listado de Direcciones");
//        model.addAttribute("direcciones", direccionService.findAll());
//        return "listar";
//    }

    @RequestMapping(value = {"/listar","/",""}, method = RequestMethod.GET)
    public String listar(Model model) {
        model.addAttribute("titulo", "Listado de Direcciones");
        model.addAttribute("direcciones", direccionService.findAll());
        return "listar";
    }

    @RequestMapping(value = "/forma")
    public String crear(Map<String, Object> model) {
        direccion direccion = new direccion();
        model.put("direccion",direccion);
        model.put("titulo", "Formulario de Direcciones");
        return "forma";
    }

    @RequestMapping(value = "forma", method = RequestMethod.POST)
    public String guardar(@Valid direccion direccion, BindingResult result, Model model, SessionStatus status) {
        if (result.hasErrors()) {
            model.addAttribute("titulo", "Formulario de Direcciones");
            return "forma";
        }
        try{
            direccionService.save(direccion);
            status.setComplete();
            return "redirect:listar";
        }catch (Exception e){
            result.rejectValue("nombre","error.direccion","No se pudo grabar la dirección");
            model.addAttribute("titulo","Formulario de Direcciones");
            return "forma";
        }
    }

    @RequestMapping(value = "/forma/{id}")
    public String editar(@PathVariable(value = "id") Long id, Map<String, Object> model){
        direccion direccion = null;

        if(id>0){
            direccion = direccionService.findOne(id);
        }else{
            return "redirect:/listar";
        }
        model.put("direccion",direccion);
        model.put("titulo","Editar Dirección");

        return "forma";
    }

    @RequestMapping(value = "/eliminar/{id}")
    public String eliminar(@PathVariable(value = "id") Long id){
        if(id>0){
            direccionService.delete(id);
        }
        return "redirect:/listar";
    }

}