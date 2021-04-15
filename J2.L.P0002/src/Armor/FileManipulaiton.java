/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Armor;

import InforAmorDTO.ArmorDTO;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author cutay
 */
public class FileManipulaiton implements Serializable{
    public static List<ArmorDTO> readFile(String filename) {
    List<ArmorDTO> armorList = null;    
        FileReader f = null;
        BufferedReader bf = null;
        SimpleDateFormat format = null;
        try {
            armorList = new Vector<>();  
            f = new FileReader(filename);   
            bf = new BufferedReader(f);     
            format = new SimpleDateFormat("dd/MM/yyyy");  
            while (bf.ready()) {  
                    String line = bf.readLine();           
                    
                    String[] arr = line.split(",");
                if (arr.length == 6) {      
                    ArmorDTO armor = new ArmorDTO(arr[0], arr[1], arr[2], arr[3], 
                            format.parse(arr[4]), Integer.parseInt(arr[5]));
                    armorList.add(armor);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (bf != null) {
                    bf.close();
                }
                if (f != null) {
                    f.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return armorList;
    }
    
    public static void writeFile(String fileName, Vector<ArmorDTO> listArmor) {
        PrintWriter w = null;
        
        try {
            w = new PrintWriter(fileName);
            for (ArmorDTO armorDTO : listArmor) {
                w.println(armorDTO.toString());
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (w != null) {
                    w.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
