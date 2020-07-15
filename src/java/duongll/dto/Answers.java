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
public class Answers implements Serializable{
    
    private Long id;
    private String name;
    private Questions questionid;
    private Integer point;   

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
    public Questions getQuestionid() {
        return questionid;
    }

    public void setQuestionid(Questions questionid) {
        this.questionid = questionid;
    }

    @XmlElement
    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }
    
    
}
