package jautopecas.components.anotacao;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
// Declaração da interface
public @interface AnotacaoNomeColuna {

    public String nome();

    public String descricao();
}
