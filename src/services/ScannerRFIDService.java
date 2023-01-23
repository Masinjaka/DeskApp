package services;

import interfaces.ScannerRFID;

public class ScannerRFIDService {
    private ScannerRFID scanner=new ScannerRFID();
    public ScannerRFIDService(){

    }
    public ScannerRFID getScanner() {
        return scanner;
    }
    public void setScanner(ScannerRFID scanner) {
        this.scanner = scanner;
    }
    
    
}
