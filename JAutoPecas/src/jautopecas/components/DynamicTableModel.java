package jautopecas.components;

import jautopecas.components.anotacao.AnotacaoNomeColuna;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

public class DynamicTableModel extends AbstractTableModel {
    
    private List<String> columnFields = new ArrayList<>();
    private List<String> columnNames = new ArrayList<>();
    private List<Class> classeFields = new ArrayList<>();
    private List data = null;
    private boolean inicializado = false;
    
    public List getData() {
        return data;
    }
    
    public void setData(List dataset) throws IntrospectionException {
        data = dataset;
        if (data != null && data.size() > 0) {
            fireTableDataChanged();
        }
    }
    
    public List<String> getColumnNames() {
        return columnNames;
    }
    
    public DynamicTableModel(List dataset) throws IntrospectionException {
        super();
        initModel(dataset);
    }
    
    private void initModel(List dataset) throws IntrospectionException {
        //System.out.println("dataset.size() = " + dataset.size());
        if (dataset.size() > 0) {
            Class c = dataset.get(0).getClass();
            //System.out.println(c.getName());

            PropertyDescriptor[] p = java.beans.Introspector.getBeanInfo(c, Object.class).getPropertyDescriptors();
            columnFields.clear();
            columnNames.clear();
            classeFields.clear();
            for (int i = 0; i < p.length; i++) {
                if (p[i].getReadMethod().getReturnType().toString().contains("entidades")
                        || p[i].getReadMethod().getReturnType().toString().contains("List")) {
                    continue;
                }
                String s = p[i].getReadMethod().getName();
                s = s.substring(3);
                columnFields.add(s);
                classeFields.add(p[i].getReadMethod().getDeclaringClass());
                columnNames.add(getNomeColuna(classeFields.get(classeFields.size() - 1), s));
            }
            data = dataset;
            inicializado = true;
        } else {
            inicializado = false;
        }
    }
    
    private String getNomeColuna(Class c, String fieldName) {
        try {
            String nomeField = fieldName.substring(0, 1).toLowerCase() + fieldName.substring(1);
            Field field = c.getDeclaredField(nomeField);
            AnotacaoNomeColuna anotacao = field.getAnnotation(AnotacaoNomeColuna.class);
            if (anotacao != null) {
                return anotacao.nome();
            }
        } catch (NoSuchFieldException | SecurityException ex) {
            Logger.getLogger(DynamicTableModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fieldName;
    }
    
    @Override
    public Class getColumnClass(int c) {
        //System.out.println("getColumnClass(int c) = " + c);
        return getValueAt(0, c).getClass();
    }
    
    @Override
    public int getColumnCount() {
        if (columnNames == null) {
            return 0;
        } else {
            //System.out.println("getColumnCount = " + columnNames.length);
            return columnNames.size();
        }
    }
    
    @Override
    public int getRowCount() {
        if (data == null) {
            return 0;
        } else {
            return data.size();
        }
    }
    
    @Override
    public String getColumnName(int col) {
        return columnNames.get(col);
    }
    
    public Object getObjectAtRow(int row) {
        Object o = null;
        if (data != null && data.size() > 0 && row < data.size()) {
            o = data.get(row);
        }
        return o;
    }
    
    public List<Object> getObjectAtRows(int[] rows) {
        ArrayList<Object> os = new ArrayList<>();
        if (data.size() > 0) {
            for (int i : rows) {
                if (data.size() > i) {
                    os.add(data.get(i));
                }
            }
        }
        return os;
    }
    
    @Override
    public Object getValueAt(int row, int col) {
        Object o = null;
        if (data.size() > 0 && row < data.size()) {
            try {
                Object oRow = data.get(row);
                Method method = classeFields.get(col).getMethod("get" + columnFields.get(col), new Class[]{});
                Class t = method.getReturnType();
                if (t.isPrimitive()) {
                    Object objResult;
                    if (t.equals(java.lang.Integer.TYPE) || t.getName().equals("int")) {
                        objResult = method.invoke(oRow, new Object[]{});
                        o = Integer.valueOf(objResult != null ? objResult.toString() : "0");
                    } else if (t.equals(java.lang.Boolean.TYPE) || t.getName().equals("boolean")) {
                        objResult = method.invoke(oRow, new Object[]{});
                        o = Boolean.valueOf(objResult != null ? objResult.toString() : "true");
                    } else if (t.equals(java.lang.Float.TYPE) || t.getName().equals("float")) {
                        objResult = method.invoke(oRow, new Object[]{});
                        o = Float.valueOf(objResult != null ? objResult.toString() : "0");
                    } else if (t.equals(java.lang.Long.TYPE) || t.getName().equals("long")) {
                        objResult = method.invoke(oRow, new Object[]{});
                        o = Long.valueOf(objResult != null ? objResult.toString() : "0");
                    } else {
                        o = oRow;
                    }
                } else {
                    //System.out.println("Nao primitivo t.getName() = " + t.getName());
                    Object objResult;
                    switch (t.getName()) {
                        case "java.lang.String":
                            objResult = method.invoke(oRow, new Object[]{});
                            o = objResult != null ? objResult.toString() : "";
                            break;
                        case "java.lang.Integer":
                            objResult = method.invoke(oRow, new Object[]{});
                            o = Integer.valueOf(objResult != null ? objResult.toString() : "0");
                            break;
                        
                        case "java.lang.Long":
                            objResult = method.invoke(oRow, new Object[]{});
                            o = Long.valueOf(objResult != null ? objResult.toString() : "0");
                            break;
                        
                        case "java.lang.Double":
                            objResult = method.invoke(oRow, new Object[]{});
                            o = Double.valueOf(objResult != null ? objResult.toString() : "0.000");
                            break;
                        default:
                            o = oRow;
                            break;
                    }
                }
            } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                //System.out.println("ex = " + ex);
                Logger.getLogger(DynamicTableModel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return o;
    }
    
    public boolean isInicializado() {
        return inicializado;
    }
}
