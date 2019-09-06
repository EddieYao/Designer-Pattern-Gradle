package util.webservice;



public class ManifestShipInfoTest {


    public static void main(String[] args) {
        MainfestInterface factory = new MainfestInterface();
        MainfestInterfaceSoap interfaceSoap = factory.getMainfestInterfaceSoap();
//        ArrayOfShipInfo shipInfo = interfaceSoap.manifestShipInfo("OOCL KAOHSIUNG","100E", "","SCT");
//        System.out.println(shipInfo.getShipInfo().get(0).getStatus());
//        System.out.println(shipInfo.getShipInfo().get(0).getImo());
//        System.out.println(shipInfo.getShipInfo().get(0).getShipNameCn());
//        ShipInfo shipInfo1 = shipInfo.getShipInfo().get(0);

        ArrayOfContaInfo arrayOfContaInfo = interfaceSoap.containerInfo("TCLU4926045","SCT");
        System.out.println(arrayOfContaInfo.getContaInfo().get(0).getStatus());
        System.out.println(arrayOfContaInfo.getContaInfo().get(0).getCarrier());
        System.out.println(arrayOfContaInfo.getContaInfo().get(0).getContaId());
        System.out.println(arrayOfContaInfo.getContaInfo().get(0).getContaSize());
        System.out.println(arrayOfContaInfo.getContaInfo().get(0).getContaType());
        System.out.println(arrayOfContaInfo.getContaInfo().get(0).getDockCode());
        System.out.println(arrayOfContaInfo.getContaInfo().get(0).getImo());
        System.out.println(arrayOfContaInfo.getContaInfo().get(0).getLockNo());
        System.out.println(arrayOfContaInfo.getContaInfo().get(0).getShipName());
        System.out.println(arrayOfContaInfo.getContaInfo().get(0).getVoyNo());
        System.out.println(arrayOfContaInfo.getContaInfo().get(0).getSizeType());
        long startTime =  System.currentTimeMillis();

        ArrayOfContaInfo arrayOfContaInfo2 = null;
        try {
//            Thread.sleep(3000);
//            arrayOfContaInfo2 = interfaceSoap.containerInfo("CSLU1480951","CCT");
        } catch (Exception e) {
            e.printStackTrace();
        }
        long endTime =  System.currentTimeMillis();
        long usedTime = (endTime-startTime)/1000;
        System.out.println(usedTime);
//        System.out.println(arrayOfContaInfo2.getContaInfo().get(0).getStatus());
//        System.out.println(arrayOfContaInfo2.getContaInfo().get(0).getSizeType());
    }
}
