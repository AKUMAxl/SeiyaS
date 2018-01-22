package com.xl.SeiyaS.entity;

public class QRcode {

    private String qrcode;

    public QRcode() {
    }

    public QRcode(String qrcode) {
        this.qrcode = qrcode;
    }

    public String getQrcode() {
        return qrcode;
    }

    public void setQrcode(String qrcode) {
        this.qrcode = qrcode;
    }

    @Override
    public String toString() {
        return "QRcode{" +
                "qrcode='" + qrcode + '\'' +
                '}';
    }
}
