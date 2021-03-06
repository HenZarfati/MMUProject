package com.hit.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ProcessesPanel extends JPanel implements ListSelectionListener
{
	protected MMUView mainFrame;
	protected JList list;
	protected DefaultListModel model;
	protected int numOfProcesses;
	private Object source;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ProcessesPanel(MMUView MAINFRAME,int numOfP)
	{
		this.mainFrame= MAINFRAME;
		this.numOfProcesses=numOfP;

		model = new DefaultListModel();
		list = new JList(model);
		JLabel label = new JLabel("Processes:");

		JScrollPane scrollPane = new JScrollPane(list);
		//scrollPane.setPreferredSize(new Dimension(120,200));
		this.add(scrollPane, BorderLayout.CENTER);

		for (int i = 1; i <=numOfProcesses; i++)
			model.addElement("Process " + i);

		Border lineBorder = BorderFactory.createLineBorder(Color.BLACK, 1);
		list.setBorder(lineBorder);
		list.setFont(new Font("Arial",Font.BOLD,16));
		label.setFont(new Font("Arial",Font.ITALIC,18));

		list.addListSelectionListener(this);
		this.add(label);
		this.add(scrollPane, BorderLayout.CENTER);


	}


	@Override
	public void valueChanged(ListSelectionEvent e) 
	{
		if(e.getValueIsAdjusting()==false)
		{
			//System.out.println("Process: " + e.getFirstIndex());
			JList source = (JList) e.getSource();
			Object[] values = source.getSelectedValues();
			HashMap<String,Integer> processes = new HashMap<String,Integer>();
			for (int i = 0; i < values.length; i++)
			{
				String processnum = (String) values[i];
				processes.put(processnum.substring(processnum.indexOf(" ")+1), Integer.parseInt(processnum.substring(processnum.indexOf(" ")+1)));
			}
			mainFrame.gettingProcesses(processes);
		}

	}

}
