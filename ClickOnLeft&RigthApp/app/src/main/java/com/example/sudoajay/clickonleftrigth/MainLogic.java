package com.example.sudoajay.clickonleftrigth;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by sudoajay on 11/8/17.
 */

public class MainLogic {
    private ArrayList<Integer> number = new ArrayList<>();
    private int latest_Choice;


   public MainLogic(String getInterested ) {
    if(getInterested.equals("woman")) {
        Add_Array_For_Woman();
    }else{
        Add_Array_For_man();
    }
       Collections.shuffle(number);

   }

    public ArrayList<Integer> getNumber() {
        return number;
    }

    public void setNumber(ArrayList<Integer> number) {
        this.number = number;
    }
    public void Add_Array_For_Woman(){
        number.add(R.drawable.woman1);
        number.add(R.drawable.woman2);
        number.add(R.drawable.woman3);
        number.add(R.drawable.woman4);
        number.add(R.drawable.woman5);
        number.add(R.drawable.woman6);
        number.add(R.drawable.woman7);
        number.add(R.drawable.woman8);
        number.add(R.drawable.woman9);
        number.add(R.drawable.woman10);
        number.add(R.drawable.woman11);
        number.add(R.drawable.woman12);
        number.add(R.drawable.woman13);
        number.add(R.drawable.woman14);
        number.add(R.drawable.woman15);
        number.add(R.drawable.woman16);
        number.add(R.drawable.woman17);
        number.add(R.drawable.woman18);
        number.add(R.drawable.woman19);
        number.add(R.drawable.woman20);
        number.add(R.drawable.woman21);
        number.add(R.drawable.woman22);
        number.add(R.drawable.woman23);
        number.add(R.drawable.woman24);
        number.add(R.drawable.woman25);
        number.add(R.drawable.woman26);
        number.add(R.drawable.woman27);
        number.add(R.drawable.woman28);
        number.add(R.drawable.woman29);
        number.add(R.drawable.woman30);
        number.add(R.drawable.woman31);
        number.add(R.drawable.woman32);
        number.add(R.drawable.woman33);
        number.add(R.drawable.woman34);
        number.add(R.drawable.woman35);
        number.add(R.drawable.woman36);
        number.add(R.drawable.woman37);
        number.add(R.drawable.woman38);
        number.add(R.drawable.woman39);
        number.add(R.drawable.woman40);
        number.add(R.drawable.woman41);
        number.add(R.drawable.woman42);
        number.add(R.drawable.woman43);
        number.add(R.drawable.woman44);
        number.add(R.drawable.woman45);
        number.add(R.drawable.woman46);
        number.add(R.drawable.woman47);
        number.add(R.drawable.woman48);
        number.add(R.drawable.woman49);
        number.add(R.drawable.woman50);
    }
    public void Add_Array_For_man(){
        number.add(R.drawable.men1);
        number.add(R.drawable.men2);
        number.add(R.drawable.men3);
        number.add(R.drawable.men4);
        number.add(R.drawable.men5);
        number.add(R.drawable.men6);
        number.add(R.drawable.men7);
        number.add(R.drawable.men8);
        number.add(R.drawable.men9);
        number.add(R.drawable.men10);
        number.add(R.drawable.men11);
        number.add(R.drawable.men12);
        number.add(R.drawable.men13);
        number.add(R.drawable.men14);
        number.add(R.drawable.men15);
        number.add(R.drawable.men16);
        number.add(R.drawable.men17);
        number.add(R.drawable.men18);
        number.add(R.drawable.men19);
        number.add(R.drawable.men20);
    }
}
