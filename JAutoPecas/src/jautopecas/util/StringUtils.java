/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jautopecas.util;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author JFFiorotto
 */
public class StringUtils {

    /**
     * Converte uma String para um objeto Date. Caso a String seja vazia ou
     * nula, retorna null - para facilitar em casos onde formulários podem ter
     * campos de datas vazios.
     *
     * @param data String no formato dd/MM/yyyy a ser formatada
     * @return Date Objeto Date ou null caso receba uma String vazia ou nula
     * @throws Exception Caso a String esteja no formato errado
     */
    public static Date stringToDate(String data) throws Exception {
        if (data == null || data.equals("")) {
            return null;
        }

        Date date = null;
        try {
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            date = (java.util.Date) formatter.parse(data);
        } catch (ParseException e) {
            throw e;
        }
        return date;
    }

    public static String dateToString(Date data) throws Exception {
        if (data == null) {
            return "";
        }
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        return formatter.format(data);
    }

    public static BigDecimal stringToBigDecimal(String s) {
        try {
            s = s.replace(".", "");
            s = s.replace(",", ".");
            return new BigDecimal(s);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
