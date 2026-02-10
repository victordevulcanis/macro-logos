package com.vulcanis.macrologos.domain.enums;

public enum BiologicalSex {

    MALE(5),
    FEMALE(-161);

    private final int basalAdjustment;

   BiologicalSex(int basalAdjustment){
       this.basalAdjustment = basalAdjustment;
   }

   public int getBasalAdjustment() {
       return basalAdjustment;
   }

}