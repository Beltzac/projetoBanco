/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projetobanco;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Codification
 */
public class ModeloTabela extends AbstractTableModel {

    String[] header = {"Nome", "Sobrenome", "RG", "CPF", "SalÃ¡rio"};
    ArrayList<Cliente> clientes = new ArrayList<>();//nome sobrenome rg cpf salario

    @Override
    public String getColumnName(int column) {
        return header[column];
    }

    @Override
    public int getRowCount() {
        return clientes.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return clientes.get(rowIndex).getNome();
            case 1:
                return clientes.get(rowIndex).getSobrenome();
            case 2:
                return clientes.get(rowIndex).getRG();
            case 3:
                return clientes.get(rowIndex).getCPF();
            case 4:
                return "R$ " + clientes.get(rowIndex).getSalario();
        }
        return null;
    }

    public Object getValueAt(int rowIndex) {
        return clientes.get(rowIndex);

    }

    public void setDataUpdate(ArrayList<Cliente> c) {
        clientes = c;
        //fireTableDataChanged();
        this.fireTableRowsUpdated(0,c.size() - 1);
        //this.fireTableRowsInserted(0,c.size() - 1);
    }
    
    public void setDataChange(ArrayList<Cliente> c) {
        clientes = c;
        //fireTableDataChanged();
        this.fireTableRowsInserted(0,c.size() - 1);
    }
    
}
