package jautopecas.entidades.produto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JFFIorotto
 */
public class ImportacaoProduto {

//SELECT A.CREF,A.CDESC,C.IEAN13,'',1,1,1,1,A.FPESOL,A.FPESOL,A.CUN,A.CUN,A.IIDFO,A.CCF,B.CTEXTO,IF(A.CKIT='F','I','A'),0,0,0,0,'RE','',A.CST
//FROM CEPRODUTO A 
//LEFT OUTER JOIN CDCARACTERISTICA B ON (B.IIDPROD=A.IIDPROD AND B.CTCARAC = 'A')
//LEFT OUTER JOIN CEBARRAS C ON(C.IIDPROD = A.IIDPROD)
    
    public void leCsvCadastroProduto() {
        try {
            BufferedReader in = new BufferedReader(new FileReader("C:/teste.csv"));
            String linha;
            while ((linha = in.readLine()) != null) {
                String conteudo[] = linha.split(";");
                //ex de linha: 1234;abc;22/11/1980
                System.out.println(conteudo[0]);//imprime 1234
                System.out.println(conteudo[1]);//imprime 22/11/1980
                System.out.println(conteudo[2]);//imprime 22/11/1980

            }
        } catch (IOException ex) {
            Logger.getLogger(ImportacaoProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
