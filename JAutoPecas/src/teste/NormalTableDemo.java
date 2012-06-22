/*
 *NormalTableDemo.java   Feb 23, 2008
 * Developer: sandarenu
 * Copyright (c) 2006-2008 Minimuthu Software Developers.
 * Sri Lanka.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of 
 * Minimuthu Software Developers. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Minimuthu.
 */
package teste;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * @author sandarenu
 *
 */
public class NormalTableDemo
{	
	public NormalTableDemo(Image icon)
	{
		DefaultTableModel model  = new DefaultTableModel();
		model.addColumn("CF Source");
		model.addColumn("Client");
		model.addColumn("Spouse");
		model.addColumn("Family");
		model.addRow(new Object[]{"Salary1","250001","50001","3000001"});
		model.addRow(new Object[]{"Salary1","250001","50001","3000001"});
		model.addRow(new Object[]{"Salary1","250001","50001","3000001"});
		model.addRow(new Object[]{"Salary1","250001","50001","3000001"});
		model.addRow(new Object[]{"Salary1","250001","50001","3000001"});
		
		JTable table = new JTable(model); 
		
		JFrame frame = new JFrame("Normal Table Demo");
        frame.getContentPane().add(new JScrollPane(table));
        frame.setSize(new java.awt.Dimension(400, 400));
        frame.setLocation(280, 50);
        frame.setIconImage(icon);
        frame.setVisible(true);
	}

}
