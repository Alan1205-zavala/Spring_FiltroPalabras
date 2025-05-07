package com.example.demo.service;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * Servicio que filtra palabras prohibidas en un mensaje.
 * Reemplaza palabras prohibidas con caracteres especiales o palabras alternativas.
 */
@Service
public class WordFilterService {

    private final List<String> forbiddenWords = Arrays.asList(
            "malapalabra", "inadecuado", "prohibido", "nocivo", "ofensivo"
    );

    private final String replacement = "!#?%@";

    /**
     * Filtra un mensaje reemplazando palabras prohibidas.
     *
     * @param message El mensaje a filtrar
     * @return El mensaje filtrado o una advertencia si hay demasiadas palabras prohibidas
     */
    public String filterMessage(String message) {
        String[] words = message.split("\\s+");
        int forbiddenCount = 0;

        for (int i = 0; i < words.length; i++) {
            if (forbiddenWords.contains(words[i].toLowerCase())) {
                words[i] = replacement;
                forbiddenCount++;
            }
        }

        if (forbiddenCount > 3) {
            return "ADVERTENCIA: Tu mensaje contiene demasiadas palabras prohibidas.";
        }

        return String.join(" ", words);
    }

    /**
     * Obtiene la lista de palabras prohibidas.
     *
     * @return Lista de palabras prohibidas
     */
    public List<String> getForbiddenWords() {
        return forbiddenWords;
    }
}