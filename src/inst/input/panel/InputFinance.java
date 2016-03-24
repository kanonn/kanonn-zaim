package inst.input.panel;

import inst.common.Tools;
import inst.input.panel.panelLogic.InputFinanceLogic;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.apache.log4j.Logger;

public class InputFinance {
	private static Logger log = Logger.getLogger(InputFinance.class);
	
	JPanel pagePanel;
	
	private JTextField startDate;
	private JTextField item_name_L;
	private JTextField item_id_L;
	private JTextField item_amout_L;
	private JTextField item_name_R;
	private JTextField item_id_R;
	private JTextField item_amout_R;
	private JTextField comment;
	private JTextField source;
	private JButton submit;
	
	public InputFinance(){
		createPagePanel();
	}
	
	private JPanel createPagePanel(){
		pagePanel = new JPanel();
		
		pagePanel.setLayout(new GridBagLayout());
		pagePanel.setBorder(BorderFactory.createLineBorder(Color.RED));
		
		pagePanel.setPreferredSize(new Dimension(700, 100));
		GridBagConstraints constraints = new GridBagConstraints();
		
		//Line 1 ***************************************************************************************************************************
		//StartDate
		JLabel labelStartDate = new JLabel("START",SwingConstants.RIGHT);
		Tools.addCompnentForGridLayout(pagePanel, labelStartDate, constraints, 0, 0, 1, 1);

		//Line 2 ****************************************************************************************************************************
		//
		JLabel labelFileName = new JLabel("time",SwingConstants.RIGHT);
		labelFileName.setPreferredSize(new Dimension(70, 20));
		startDate = new JTextField("20160324");
		startDate.setPreferredSize(new Dimension(70, 20));
		item_name_L = new JTextField("");
		item_name_L.setPreferredSize(new Dimension(70, 20));
		item_amout_L = new JTextField("");
		item_amout_L.setPreferredSize(new Dimension(70, 20));
		item_name_R = new JTextField("");
		item_name_R.setPreferredSize(new Dimension(70, 20));
		item_amout_R = new JTextField("");
		item_amout_R.setPreferredSize(new Dimension(70, 20));
		Tools.addCompnentForGridLayout(pagePanel, labelFileName, constraints, 0, 1, 2, 1);
		Tools.addCompnentForGridLayout(pagePanel, startDate, constraints, 2, 1, 2, 1);
		Tools.addCompnentForGridLayout(pagePanel, item_name_L, constraints, 4, 1, 2, 1);
		Tools.addCompnentForGridLayout(pagePanel, item_amout_L, constraints, 6, 1, 2, 1);
		Tools.addCompnentForGridLayout(pagePanel, item_name_R, constraints, 8, 1, 2, 1);
		Tools.addCompnentForGridLayout(pagePanel, item_amout_R, constraints, 10, 1, 2, 1);
		
		//Line 3 ******************************************************************************************************************************
		//
		JButton btnBack = new JButton("submit");
		btnBack.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				List<String> dataList = new ArrayList<String>();
				dataList.add(startDate.getText());
				dataList.add(item_name_L.getText());
				dataList.add(item_amout_L.getText());
				dataList.add(item_name_R.getText());
				dataList.add(item_amout_R.getText());
				
				InputFinanceLogic logic = new InputFinanceLogic();
				logic.setDataList(dataList);
				logic.insertData();
		}});
		
		Tools.addCompnentForGridLayout(pagePanel, btnBack, constraints, 0, 2, 2, 1);
		
		return pagePanel;
	}

	public JPanel getPagePanel() {
		return pagePanel;
	}
	
	/**
	 * 
	 */
//	private void changePage(int addtion){
//		int localpage = Integer.valueOf(conditonMap.get("localPage"));
//		conditonMap.put("localPage", String.valueOf(localpage+addtion));
//		
//		String[][] tableData = getData();
//		String[]  tabletitle = getDataTitle();
//		
//		dataTableModel.setDataVector(tableData, tabletitle);
//	}
//
//	public void setConditonMap(Map<String, String> conditonMap) {
//		this.conditonMap = conditonMap;
//	}
}
