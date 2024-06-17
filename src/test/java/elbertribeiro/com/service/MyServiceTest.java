package elbertribeiro.com.service;

import elbertribeiro.com.dto.GenericDTO;
import org.junit.Before;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MyServiceTest {

    private Validator validator;

    @Before
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testSomaValida() {
        GenericDTO obj = new GenericDTO();
        obj.setValor1(10.0);
        obj.setValor2(20.0);
        obj.setSoma(30.0); // Esta soma é válida
        Set<ConstraintViolation<GenericDTO>> violations = validator.validate(obj);
        for (ConstraintViolation<GenericDTO> violation : violations) {
            System.out.println(violation.getMessage());
        }

        System.out.println(violations.size());
        assertTrue(violations.isEmpty());
    }

    @Test
    public void testSomaInvalida() {
        GenericDTO obj = new GenericDTO();
        obj.setValor1(10.0);
        obj.setValor2(20.0);
        obj.setSoma(25.0); // Esta soma é inválida

        Set<ConstraintViolation<GenericDTO>> violations = validator.validate(obj);
        assertFalse(violations.isEmpty());

        // Verifica se a mensagem de erro é a esperada
        violations.forEach(violation -> {
            System.out.println(violation.getMessage());
            assertTrue(violation.getMessage().contains("A soma dos valores não é válida"));
        });
    }
}
