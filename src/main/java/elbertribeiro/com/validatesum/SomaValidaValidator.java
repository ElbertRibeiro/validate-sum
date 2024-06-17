package elbertribeiro.com.validatesum;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.Field;

public class SomaValidaValidator implements ConstraintValidator<SomaValida, Double> {

    private String valor1Field;
    private String valor2Field;

    @Override
    public void initialize(SomaValida constraintAnnotation) {
        this.valor1Field = constraintAnnotation.valor1();
        this.valor2Field = constraintAnnotation.valor2();
    }

    @Override
    public boolean isValid(Double soma, ConstraintValidatorContext context) {
        try {
            // Obtenha a classe onde a anotação foi usada
            Object bean = context.unwrap(Object.class);
            Class<?> clazz = bean.getClass();

            // Obtenha os campos dos valores
            Field field1 = clazz.getDeclaredField(valor1Field);
            Field field2 = clazz.getDeclaredField(valor2Field);

            // Torne os campos acessíveis
            field1.setAccessible(true);
            field2.setAccessible(true);

            // Obtenha os valores dos campos
            Double valor1 = (Double) field1.get(bean);
            Double valor2 = (Double) field2.get(bean);

            // Verifique se a soma dos valores é igual ao valor anotado
            return valor1 != null && valor2 != null && valor1 + valor2 == soma;

        } catch (NoSuchFieldException | IllegalAccessException e) {
            // Em caso de erro, considere a validação falha
            e.printStackTrace();
            return false;
        }
    }
}
