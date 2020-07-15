/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duongll.dto;

import java.io.Serializable;
import java.util.Collection;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author duong
 */
@XmlRootElement
public class Cake implements Serializable {

    private Long id;
    private String name;
    private String description;
    private String image;
    private String link;
    private String time;
    private Integer serves;
    private Integer views;
    private Category categoryid;
    private Collection<CakePreparation> cakePreparations;
    private Collection<Ingredient> ingredientCollection;

    public Cake() {
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
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlElement
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @XmlElement
    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @XmlElement
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @XmlElement
    public Integer getServes() {
        return serves;
    }

    public void setServes(Integer serves) {
        this.serves = serves;
    }

    @XmlElement
    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    @XmlElement
    public Category getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Category categoryid) {
        this.categoryid = categoryid;
    }

    @XmlElement
    public Collection<Ingredient> getIngredientCollection() {
        return ingredientCollection;
    }

    public void setIngredientCollection(Collection<Ingredient> ingredientCollection) {
        this.ingredientCollection = ingredientCollection;
    }

    @XmlElement
    public Collection<CakePreparation> getCakePreparations() {
        return cakePreparations;
    }

    public void setCakePreparations(Collection<CakePreparation> cakePreparations) {
        this.cakePreparations = cakePreparations;
    }

}
