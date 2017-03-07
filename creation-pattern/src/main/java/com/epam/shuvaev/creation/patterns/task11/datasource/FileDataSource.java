package com.epam.shuvaev.creation.patterns.task11.datasource;

/**
 * Created by macbook on 07.03.17
 */
public class FileDataSource implements DataSource {
    /*
     * It is singleton because of file read/write is not thread safe. Also,
     * it is due to number of open handlers
     */
    private static class FileDataSourceHolder {
        private static FileDataSource INSTANCE = new FileDataSource();
    }

    public static FileDataSource getInstance() {
        return FileDataSourceHolder.INSTANCE;
    }

    private FileDataSource() {
        // init access to file
    }

    @Override
    public void setAddress(String address) {
        System.out.println("FILE SOURCE: Set new address: " + address);
    }

    @Override
    public void setName(String name) {
        System.out.println("FILE SOURCE: Set new name: " + name);
    }

    @Override
    public String getAddress(String cardNumber) {
        System.out.println("FILE SOURCE: Get address by card: " + cardNumber);
        return "";
    }

    @Override
    public String getName(String cardNumber) {
        System.out.println("FILE SOURCE: Get name by card" + cardNumber);
        return "";
    }
}
