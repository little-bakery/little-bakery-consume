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
public class CakePoint implements Serializable, Comparable<CakePoint> {

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

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CakePoint)) {
            return false;
        }
        CakePoint other = (CakePoint) object;
        if ((this.getCake().getId() == null && other.getCake().getId() != null) || (this.getCake().getId() != null && !this.getCake().getId().equals(other.getCake().getId()))) {
            return false;
        }
        return true;
    }
}
