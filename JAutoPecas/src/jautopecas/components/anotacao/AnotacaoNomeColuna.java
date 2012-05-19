package jautopecas.components.anotacao;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

@Target (ElementType.FIELD)
@Retention (RetentionPolicy.RUNTIME)

// Declaração da interface
public @interface AnotacaoNomeColuna {
    public String nome();
    public String descricao();
    
//    public String getNome(Object t){
//        Class c1 = t.getClass();
//        Field[] field = c1.getDeclaredField(null);
//
//        for(Field f: field){
//            limite lim = f.getAnnotation(limite.class);
//
//            // se achou a anotação
//            if(lim != null){
//                if(f.getName().equals("idade")){
//                    if(lim.minimo() > c1.getField("idade").getInt(t)){
//                        System.out.println("O valor mínimo do campo Idade é "+lim.minimo());
//                    }
//
//                    if(lim.maximo() < c1.getField("idade").getInt(t)){
//                        System.out.println("O valor máximo do campo Idade é "+lim.maximo());
//                    }
//                }
//            }
//        }
//    }
}
