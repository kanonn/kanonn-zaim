package inst.input.panel.panelLogic;

import inst.common.DBOpretor;
import inst.input.panel.InputFinance;

import java.awt.BorderLayout;
import java.util.List;
import java.util.Map;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.apache.log4j.Logger;

public class InputFinanceLogic {
	private static Logger log = Logger.getLogger(InputFinance.class);

//	private DefaultTableModel dataTableModel;
//	private Map<String,String> conditonMap;
	private List<String> dataList;

	/**
	 * 
	 * @param conditonMap
	 * @return
	 */
	public int insertData(){
		
		if(dataList==null){
			return -1;
		}
		
		StringBuffer sql = new StringBuffer();
		
		sql.append(" INSERT INTO temp_test_20160324");
		sql.append(" (col1, col2, col3, col4, col5)");
		sql.append(" VALUES");
		sql.append(" (?, ?, ?, ?, ?)");
		
		DBOpretor db = new DBOpretor();
		db.setSQLSelect(sql.toString());
		db.setParameter(dataList);

		log.info(db.printSQLLog());
		int resultCount = db.updateSQL();
			
		return resultCount;
	}

	public void setDataList(List<String> dataList) {
		this.dataList = dataList;
	}

//	/**
//	 * 
//	 * @return
//	 */
//	private String[] getDataTitle(){
//		String[] tableDataTitle = new  String[2];
//		tableDataTitle[0]="A";
//		tableDataTitle[1]="B";
//		
//		return tableDataTitle;
//	}
//	
//	public JComponent getDataPanel(Map<String,String> conditonMap){
//		JComponent dataPanel;
//		this.conditonMap = conditonMap;
//		
//		String[][] tableData = getData();
//		String[]  tabletitle = getDataTitle();
//		
//		if(tableData==null){
//			dataPanel = new JLabel("no data");
//		}else{
//			this.dataTableModel = new DefaultTableModel(tableData, tabletitle);
//			JTable data = new JTable(dataTableModel);
//			
//			dataPanel = new JPanel();
//			dataPanel.setLayout(new BorderLayout());
//			
//			dataPanel.add(CreatePagePanel(),BorderLayout.NORTH);
//			dataPanel.add(new JScrollPane(data),BorderLayout.SOUTH);
//		}
//		
//		return dataPanel;
//	}
//	
//	/**
//	 * 
//	 */
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
