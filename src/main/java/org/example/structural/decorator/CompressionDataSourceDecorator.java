package org.example.structural.decorator;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;

public class CompressionDataSourceDecorator extends DataSourceDecorator {
    public CompressionDataSourceDecorator(DataSource wrappee) {
        super(wrappee);
    }

    @Override
    public void writeData(String data) {
        super.writeData(compressData(data));
    }

    @Override
    public String readData() {
        return decompressData(super.readData());
    }

    private String compressData(String data) {
        byte[] bytes = data.getBytes();
        try {
            ByteArrayOutputStream bout = new ByteArrayOutputStream(512);
            DeflaterOutputStream dos = new DeflaterOutputStream(bout, new Deflater(6));
            dos.write(bytes);
            dos.close();
            bout.close();
            return Base64
                    .getEncoder()
                    .encodeToString(bout.toByteArray());
        } catch (IOException ex) {
            return null;
        }
    }

    private String decompressData(String data) {
        byte[] bytes = Base64.getDecoder().decode(data);
        try {
            InputStream in = new ByteArrayInputStream(bytes);
            InflaterInputStream iin = new InflaterInputStream(in);
            ByteArrayOutputStream bout = new ByteArrayOutputStream(512);
            int b;
            while ((b = iin.read()) != -1) {
                bout.write(b);
            }
            in.close();
            iin.close();
            bout.close();
            return bout.toString();
        } catch (IOException ex) {
            return null;
        }
    }
}
