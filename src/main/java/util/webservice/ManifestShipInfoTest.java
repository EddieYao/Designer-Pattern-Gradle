package util.webservice;



public class ManifestShipInfoTest {


    public static void main(String[] args) {
        MainfestInterface factory = new MainfestInterface();
        MainfestInterfaceSoap interfaceSoap = factory.getMainfestInterfaceSoap();
        ArrayOfShipInfo shipInfo = interfaceSoap.manifestShipInfo("OOCL KAOHSIUNG","100E", "UN9307009","SCT");
        System.out.println(shipInfo.getShipInfo().get(0).getStatus());
        System.out.println(shipInfo.getShipInfo().get(0).getImo());
        System.out.println(shipInfo.getShipInfo().get(0).getShipNameCn());
        ShipInfo shipInfo1 = shipInfo.getShipInfo().get(0);

        ArrayOfContaInfo arrayOfContaInfo = interfaceSoap.containerInfo("NYKU9748420","SCT");
        System.out.println(arrayOfContaInfo.getContaInfo().get(0).getStatus());
    }
}
