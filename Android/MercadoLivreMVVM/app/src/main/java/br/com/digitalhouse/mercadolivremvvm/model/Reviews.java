
package br.com.digitalhouse.mercadolivremvvm.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Reviews {

    @SerializedName("rating_average")
    private Double ratingAverage;
    @Expose
    private Long total;

    public Double getRatingAverage() {
        return ratingAverage;
    }

    public void setRatingAverage(Double ratingAverage) {
        this.ratingAverage = ratingAverage;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

}
