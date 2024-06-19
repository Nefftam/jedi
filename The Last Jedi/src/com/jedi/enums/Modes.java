package com.jedi.enums;

public enum Modes {
    MODE_ONE (Boolean.TRUE){
        @Override public boolean canDoA() {
            return true;
        }
    },
    MODE_TWO(Boolean.TRUE) {
        @Override public boolean canDoB() {
            return true;
        }
    },
    MODE_THREE(Boolean.TRUE) {
        @Override public boolean canDoC() {
            return true;
        }
    };

    Modes(Boolean val)
    {

    }

    public boolean canDoA() {
        return false;
    }

    public boolean canDoB() {
        return false;
    }

    public boolean canDoC() {
        return false;
    }

}