/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duongll.dto;

import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author duong
 */
@XmlRootElement
public class CakeWeight implements Serializable{
    
    private Long id;
    private Cake cakeid;
    private Answers answerid;

    public CakeWeight() {
    }

    @XmlElement
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @XmlElement
    public Cake getCakeid() {
        return cakeid;
    }

    public void setCakeid(Cake cakeid) {
        this.cakeid = cakeid;
    }

    @XmlElement
    public Answers getAnswerid() {
        return answerid;
    }

    public void setAnswerid(Answers answerid) {
        this.answerid = answerid;
    }
    
    
}
