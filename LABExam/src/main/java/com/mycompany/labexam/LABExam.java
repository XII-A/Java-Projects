/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.labexam;

import javax.swing.WindowConstants;

/**
 *
 * @author Abdulrazak Armanazi
 * 20290904
 */
public class LABExam {
    public static boolean table_Visible;
    public static boolean insert_Visible;
    public static boolean updatev1_Visible;
    public static boolean updatev2_Visible;
    public static boolean deletev1_Visible;
    public static boolean deletev2_Visible;
    private static Table table = new Table();
    private static Insert insert = new Insert();
    private static Update_v1 updatev1 = new Update_v1();
    static Update_v2 updatev2 = new Update_v2();
    private static Delete_v1 deletev1 = new Delete_v1();
    static Delete_v2 deletev2 = new Delete_v2();
    
    public static int updateIndex;
    public static int deleteIndex;
    //public boolean table_visable;
    
    public static void set_Vis(int i , int index){
        //i = 1 table
        //i = 2 insert 
        //i = 3 updatev1
        //i = 4 updatev2
        //i = 5 deletev1
        
        if(i == 1){
            table_Visible = true;
            insert_Visible = false;
            updatev1_Visible = false;
            updatev2_Visible = false;
            deletev1_Visible = false;
            deletev2_Visible = false;
        }
        if(i == 2){
            table_Visible = false;
            insert_Visible = true;
            updatev1_Visible = false;
            updatev2_Visible = false;
            deletev1_Visible = false;
            deletev2_Visible = false;
        }
        if(i == 3){
            table_Visible = false;
            insert_Visible = false;
            updatev1_Visible = true;
            updatev2_Visible = false;
            deletev1_Visible = false;
            deletev2_Visible = false;
        }
        if(i == 4){
            table_Visible = false;
            insert_Visible = false;
            updatev1_Visible = false;
            deletev1_Visible = false;
            updatev2_Visible = true;
            deletev2_Visible = false;
            updateIndex = index;
        }
        if(i == 5){
            table_Visible = false;
            insert_Visible = false;
            updatev1_Visible = false;
            updatev2_Visible = false;
            deletev1_Visible = true;
            deletev2_Visible = false;
            
        }
        if(i == 6){
            table_Visible = false;
            insert_Visible = false;
            updatev1_Visible = false;
            updatev2_Visible = false;
            deletev1_Visible = false;
            deletev2_Visible = true;
            deleteIndex = index;
        }
        
    }

    public static void main(String[] args) {
        set_Vis(1,0);
        
        table.setVisible(table_Visible);
        insert.setVisible(insert_Visible);
        updatev1.setVisible(updatev1_Visible);
        updatev2.setVisible(updatev2_Visible);
        deletev1.setVisible(deletev1_Visible);
        deletev2.setVisible(deletev2_Visible);
        
        table.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);    
    }
    public static void change_Views(){
         table.setVisible(table_Visible);
         insert.setVisible(insert_Visible);
         updatev1.setVisible(updatev1_Visible);
         updatev2.setVisible(updatev2_Visible);
         deletev1.setVisible(deletev1_Visible);
         deletev2.setVisible(deletev2_Visible);
    }
    
}

