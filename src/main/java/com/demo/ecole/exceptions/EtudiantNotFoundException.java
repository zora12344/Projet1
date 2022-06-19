package com.demo.ecole.exceptions;

import com.demo.ecole.entities.Etudiant;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class EtudiantNotFoundException extends RuntimeException {

    public EtudiantNotFoundException(String message){
        super(message);
    }


}
