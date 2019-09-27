package claw.scctcn;


import java.io.Serializable;

public class ContainerBodyResponse implements Serializable {


    private String result; //查询  001成功 002失败


    private String shipName;  //船名


    private String journeyID;  //航次


    private String IMO;  //IMO


    private String port;  //码头


    private String carrierID; //船公司


    private String bookingNumber;//订舱单号


    private String etcDate;//截关期



    private String container;//柜员


    private String characteristicCode;


    private String sealID;//封志类型/铅封号


    private String message;


    private String cpgInspectFlowEp;


    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public String getJourneyID() {
        return journeyID;
    }

    public void setJourneyID(String journeyID) {
        this.journeyID = journeyID;
    }

    public String getIMO() {
        return IMO;
    }

    public void setIMO(String IMO) {
        this.IMO = IMO;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getCarrierID() {
        return carrierID;
    }

    public void setCarrierID(String carrierID) {
        this.carrierID = carrierID;
    }

    public String getBookingNumber() {
        return bookingNumber;
    }

    public void setBookingNumber(String bookingNumber) {
        this.bookingNumber = bookingNumber;
    }

    public String getEtcDate() {
        return etcDate;
    }

    public void setEtcDate(String etcDate) {
        this.etcDate = etcDate;
    }


    public String getContainer() {
        return container;
    }

    public void setContainer(String container) {
        this.container = container;
    }

    public String getCharacteristicCode() {
        return characteristicCode;
    }

    public void setCharacteristicCode(String characteristicCode) {
        this.characteristicCode = characteristicCode;
    }

    public String getSealID() {
        return sealID;
    }

    public void setSealID(String sealID) {
        this.sealID = sealID;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCpgInspectFlowEp() {
        return cpgInspectFlowEp;
    }

    public void setCpgInspectFlowEp(String cpgInspectFlowEp) {
        this.cpgInspectFlowEp = cpgInspectFlowEp;
    }
}
