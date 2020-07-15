/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duongll.dto;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author duong
 */
@XmlRootElement
public class CakePreparation implements Serializable {

    private Long id;
    private String contentprepare;
    private Integer orderprepare;
    private Cake cakeid;

    public CakePreparation() {
    }

    @XmlElement
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @XmlElement
    public String getContentprepare() {
        return contentprepare;
    }

    public void setContentprepare(String contentprepare) {
        this.contentprepare = contentprepare;
    }

    @XmlElement
    public Integer getOrderprepare() {
        return orderprepare;
    }

    public void setOrderprepare(Integer orderprepare) {
        this.orderprepare = orderprepare;
    }

    @XmlElement
    public Cake getCakeid() {
        return cakeid;
    }

    public void setCakeid(Cake cakeid) {
        this.cakeid = cakeid;
    }

}
