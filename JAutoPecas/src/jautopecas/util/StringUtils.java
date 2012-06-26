/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jautopecas.util;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author JFFiorotto
 */
public class StringUtils {

    public static Date stringToDate(String data) throws Exception {
        if (data == null || data.equals("")) {
            return null;
        }
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = (java.util.Date) formatter.parse(data);
        return date;
    }

    public static String dateToString(Date d) throws Exception {
        if (d == null) {
            return "";
        }
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        return formatter.format(d);
    }

    public static BigDecimal stringToBigDecimal(String s) throws Exception {
        s = s.replace(".", "");
        s = s.replace(",", ".");
        return new BigDecimal(s);
    }

    public static String BigDecimalToString(BigDecimal b) throws Exception {
        DecimalFormat formatter = new DecimalFormat("#,##0.00");
        return formatter.format(b);
    }
}
