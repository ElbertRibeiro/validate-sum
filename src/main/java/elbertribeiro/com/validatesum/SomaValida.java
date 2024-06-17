package elbertribeiro.com.validatesum;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = SomaValidaValidator.class)
public @interface SomaValida {
    String message() default "A soma dos valores não é válida";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    String valor1();
    String valor2();
}
