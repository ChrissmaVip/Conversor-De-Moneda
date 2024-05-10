import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.Map;

public class Moneda {
@SerializedName("USD")
     private double usd;
     @SerializedName("ARS")
     private double ars;
     @SerializedName("COP")
     private double cop;
     @SerializedName("BRL")
     private double brl;

         public Moneda() {
     }

       public double getUsd() {
          return usd;
     }

     public void setUsd(double usd) {
          this.usd = usd;
     }

     public double getArs() {
          return ars;
     }

     public void setArs(double ars) {
          this.ars = ars;
     }

     public double getCop() {
          return cop;
     }

     public void setCop(double cop) {
          this.cop = cop;
     }

     public double getBrl() {
          return brl;
     }

     public void setBrl(double brl) {
          this.brl = brl;
     }

     @Override
     public String toString() {
          return "Moneda{" +
                  "usd=" + usd +
                  ", ars=" + ars +
                  ", cop=" + cop +
                  ", brl=" + brl +
                  '}';
     }
}




