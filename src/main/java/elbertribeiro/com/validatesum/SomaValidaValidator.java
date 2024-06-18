package elbertribeiro.com.validatesum;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.Field;

public class SomaValidaValidator implements ConstraintValidator<SomaValida, Object> {

    private String valor1Field;
    private String valor2Field;
    private String valor3Field;

    @Override
    public void initialize(SomaValida constraintAnnotation) {
        this.valor1Field = constraintAnnotation.valor1();
        this.valor2Field = constraintAnnotation.valor2();
        this.valor3Field = constraintAnnotation.soma();
    }

    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context) {
        try {
            Class<?> clazz = obj.getClass();

            Field field1 = clazz.getDeclaredField(valor1Field);
            Field field2 = clazz.getDeclaredField(valor2Field);
            Field field3 = clazz.getDeclaredField(valor3Field);

            field1.setAccessible(true);
            field2.setAccessible(true);
            field3.setAccessible(true);

            Double valor1 = (Double) field1.get(obj);
            Double valor2 = (Double) field2.get(obj);
            Double valor3 = (Double) field3.get(obj);


            return valor1 != null && valor2 != null && valor1 + valor2 == valor3;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
