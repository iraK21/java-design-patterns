package org.example.structural.decorator;

import java.util.Base64;

public class EncryptionDataSourceDecorator extends DataSourceDecorator {
    public EncryptionDataSourceDecorator(DataSource wrappee) {
        super(wrappee);
    }

    @Override
    public void writeData(String data) {
        super.writeData(encodeData(data));
    }

    @Override
    public String readData() {
        return decodeData(super.readData());
    }

    private String encodeData(String data) {
        byte[] result = data.getBytes();
        for (int i = 0; i < result.length; i++) {
            result[i] += (byte) 1;
        }
        return Base64
                .getEncoder()
                .encodeToString(result);
    }

    private String decodeData(String data) {
        byte[] result = Base64
                .getDecoder()
                .decode(data);
        for (int i = 0; i < result.length; i++) {
            result[i] -= (byte) 1;
        }
        return new String(result);
    }
}
