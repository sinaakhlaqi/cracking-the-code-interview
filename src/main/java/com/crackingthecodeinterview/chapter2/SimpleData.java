package com.crackingthecodeinterview.chapter2;

// SimpleData bean gunna be the list elements with override of hashCode in
// order to "if two instance have same data then they are equals"
public class SimpleData implements Valuable<SimpleData> {
    private final int intData;
    private final String stringData;

    public SimpleData(int someData, String someOtherData) {
        this.intData = someData;
        this.stringData = someOtherData;
    }

    public int getIntData() {
        return intData;
    }

    public String getStringData() {
        return stringData;
    }

    @Override
    public int val() {
        return intData;
    }

    @Override
    public String toString() {
        return String.format("intData: %s & stringData: %s", this.intData, this.stringData);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        else if (obj instanceof SimpleData) {
            return this.intData == ((SimpleData) obj).getIntData()
                    && this.stringData.equals(((SimpleData) obj).getStringData());
        }
        return false;
    }

    @Override
    public int compareTo(SimpleData simpleData) throws NullPointerException {
        if (simpleData == null)
            throw new NullPointerException("null can not be compared in the case of SimpleData");

        if (this == simpleData)
            return 0;
        else if (this.intData == simpleData.intData)
            return this.stringData.compareTo(simpleData.stringData);
        else if (this.intData > simpleData.intData)
            return +1;
        else
            return -1;
    }

    @Override
    public int hashCode() {
        String hashCode = String.valueOf(stringData.hashCode()) +
                intData;
        return Integer.parseInt(hashCode);
    }
}

