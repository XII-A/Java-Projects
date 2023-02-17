/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.labexam;
//MY MODEL
import java.awt.List;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author abdul
 */
public class Controller {
    private static JTable dataTable;
    private JTextField filterTextField,idTextField,nameTextField,surnameTextField,telephoneNumTextField,balanceTextField,numFollowersTextField;
    private JLabel  nameLableTxt, surnameLableTxt, telephoneNumLableTxt, subTypeLableTxt, balanceLableTxt, numFollowersLableTxt;
    private JComboBox<String> subTypeCombBox;
    //Model for table
    public Controller(JTable dataTable,JTextField filterTextField){

        this.dataTable = dataTable;
        this.filterTextField = filterTextField;
      
    }
    //Model for insert
    public Controller(JTextField idTextField,JTextField nameTextField,JTextField surnameTextField,JTextField telephoneNumTextField,JComboBox subTypeCombBox,JTextField balanceTextField,JTextField numFollowersTextField){
        this.idTextField = idTextField;
        this.nameTextField = nameTextField;
        this.surnameTextField = surnameTextField;
        this.telephoneNumTextField = telephoneNumTextField;
        this.subTypeCombBox = subTypeCombBox;
        this.balanceTextField = balanceTextField;
        this.numFollowersTextField = numFollowersTextField; 
    }
    //Model for update
    public Controller(JTextField idTextField){
        this.idTextField = idTextField;
    }
    //Model for delete
    public Controller(JTextField idTextField,JLabel nameLableTxt, JLabel surnameLableTxt, JLabel telephoneNumLableTxt, JLabel subTypeLableTxt, JLabel balanceLableTxt, JLabel numFollowersLableTxt){
        this.idTextField = idTextField;
        this.nameLableTxt = nameLableTxt;
        this.surnameLableTxt = surnameLableTxt;
        this.telephoneNumLableTxt = telephoneNumLableTxt;
        this.subTypeLableTxt = subTypeLableTxt;
        this.balanceLableTxt = balanceLableTxt;
        this.numFollowersLableTxt = numFollowersLableTxt; 
    }
    public void filterData(){
        
      
        int[] index = new int[Model.DATA_size];
        int is_Empty = 1;
        
        
        String filter = filterTextField.getText().toUpperCase();
        


        if(filter == null || filter.equals("")){
            Arrays.fill(index, 1);
            is_Empty = 0;

        }else{

            
            for(int i = 0 ; i < Model.DATA_size;i++){
                
                
                if(Model.DATA[i][0].toString().contains(filter)
                    || Model.DATA[i][1].toString().toUpperCase().contains(filter)
                    || Model.DATA[i][2].toString().toUpperCase().contains(filter)
                    || Model.DATA[i][3].toString().toUpperCase().contains(filter)
                    || Model.DATA[i][4].toString().toUpperCase().contains(filter)
                    || Model.DATA[i][5].toString().toUpperCase().contains(filter) 
                    || Model.DATA[i][6].toString().toUpperCase().contains(filter)){
                    //if func
                    index[i] = 1;
                    is_Empty = 0;
                    
             
                }
                
                
             
            }
        }
        //this removes all the rows so only the filtered show up?
        DefaultTableModel defaultTableModel = (DefaultTableModel) dataTable.getModel();

        int rowCount = defaultTableModel.getRowCount();

        for(int i = rowCount-1; i>=0; i--){
            defaultTableModel.removeRow(i);
        }

        if(is_Empty == 1)
        {
            JOptionPane.showMessageDialog(null,"No data found by this filter","Error",JOptionPane.ERROR_MESSAGE);

        }
        for (int i = 0 ; i < Model.DATA_size;i++) {
            Object[] row = new Object[7];
            if(index[i] == 1){
            
                row[0] = Model.DATA[i][0];
                row[1] = Model.DATA[i][1];
                row[2] = Model.DATA[i][2];
                row[3] = Model.DATA[i][3];
                row[4] = Model.DATA[i][4];
                row[5] = Model.DATA[i][5];
                row[6] = Model.DATA[i][6];
                defaultTableModel.addRow(row);
            
            }
           
        }
       

    }
    
