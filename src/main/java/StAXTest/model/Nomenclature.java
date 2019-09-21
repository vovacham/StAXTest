package StAXTest.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Nomenclature {
    //private static long nid;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String code;     //код
    private String descr;    //описание
    private String type;     //тип

    /*public void setId() {
        nid++;
        this.id = nid;
    }*/


    public Nomenclature() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
