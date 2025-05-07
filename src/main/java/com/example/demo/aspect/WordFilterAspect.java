package com.example.demo.aspect;

import com.example.demo.service.WordFilterService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Aspecto que intercepta los mensajes para aplicar el filtrado de palabras.
 */
@Aspect
@Component
public class WordFilterAspect {

    @Autowired
    private WordFilterService wordFilterService;

    /**
     * Intercepta los métodos que procesan mensajes y aplica el filtrado.
     *
     * @param joinPoint Punto de unión del aspecto
     */
    @Before("execution(* com.example.wordfilter.controller.*.*(..)) && args(message)")
    public void filterMessage(JoinPoint joinPoint, String message) {
        String filteredMessage = wordFilterService.filterMessage(message);
        // Reemplaza el parámetro original con el mensaje filtrado
        Object[] args = joinPoint.getArgs();
        args[0] = filteredMessage;
    }
}
