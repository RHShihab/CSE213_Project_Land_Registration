/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Messages;

import Users.*;

/**
 *
 * @author shiha
 */
public class requestList {
    OfferMessage m;
    String sellerName, buyerName, propertyName;
    int askingPrice, finalPrice;

    public requestList(OfferMessage m) {
        this.m = m;
    }

    public OfferMessage getM() {
        return m;
    }

    public String getSellerName() {
        return sellerName;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public int getAskingPrice() {
        return askingPrice;
    }

    public int getFinalPrice() {
        return finalPrice;
    }
    
    
}
