
package info.androidhive.retrofit.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum {

    @SerializedName("customer_id")
    @Expose
    private String customerId;
    @SerializedName("sciblings")
    @Expose
    private String sciblings;
    @SerializedName("unit")
    @Expose
    private Object unit;
    @SerializedName("qty")
    @Expose
    private Object qty;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getSciblings() {
        return sciblings;
    }

    public void setSciblings(String sciblings) {
        this.sciblings = sciblings;
    }

    public Object getUnit() {
        return unit;
    }

    public void setUnit(Object unit) {
        this.unit = unit;
    }

    public Object getQty() {
        return qty;
    }

    public void setQty(Object qty) {
        this.qty = qty;
    }

}
