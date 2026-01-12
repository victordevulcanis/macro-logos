package com.vulcanis.macrologos.domain.enums;

public enum BiologicalSex {

    MALE(5),
    FEMALE(-161);

    private final int adjustNumber;

   BiologicalSex(int basalAdjustment){
       this.adjustNumber = basalAdjustment;
   }

   public int getAdjustNumber() {
       return adjustNumber;
   }

}