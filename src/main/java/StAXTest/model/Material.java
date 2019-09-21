package StAXTest.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Material {
    //private static long mid;
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String nomenclature;    //номенклатура
    private String unit;            //ед. изм
    private String number;          //кол-во
    private String account;         // счет
    private String costPrice;       //себестоиость

   /* public void setId() {
        mid++;
        this.id = mid;
    }*/

    public String getNomenclature() {
        return nomenclature;
    }

    public void setNomenclature(String nomenclature) {
        this.nomenclature = nomenclature;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(String costPrice) {
        this.costPrice = costPrice;
    }

    @Override
    public String toString() {
        return "Material{" +
                "id=" + id +
                ", nomenclature='" + nomenclature + '\'' +
                ", unit='" + unit + '\'' +
                ", number='" + number + '\'' +
                ", account='" + account + '\'' +
                ", costPrice='" + costPrice + '\'' +
                '}';
    }
}
