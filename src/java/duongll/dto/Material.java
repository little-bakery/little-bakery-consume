/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duongll.dto;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author duong
 */
@XmlRootElement
public class Material implements Serializable{
    
    private Long id;
    private String name;
    private String unit;
    private Ingredient ingredientid;

    public Material() {
    }

    @XmlElement
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @XmlElement
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement
    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @XmlTransient
    public Ingredient getIngredientid() {
        return ingredientid;
    }

    public void setIngredientid(Ingredient ingredientid) {
        this.ingredientid = ingredientid;
    }
    
    
}
