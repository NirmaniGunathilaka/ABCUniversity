
package abcuniversity;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;


public class StudentDetails extends AbstractTableModel {

    private static final String [] COLUMN_NAMES={"Reg Id","First Name","Last Name","Faculty","Department"};
    private static ArrayList<Student> list;
    
    StudentDetails(ArrayList<Student> stList){
        list=stList;
    }
    
    public String getColumnName(int columnIndex){
        return COLUMN_NAMES[columnIndex];
    }
    @Override
    public int getRowCount() {
       return list.size();
    }

    @Override
    public int getColumnCount() {
       return COLUMN_NAMES.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       switch(columnIndex){
           case 0:return list.get(rowIndex).getRegID();
           case 1:return list.get(rowIndex).getFirstName();
           case 2:return list.get(rowIndex).getLastName();
           case 3:return list.get(rowIndex).getFaculty();
           case 4:return list.get(rowIndex).getDepartment();
           default:return "Error";
       }
    }
    
}
