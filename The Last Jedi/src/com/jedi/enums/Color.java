package com.jedi.enums;

import java.util.Arrays;
import java.util.Calendar;
public enum Color {
    RED(Boolean.TRUE){
        @Override
        public void setIsAllowed(Boolean val)
        {
            isAllowed = Boolean.FALSE;
        }
    },
    GREEN(Boolean.FALSE),
    BLUE(Boolean.TRUE);

    Boolean isAllowed;
    private boolean myVar;
    Color(Boolean val)
    {
        isAllowed = val;
    }

    public void setIsAllowed(Boolean val)
    {
        this.isAllowed = val;
    }

    public static void main(String[] args) {
        System.out.println(BLUE);
        Color c = Color.RED;
        if(c.equals(Color.RED))
        {
            System.out.println("yess");
        }
        System.out.println(Color.RED.toString() == "RED");     // this toString is defined in Enum.java
                                                      // which all enum extends by default
        System.out.println(Color.RED);
        System.out.println(RED.isAllowed);
        RED.setIsAllowed(Boolean.FALSE);
        System.out.println(RED.isAllowed);
        System.out.println(Arrays.toString(Color.values()));
        System.out.println(Color.valueOf("RED"));
    }

}
