package com.job.firebasedataandroid;

/**
 * Created by Job on 11/13/2015.
 */
public class CardDataHolder {
    int id;
    String company_name;
    String country;
    String credit_card;
    String email;
    String first_name;
    String last_name;
    CardDataHolder(int id,String company_name,String country, String credit_card,String email, String first_name, String last_name){
        this.id = id;
        this.company_name = company_name;
        this.country = country;
        this.credit_card = credit_card;
        this.email = email;
        this.first_name = first_name;
        this.last_name = last_name;
    }

}
