package com.jedi.berry;

public class EntitlementUCA {
    int f1 = 10;
    int f2 = 11;
    int f3 = 30;
    int f4 = 31;

    EntitlementUCA(Entitlement ent) {
        this.f1 = ent.f1;
        this.f2 = ent.f2;
    }

    EntitlementUCA() {

    }

    EntitlementUCA(EntitlementOos ent) {
       this((Entitlement)ent);
       this.f3 = ent.f3;
       this.f4 = ent.f4;
    }

    public static void main(String[] args) {
        EntitlementOos oos1 = new EntitlementOos();
        oos1.f3 = 33;
        oos1.f4 = 34;
        oos1.f1 = 20;
        oos1.f2 = 21;

        EntitlementUCA ent = new EntitlementUCA(oos1);
        System.out.println(ent.f1);
    }
}

class EntitlementOos extends Entitlement
{
    int f3 = 30;
    int f4 = 31;

}

class Entitlement
{
    int f1 = 10;
    int f2 = 11;
}