package StAXTest.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Bank {
    //private static long bid;
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String code;       //код
    private String name;       //название
    private String korAcc;     //кор счет
    private String address;    //адрес
    private String tel;        //телефон

    /*public void setId() {
        bid++;
        this.id = bid;
    }*/

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKorAcc() {
        return korAcc;
    }

    public void setKorAcc(String korAcc) {
        this.korAcc = korAcc;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", korAcc='" + korAcc + '\'' +
                ", address='" + address + '\'' +
                ", tel='" + tel + '\'' +
                '}';
    }
}