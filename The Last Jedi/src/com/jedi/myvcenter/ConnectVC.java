//package com.jedi.myvcenter;
//
//
//import com.vmware.vim25.InvalidProperty;
//import com.vmware.vim25.ManagedObjectReference;
//import com.vmware.vim25.RuntimeFault;
//import com.vmware.vim25.mo.*;
//
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.rmi.RemoteException;
//
//public class ConnectVC {
//
//    public static void main(String[] args) throws MalformedURLException, RemoteException, RuntimeFault, InvalidProperty {
//        String url = "https://15.212.144.137/sdk/vimService";
//        String user = "administrator@vsphere.local";
//        String password = "12Iso*help";
//
//        ServiceInstance si = new ServiceInstance(new URL(url),user,password,true);
//
//        Folder rootFolder = si.getRootFolder();
//
//        ManagedEntity[] mes = new InventoryNavigator(rootFolder).searchManagedEntities("Datacenter");
//
//        System.out.println(mes[0].getName());
//
//        ManagedObjectReference mor = new ManagedObjectReference();
//        mor.setType("Datacenter");
//        mor.set_value("datacenter-2");
//        Datacenter dc = new Datacenter(si.getServerConnection(),mor);
//        System.out.println(dc.getName());
//
//    }
//}
