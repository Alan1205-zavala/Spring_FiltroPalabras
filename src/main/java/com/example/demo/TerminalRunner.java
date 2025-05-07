package com.example.demo;

import com.example.demo.service.WordFilterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

/**
 * Componente para interactuar con la aplicación desde la terminal.
 */
@Component
public class TerminalRunner implements CommandLineRunner {

    @Autowired
    private WordFilterService wordFilterService;

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenido al filtro de palabras. Escribe 'salir' para terminar.");
        System.out.println("Palabras prohibidas: " + wordFilterService.getForbiddenWords());

        while (true) {
            System.out.print("Ingresa tu mensaje: ");
            String message = scanner.nextLine();

            if ("salir".equalsIgnoreCase(message)) {
                break;
            }

            String filtered = wordFilterService.filterMessage(message);
            System.out.println("Mensaje filtrado: " + filtered);
        }

        scanner.close();
        System.out.println("Aplicación terminada.");
    }
}