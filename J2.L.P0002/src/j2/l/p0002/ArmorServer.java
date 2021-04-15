/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j2.l.p0002;

import Armor.FileManipulaiton;
import InforAmorDTO.ArmorDTO;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Vector;
/**
 *
 * @author cutay
 */

public class ArmorServer extends UnicastRemoteObject implements AmorInterface{

    String filename = "ArmorData.txt";

    private List<ArmorDTO> listArmor = null;    
    
    public ArmorServer(String filename) throws RemoteException{
        super();
        this.filename = filename;
    }
    
    @Override
    public boolean createArmor(ArmorDTO dto) throws RemoteException {
        if (findByArmorID(dto.getArmorId()) != null) {
            return false;
        } else {
            listArmor.add(dto);
            FileManipulaiton.writeFile(filename, (Vector<ArmorDTO>) listArmor);
            return true;
        }
    }

    @Override
    public ArmorDTO findByArmorID(String id) throws RemoteException {
        findAllArmor();
        for (ArmorDTO armorDTO : listArmor) {
            if (armorDTO.getArmorId().matches(id)) {
                return armorDTO;
            }
        }
        return null;
    }

    @Override
    public List<ArmorDTO> findAllArmor() throws RemoteException {
        listArmor = FileManipulaiton.readFile(filename);
        return listArmor;
    }

    @Override
    public boolean removeArmor(String id) throws RemoteException {
        ArmorDTO armor = findByArmorID(id);
        listArmor.remove(armor);
        FileManipulaiton.writeFile(filename, (Vector<ArmorDTO>) listArmor);
        return true;
    }

    @Override
    public boolean updateArmor(ArmorDTO dto) throws RemoteException {
        ArmorDTO armor = findByArmorID(dto.getArmorId());
        listArmor.remove(armor);
        listArmor.add(dto);
        FileManipulaiton.writeFile(filename, (Vector<ArmorDTO>) listArmor);
        return true;
    }
}
