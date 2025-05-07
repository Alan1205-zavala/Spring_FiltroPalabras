package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Controlador para manejar la entrada y salida de mensajes.
 */
@Controller
public class MessageController {

    /**
     * Muestra el formulario para ingresar mensajes.
     *
     * @return La vista del formulario
     */
    @GetMapping("/")
    public String showForm() {
        return "message-form";
    }

    /**
     * Procesa el mensaje enviado por el usuario.
     *
     * @param message El mensaje a procesar
     * @param model   Modelo para pasar datos a la vista
     * @return La vista con el resultado del filtrado
     */
    @PostMapping("/submit")
    public String processMessage(@RequestParam String message, Model model) {
        model.addAttribute("originalMessage", message);
        model.addAttribute("filteredMessage", message); // El aspecto modificará esto
        return "message-result";
    }
}