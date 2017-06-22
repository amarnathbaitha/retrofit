
package info.androidhive.retrofit.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AdditionalData {

    @SerializedName("token")
    @Expose
    private String token;
    @SerializedName("secret")
    @Expose
    private String secret;
    @SerializedName("quoteId")
    @Expose
    private Object quoteId;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public Object getQuoteId() {
        return quoteId;
    }

    public void setQuoteId(Object quoteId) {
        this.quoteId = quoteId;
    }

}