    public void refreshTable(){
        DefaultTableModel defaultTableModel = (DefaultTableModel) this.dataTable.getModel();

        int rowCount = defaultTableModel.getRowCount();

        for(int i = rowCount-1; i>=0; i--){
            defaultTableModel.removeRow(i);
        }

        for (int i = 0 ; i < Model.DATA_size;i++) {
            Object[] row = new Object[7];
                row[0] = Model.DATA[i][0];
                row[1] = Model.DATA[i][1];
                row[2] = Model.DATA[i][2];
                row[3] = Model.DATA[i][3];
                row[4] = Model.DATA[i][4];
                row[5] = Model.DATA[i][5];
                row[6] = Model.DATA[i][6];
                defaultTableModel.addRow(row);
            
           
        }
    }
    
    
    //Insert Table funcs
    public void insertData(){
        String id = this.idTextField.getText();
        String name = this.nameTextField.getText();
        String surname = this.surnameTextField.getText();
        String telephoneNumber = this.telephoneNumTextField.getText();
        String subType = this.subTypeCombBox.getSelectedItem().toString();
        String balance = this.balanceTextField.getText();
        String numFollowers = this.numFollowersTextField.getText();
        int id_exists = 0;
        for(int i=0; i<Model.DATA_size; i++){
            if(id.equals(Model.DATA[i][0].toString())){
                id_exists = 1;
            }
        }
        if(id_exists == 1)
        {
            String error_Msg = "There is already a customer with id: " + id;
            JOptionPane.showMessageDialog(null,error_Msg,"Error",JOptionPane.ERROR_MESSAGE);

        }else{
            Object[][] new_DATA = new Object[Model.DATA_size + 1][7];
            for(int i=0; i<Model.DATA_size; i++){
                new_DATA[i][0] = Model.DATA[i][0];
                new_DATA[i][1] = Model.DATA[i][1];
                new_DATA[i][2] = Model.DATA[i][2];
                new_DATA[i][3] = Model.DATA[i][3];
                new_DATA[i][4] = Model.DATA[i][4];
                new_DATA[i][5] = Model.DATA[i][5];
                new_DATA[i][6] = Model.DATA[i][6];
            }
                new_DATA[Model.DATA_size][0] = id;
                new_DATA[Model.DATA_size][1] = name;
                new_DATA[Model.DATA_size][2] = surname;
                new_DATA[Model.DATA_size][3] = telephoneNumber;
                new_DATA[Model.DATA_size][4] = subType;
                new_DATA[Model.DATA_size][5] = balance;
                new_DATA[Model.DATA_size][6] = numFollowers;
                Model.DATA = new_DATA;
                Model.DATA_size++;
                JOptionPane.showMessageDialog(null,"The customer has been succesfully inserted!","Operation Succesful",JOptionPane.PLAIN_MESSAGE);
        }
        
    }
    public void getCustomer(){
        String id = this.idTextField.getText();
        int id_exists = 0;
        int i;
        int comboBoxIndex = 0;
        for(i=0; i<Model.DATA_size; i++){
            if(id.equals(Model.DATA[i][0].toString())){
                id_exists = 1;
                break;
            }
        }
        if(id_exists == 1)
        {
            if(Model.DATA[i][4].toString().equals("None")){
                comboBoxIndex = 0;
            }
            if(Model.DATA[i][4].toString().equals("Premium")){
                comboBoxIndex = 1;
            }
            if(Model.DATA[i][4].toString().equals("Gold Premium")){
                comboBoxIndex = 2;
            }
            if(Model.DATA[i][4].toString().equals("VIP")){
                comboBoxIndex = 3;
            }
            
            
            //System.out.print("I am here "+i);
            LABExam.updatev2.nameTextField.setText(Model.DATA[i][1].toString());
            LABExam.updatev2.surnameTextField.setText(Model.DATA[i][2].toString());
            LABExam.updatev2.telephoneNumTextField.setText(Model.DATA[i][3].toString());
            LABExam.updatev2.subTypeComboBox.setSelectedIndex(comboBoxIndex);
            LABExam.updatev2.balanceTextField.setText(Model.DATA[i][5].toString());
            LABExam.updatev2.numFollowersTextField.setText(Model.DATA[i][6].toString());
            //System.out.print("I am here "+i);
            
            LABExam.set_Vis(4,i);
            LABExam.change_Views();

        }
        else{
            String error_Msg = "There is no customer with id: " + id;
            JOptionPane.showMessageDialog(null,error_Msg,"Error",JOptionPane.ERROR_MESSAGE);
        }
        
    }
    public void updateCustomer(){
        Model.DATA[LABExam.updateIndex][1] = this.nameTextField.getText();
        Model.DATA[LABExam.updateIndex][2] = this.surnameTextField.getText();
        Model.DATA[LABExam.updateIndex][3] = this.telephoneNumTextField.getText();
        Model.DATA[LABExam.updateIndex][4] = this.subTypeCombBox.getSelectedItem().toString();
        Model.DATA[LABExam.updateIndex][5] = this.balanceTextField.getText();
        Model.DATA[LABExam.updateIndex][6] = this.numFollowersTextField.getText();
        JOptionPane.showMessageDialog(null,"The customer has been succesfully updated!","Operation Succesful",JOptionPane.PLAIN_MESSAGE);
    }
    public void getDcustomer(){
        String id = this.idTextField.getText();
        int id_exists = 0;
        int i;
        int comboBoxIndex = 0;
        for(i=0; i<Model.DATA_size; i++){
            if(id.equals(Model.DATA[i][0].toString())){
                id_exists = 1;
                break;
            }
        }
        if(id_exists == 1)
        {
           
            
            //SET LABALES
            LABExam.deletev2.nameLableTxt.setText(Model.DATA[i][1].toString());
            LABExam.deletev2.surnameLableTxt.setText(Model.DATA[i][2].toString());
            LABExam.deletev2.telephoneNumLableTxt.setText(Model.DATA[i][3].toString());
            LABExam.deletev2.subTypeLableTxt.setText(Model.DATA[i][4].toString());
            LABExam.deletev2.balanceLableTxt.setText(Model.DATA[i][5].toString());
            LABExam.deletev2.numFollowersLableTxt.setText(Model.DATA[i][6].toString());
            LABExam.set_Vis(6,i);
            LABExam.change_Views();

        }
        else{
            String error_Msg = "There is no customer with id: " + id;
            JOptionPane.showMessageDialog(null,error_Msg,"Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    public void deleteCustomer(){
        
        Object[][] new_DATA = new Object[Model.DATA_size - 1][7];
        for(int i=0,j=0; j<Model.DATA_size; j++ ){
            if(j == LABExam.deleteIndex){
                continue;
            }else{
                new_DATA[i][0] = Model.DATA[j][0];
                new_DATA[i][1] = Model.DATA[j][1];
                new_DATA[i][2] = Model.DATA[j][2];
                new_DATA[i][3] = Model.DATA[j][3];
                new_DATA[i][4] = Model.DATA[j][4];
                new_DATA[i][5] = Model.DATA[j][5];
                new_DATA[i][6] = Model.DATA[j][6];
                i++;
            }

        }

            Model.DATA = new_DATA;
            Model.DATA_size--;
            JOptionPane.showMessageDialog(null,"The customer has been succesfully deleted!","Operation Succesful",JOptionPane.PLAIN_MESSAGE);
        
    }
    
}
