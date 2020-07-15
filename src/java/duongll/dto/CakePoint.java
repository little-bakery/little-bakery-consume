/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duongll.dto;

import java.io.Serializable;

/**
 *
 * @author duong
 */
public class CakePoint implements Serializable, Comparable<CakePoint>{
   
    private Cake cake;
    private Integer point;

    public Cake getCake() {
        return cake;
    }

    public void setCake(Cake cake) {
        this.cake = cake;
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    @Override
    public int compareTo(CakePoint that) {
        return that.getCake().getViews() - this.getCake().getViews();
    }
}
