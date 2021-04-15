/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j2.l.p0002;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

/**
 *
 * @author cutay
 */
public class ManagerServerProgram {
    public static void main(String[] args) {
        String fileName = "ArmorData.txt";
        try {
            LocateRegistry.createRegistry(1098);
            AmorInterface c = new ArmorServer(fileName);
            String serviceName = "rmi://localhost:1098/ArmorService";
            Naming.rebind(serviceName, c);
            System.out.println("ok");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
