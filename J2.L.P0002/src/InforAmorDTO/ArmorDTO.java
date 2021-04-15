/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InforAmorDTO;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author cutay
 */
public class ArmorDTO implements Serializable{
    String ArmorId, Classification, Description, Status;
    Date TimeOfCreate;
    int Defense;

    public ArmorDTO() {
        ArmorId = null;
        Classification = null;
        Description = null;
        Status = null;
        TimeOfCreate = null;
        Defense = 0;
    }

    public ArmorDTO(String ArmorId, String Classification, String Description, String Status, Date TimeOfCreate, int Defense) {
        this.ArmorId = ArmorId;
        this.Classification = Classification;
        this.Description = Description;
        this.Status = Status;
        this.TimeOfCreate = TimeOfCreate;
        this.Defense = Defense;
    }

    public String getArmorId() {
        return ArmorId;
    }

    public void setArmorId(String ArmorId) {
        this.ArmorId = ArmorId;
    }

    public String getClassification() {
        return Classification;
    }

    public void setClassification(String Classification) {
        this.Classification = Classification;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public Date getTimeOfCreate() {
        return TimeOfCreate;
    }

    public void setTimeOfCreate(Date TimeOfCreate) {
        this.TimeOfCreate = TimeOfCreate;
    }

    public int getDefense() {
        return Defense;
    }

    public void setDefense(int Defense) {
        this.Defense = Defense;
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFomat = new SimpleDateFormat("dd/MM/yyyy");
        return getArmorId()+ "," + getClassification() + "," + getDescription() + "," + getStatus() + ","+ dateFomat.format(getTimeOfCreate()) + "," + getDefense();
    }
    
    
}
